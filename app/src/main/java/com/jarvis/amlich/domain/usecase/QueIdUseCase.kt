package com.jarvis.amlich.domain.usecase

import com.jarvis.amlich.domain.model.QueModel
import com.jarvis.amlich.domain.repository.QueRepository
import com.jarvis.amlich.domain.usecase.base.BaseUseCaseInt
import org.koin.core.component.inject

class QueIdUseCase : BaseUseCaseInt<QueModel, Int>() {

    private val queRepository: QueRepository by inject()

    override suspend fun invoke(idQue: Int): QueModel {
        return queRepository.getIdQue(idQue)
    }
}
