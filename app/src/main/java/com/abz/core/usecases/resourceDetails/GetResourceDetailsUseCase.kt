package com.abz.core.usecases.resourceDetails

import com.abz.arch.extensions.useCaseFlow
import com.abz.core.data.repositories.ResourceRepository
import com.abz.injection.qualifiers.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetResourceDetailsUseCase @Inject constructor(
    private val resourceRepository: ResourceRepository,
    @IoDispatcher private val coroutineDispatcher: CoroutineDispatcher
) {
    operator fun invoke(id: Int) = useCaseFlow(coroutineDispatcher = coroutineDispatcher) {
        resourceRepository.getResourcesDetails(id)
    }


}