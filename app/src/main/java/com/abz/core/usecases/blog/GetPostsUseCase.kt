package com.abz.core.usecases.blog

import com.abz.arch.extensions.useCaseFlow
import com.abz.core.data.repositories.PostRepository
import com.abz.injection.qualifiers.DefaultDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(
    private val postRepository: PostRepository,
    @DefaultDispatcher private val coroutineDispatcher: CoroutineDispatcher
) {
    fun getPosts() = useCaseFlow(coroutineDispatcher) {
        postRepository.getPosts()
    }
}