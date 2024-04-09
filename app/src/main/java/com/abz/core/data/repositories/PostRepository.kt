package com.abz.core.data.repositories

import com.abz.arch.data.Repository
import com.abz.arch.extensions.mapSuccess
import com.abz.core.data.network.Api
import com.abz.core.data.network.dtos.toEntity
import com.abz.core.data.storage.PostPreferenceStore
import com.abz.core.domain.model.Post
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val api: Api,
    private val postPreferenceStore: PostPreferenceStore
) : Repository() {

    suspend fun getPosts(): List<Post> {
        return api.getPosts()
            .mapSuccess { list -> list.map { it as Post } }
            .also { postPreferenceStore.addAll(it) }
    }
}