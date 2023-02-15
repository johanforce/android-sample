package com.jarvis.amlich.di


import com.jarvis.amlich.domain.usecase.*
import org.koin.dsl.module

val useCaseModule = module {
    single { BuonBanUseCase() }
    single { DoanBenhUseCase() }
    single { GiaDaoUseCase() }
    single { HonNhanUseCase() }
    single { KienTungUseCase() }
    single { LucSucUseCase() }
    single { MuuVOngUseCase() }
    single { NguoiDiUseCase() }
    single { QueIdUseCase() }
    single { QueUseCase() }
    single { ThatVatUseCase() }
    single { TuoiMangUseCase() }
    single { VanKhanUseCase() }
}
