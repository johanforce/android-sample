package com.jarvis.amlich.domain.repository

import com.jarvis.amlich.domain.model.*

interface QueRepository {

    suspend fun getAllQue(): List<QueModel>

    suspend fun getIdQue(idQue: Int): QueModel

    suspend fun getBuonBan(idQue: Int): BuonBanModel

    suspend fun getDoanBenh(idQue: Int): DoanBenhModel

    suspend fun getGiaDao(idQue: Int): GiaDaoModel

    suspend fun getHonNhan(idQue: Int): HonNhanModel

    suspend fun getKienTung(idQue: Int): KienTungModel

    suspend fun getLucSuc(idQue: Int): LucSucModel

    suspend fun getMuuVong(idQue: Int): MuuVongModel

    suspend fun getNguoiDi(idQue: Int): NguoiDiModel

    suspend fun getThatVat(idQue: Int): ThatVatModel

    suspend fun getTuoiMang(idQue: Int): TuoiMangModel

    suspend fun getAllVanKhan(): List<VanKhanModel>

    suspend fun getVanKhanId(idQue: Int): VanKhanModel
}
