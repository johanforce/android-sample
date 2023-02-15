package com.jarvis.amlich.di

import com.jarvis.amlich.data.repository.QueRepositoryImpl
import com.jarvis.amlich.domain.repository.QueRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<QueRepository> {
        QueRepositoryImpl(database = get())
    }
}
