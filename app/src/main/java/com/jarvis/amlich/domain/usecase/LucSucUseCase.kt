package com.jarvis.amlich.domain.usecase

import com.jarvis.amlich.domain.model.LucSucModel
import com.jarvis.amlich.domain.repository.QueRepository
import com.jarvis.amlich.domain.usecase.base.BaseUseCaseInt
import org.koin.core.component.inject

class LucSucUseCase : BaseUseCaseInt<LucSucModel,Int>() {

    private val queRepository: QueRepository by inject()

    override suspend fun invoke(idQue: Int): LucSucModel {
        return queRepository.getLucSuc(idQue)
    }
}