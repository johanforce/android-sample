package com.jarvis.amlich.data.repository

import com.jarvis.amlich.data.entity.QueEntity
import com.jarvis.amlich.data.local.AppDatabase
import com.jarvis.amlich.domain.model.*
import com.jarvis.amlich.domain.repository.QueRepository

class QueRepositoryImpl(
    private val database: AppDatabase,
) : QueRepository {
    override suspend fun getAllQue(): List<QueModel> {
        return database.queDao().getAll().map(QueEntity::toModel)
    }

    override suspend fun getIdQue(idQue: Int): QueModel {
        return database.queDao().getIdQue(idQue).toModel()
    }

    override suspend fun getBuonBan(idQue: Int): BuonBanModel {
        return database.queDao().getBuonBan(idQue).toModel()
    }

    override suspend fun getDoanBenh(idQue: Int): DoanBenhModel {
        return database.queDao().getDoanBenh(idQue).toModel()
    }

    override suspend fun getGiaDao(idQue: Int): GiaDaoModel {
        return database.queDao().getGiaDao(idQue).toModel()
    }

    override suspend fun getHonNhan(idQue: Int): HonNhanModel {
        return database.queDao().getHonNhan(idQue).toModel()
    }

    override suspend fun getKienTung(idQue: Int): KienTungModel {
        return database.queDao().getKienTung(idQue).toModel()
    }

    override suspend fun getLucSuc(idQue: Int): LucSucModel {
        return database.queDao().getLucSuc(idQue).toModel()
    }

    override suspend fun getMuuVong(idQue: Int): MuuVongModel {
        return database.queDao().getMuuVong(idQue).toModel()
    }

    override suspend fun getNguoiDi(idQue: Int): NguoiDiModel {
        return database.queDao().getNguoiDi(idQue).toModel()
    }

    override suspend fun getThatVat(idQue: Int): ThatVatModel {
        return database.queDao().getThatVat(idQue).toModel()
    }

    override suspend fun getTuoiMang(idQue: Int): TuoiMangModel {
        return database.queDao().getTuoiMang(idQue).toModel()
    }

    override suspend fun getAllVanKhan(): List<VanKhanModel> {
        return database.queDao().getAllVanKhan().map { it.toModel() }
    }

    override suspend fun getVanKhanId(id: Int): VanKhanModel {
        return database.queDao().getAllVanKhanId(id).toModel()
    }
}
