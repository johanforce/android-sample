package com.jarvis.amlich.domain.usecase

import com.jarvis.amlich.domain.model.GiaDaoModel
import com.jarvis.amlich.domain.repository.QueRepository
import com.jarvis.amlich.domain.usecase.base.BaseUseCaseInt
import org.koin.core.component.inject

class GiaDaoUseCase : BaseUseCaseInt<GiaDaoModel, Int>() {

    private val queRepository: QueRepository by inject()

    override suspend fun invoke(idQue: Int): GiaDaoModel {
        return queRepository.getGiaDao(idQue)
    }
}
