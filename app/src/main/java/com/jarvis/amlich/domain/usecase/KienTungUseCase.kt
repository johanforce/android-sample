package com.jarvis.amlich.domain.usecase

import com.jarvis.amlich.domain.model.KienTungModel
import com.jarvis.amlich.domain.repository.QueRepository
import com.jarvis.amlich.domain.usecase.base.BaseUseCaseInt
import org.koin.core.component.inject

class KienTungUseCase : BaseUseCaseInt<KienTungModel, Int>() {

    private val queRepository: QueRepository by inject()

    override suspend fun invoke(idQue: Int): KienTungModel {
        return queRepository.getKienTung(idQue)
    }
}
