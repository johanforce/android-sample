package com.jarvis.amlich.domain.usecase

import com.jarvis.amlich.domain.model.HonNhanModel
import com.jarvis.amlich.domain.repository.QueRepository
import com.jarvis.amlich.domain.usecase.base.BaseUseCaseInt
import org.koin.core.component.inject

class HonNhanUseCase : BaseUseCaseInt<HonNhanModel, Int>() {

    private val queRepository: QueRepository by inject()

    override suspend fun invoke(idQue: Int): HonNhanModel {
        return queRepository.getHonNhan(idQue)
    }
}
