package com.abz.core.data.network.dtos

import com.abz.core.domain.model.Post

fun PostDto.toEntity(): Post {
    return Post(
        id = id,
        title = title,
        body = body
    )
}