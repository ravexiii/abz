package com.abz.core.data.network.dtos

import com.abz.core.pagination.model.Resource

fun ResourceDto.toEntity(): Resource {
    return Resource(
        id = id,
        name = name
    )
}