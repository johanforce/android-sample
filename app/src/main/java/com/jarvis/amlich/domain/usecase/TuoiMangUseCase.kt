package com.jarvis.amlich.domain.usecase

import com.jarvis.amlich.domain.model.TuoiMangModel
import com.jarvis.amlich.domain.repository.QueRepository
import com.jarvis.amlich.domain.usecase.base.BaseUseCaseInt
import org.koin.core.component.inject

class TuoiMangUseCase : BaseUseCaseInt<TuoiMangModel, Int>() {

    private val queRepository: QueRepository by inject()

    override suspend fun invoke(idQue: Int): TuoiMangModel {
        return queRepository.getTuoiMang(idQue)
    }

}
