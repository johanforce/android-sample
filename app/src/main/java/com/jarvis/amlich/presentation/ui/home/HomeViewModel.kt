package com.jarvis.amlich.presentation.ui.home

import com.jarvis.amlich.base.BaseViewModel
import com.jarvis.amlich.common.utils.SingleLiveData
import com.jarvis.amlich.domain.model.QueModel
import com.jarvis.amlich.domain.usecase.QueUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.component.inject

class HomeViewModel : BaseViewModel() {
    private val queUseCase: QueUseCase by inject()

    val listQueLiveData = SingleLiveData<List<QueModel>>()

    fun getAllQueData() {
        executeTask(onExecute = {
            mLoading.value = true
            val listQue = withContext(Dispatchers.IO) {
                queUseCase.invoke()
            }
            listQueLiveData.postValue(listQue)
            mLoading.value = false
        })
    }
}
