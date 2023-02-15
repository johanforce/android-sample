package com.jarvis.amlich.domain.usecase

import com.jarvis.amlich.domain.model.BuonBanModel
import com.jarvis.amlich.domain.repository.QueRepository
import com.jarvis.amlich.domain.usecase.base.BaseUseCaseInt
import org.koin.core.component.inject

class BuonBanUseCase : BaseUseCaseInt<BuonBanModel, Int>() {

    private val queRepository: QueRepository by inject()

    override suspend fun invoke(input: Int): BuonBanModel {
        return queRepository.getBuonBan(input)
    }
}
