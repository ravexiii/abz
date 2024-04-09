package com.abz.features.resources

import androidx.lifecycle.ViewModel
import com.abz.arch.extensions.LoadingAware
import com.abz.arch.extensions.ViewErrorAware
import com.abz.core.sharedui.errorhandling.ViewError
import com.abz.core.usecases.resources.GetResourcesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class ResourceViewModel @Inject constructor(
    getResourcesUseCase: GetResourcesUseCase
) : ViewModel(), ViewErrorAware, LoadingAware {
    //var resourceResult = getResourcesUseCase()

    //var resourceResult = getResourcesUseCase()
    val loadingFlow = MutableStateFlow(false)
    val errorFlow = MutableSharedFlow<ViewError>()




}