package com.abz.core.usecases.user

import com.abz.arch.extensions.useCaseFlow
import com.abz.core.data.repositories.UserRepository
import com.abz.injection.qualifiers.DefaultDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val userRepository: UserRepository,
    @DefaultDispatcher private val coroutineDispatcher: CoroutineDispatcher
) {

    fun login(email: String, password: String) =
        useCaseFlow(coroutineDispatcher) {
            userRepository.login(email, password)
            userRepository.getUser()
        }
}