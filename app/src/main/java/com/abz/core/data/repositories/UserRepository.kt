package com.abz.core.data.repositories

import com.abz.arch.data.Repository
import com.abz.arch.extensions.mapSuccess
import com.abz.arch.extensions.repoCall
import com.abz.core.data.network.Api
import com.abz.core.data.network.dtos.toUser
import com.abz.core.data.network.responses.TokenResponse
import com.abz.core.data.storage.UserPreferenceStore
import com.abz.core.domain.model.User
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val api: Api,
    private val userPreferenceStore: UserPreferenceStore
) : Repository() {

    suspend fun login(email: String, password: String): TokenResponse = repoCall {
        api.postLogin(email, password)
    }

    suspend fun getUser(): User {
        return api.getUser()
            .mapSuccess {
                it.data.toUser()
            }.also {
                userPreferenceStore.add(it)
            }
    }
}