package com.abz.core.data.repositories

import com.abz.arch.data.Repository
import com.abz.arch.extensions.mapSuccess
import com.abz.core.data.network.Api
import com.abz.core.data.network.dtos.toEntity
import com.abz.core.domain.model.ResourceDetails
import com.abz.core.pagination.model.Resource
import javax.inject.Inject

class ResourceRepository @Inject constructor(
    private val api: Api,
) : Repository() {

    suspend fun getResources(page: Int, pageSize: Int): List<Resource> {
        return api.getResources(page, pageSize)
            .mapSuccess { response -> response.map { it.toEntity() } }
    }

    suspend fun getResourcesDetails(id: Int): ResourceDetails {
        return api.getResourcesDetails(id)
            .mapSuccess {
                it[0].toEntity()
            }
    }


}