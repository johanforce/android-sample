package com.jarvis.amlich.domain.usecase

import com.jarvis.amlich.domain.model.QueModel
import com.jarvis.amlich.domain.repository.QueRepository
import com.jarvis.amlich.domain.usecase.base.NoParamUseCase
import org.koin.core.component.inject

class QueUseCase : NoParamUseCase<List<QueModel>>() {

    private val queRepository: QueRepository by inject()

    override suspend fun invoke(): List<QueModel> {
        return queRepository.getAllQue()
    }
}
