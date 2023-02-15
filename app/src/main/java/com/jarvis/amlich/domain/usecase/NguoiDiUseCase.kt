package com.jarvis.amlich.domain.usecase

import com.jarvis.amlich.domain.model.NguoiDiModel
import com.jarvis.amlich.domain.repository.QueRepository
import com.jarvis.amlich.domain.usecase.base.BaseUseCaseInt
import org.koin.core.component.inject

class NguoiDiUseCase : BaseUseCaseInt<NguoiDiModel, Int>() {

    private val queRepository: QueRepository by inject()

    override suspend fun invoke(idQue: Int): NguoiDiModel {
        return queRepository.getNguoiDi(idQue)
    }
}
