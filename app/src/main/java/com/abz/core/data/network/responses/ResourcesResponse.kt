package com.abz.core.data.network.responses

import com.abz.core.data.network.dtos.ResourceDto
import kotlinx.serialization.Serializable

@Serializable
data class ResourcesResponse(
    val data: List<ResourceDto>
)