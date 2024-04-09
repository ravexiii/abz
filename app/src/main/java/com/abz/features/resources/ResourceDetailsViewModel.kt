package com.abz.features.resources

import androidx.lifecycle.ViewModel
import com.abz.arch.extensions.LoadingAware
import com.abz.arch.extensions.ViewErrorAware
import com.abz.arch.extensions.collectFlow
import com.abz.core.domain.model.ResourceDetails
import com.abz.core.usecases.resourceDetails.GetResourceDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class ResourceDetailsViewModel @Inject constructor(
    private val getResourceDetailsUseCase: GetResourceDetailsUseCase
) : ViewModel(), ViewErrorAware, LoadingAware {
   val resourceDetails = MutableStateFlow(ResourceDetails(-1, "", ""))

    fun getResourceDetails(id: Int) {
        collectFlow(getResourceDetailsUseCase(id)) {
            resourceDetails.value = it
        }
    }

}