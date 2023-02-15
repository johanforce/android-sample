package com.jarvis.amlich.domain.usecase

import com.jarvis.amlich.domain.model.DoanBenhModel
import com.jarvis.amlich.domain.repository.QueRepository
import com.jarvis.amlich.domain.usecase.base.BaseUseCaseInt
import org.koin.core.component.inject

class DoanBenhUseCase : BaseUseCaseInt<DoanBenhModel, Int>() {

    private val queRepository: QueRepository by inject()

    override suspend fun invoke(idQue: Int): DoanBenhModel {
        return queRepository.getDoanBenh(idQue)
    }

}
