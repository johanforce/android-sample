package com.jarvis.amlich.di

import com.jarvis.amlich.data.local.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    single {
        AppDatabase.build(androidContext())
    }
}
