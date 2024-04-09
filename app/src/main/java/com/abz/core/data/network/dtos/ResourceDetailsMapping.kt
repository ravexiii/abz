package com.abz.core.data.network.dtos

import com.abz.core.domain.model.ResourceDetails

fun ResourceDetailsDto.toEntity(): ResourceDetails {
    return ResourceDetails(
        id = id,
        name = name,
        imageUrl = imageUrl
    )
}