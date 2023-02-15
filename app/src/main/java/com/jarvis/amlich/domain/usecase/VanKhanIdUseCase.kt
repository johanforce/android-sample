package com.jarvis.amlich.domain.usecase

import com.jarvis.amlich.domain.model.VanKhanModel
import com.jarvis.amlich.domain.repository.QueRepository
import com.jarvis.amlich.domain.usecase.base.BaseUseCaseInt
import org.koin.core.component.inject

class VanKhanIdUseCase : BaseUseCaseInt<VanKhanModel, Int>() {

    private val queRepository: QueRepository by inject()

    override suspend fun invoke(id: Int): VanKhanModel {
        return queRepository.getVanKhanId(id)
    }

}
