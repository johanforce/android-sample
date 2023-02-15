package com.jarvis.amlich.domain.usecase

import com.jarvis.amlich.domain.model.ThatVatModel
import com.jarvis.amlich.domain.repository.QueRepository
import com.jarvis.amlich.domain.usecase.base.BaseUseCaseInt
import org.koin.core.component.inject

class ThatVatUseCase : BaseUseCaseInt<ThatVatModel, Int>() {

    private val queRepository: QueRepository by inject()

    override suspend fun invoke(idQue: Int): ThatVatModel {
        return queRepository.getThatVat(idQue)
    }
}
