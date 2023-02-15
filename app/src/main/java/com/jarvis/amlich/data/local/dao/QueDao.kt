package com.jarvis.amlich.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.jarvis.amlich.data.entity.*

@Dao
interface QueDao {

    @Query("SELECT * FROM que")
    suspend fun getAll(): List<QueEntity>

    @Query("SELECT * FROM que WHERE stt = :idQue")
    suspend fun getIdQue(idQue: Int): QueEntity

    @Query("SELECT * FROM buon_ban WHERE id = :idQue")
    suspend fun getBuonBan(idQue: Int): BuonBanEntity

    @Query("SELECT * FROM doan_benh WHERE id = :idQue")
    suspend fun getDoanBenh(idQue: Int): DoanBenhEntity

    @Query("SELECT * FROM gia_dao WHERE id = :idQue")
    suspend fun getGiaDao(idQue: Int): GiaDaoEntity

    @Query("SELECT * FROM hon_nhan WHERE id = :idQue")
    suspend fun getHonNhan(idQue: Int): HonNhanEntity

    @Query("SELECT * FROM kien_tung WHERE id = :idQue")
    suspend fun getKienTung(idQue: Int): KienTungEntity

    @Query("SELECT * FROM luc_suc WHERE id = :idQue")
    suspend fun getLucSuc(idQue: Int): LucSucEntity

    @Query("SELECT * FROM muu_vong WHERE id = :idQue")
    suspend fun getMuuVong(idQue: Int): MuuVongEntity

    @Query("SELECT * FROM nguoi_di WHERE id = :idQue")
    suspend fun getNguoiDi(idQue: Int): NguoiDiEntity

    @Query("SELECT * FROM that_vat WHERE id = :idQue")
    suspend fun getThatVat(idQue: Int): ThatVatEntity

    @Query("SELECT * FROM tuoi_mang WHERE id = :idQue")
    suspend fun getTuoiMang(idQue: Int): TuoiMangEntity

    @Query("SELECT * FROM van_khan ")
    suspend fun getAllVanKhan(): List<VanKhanEntity>

    @Query("SELECT * FROM van_khan WHERE id = :id")
    suspend fun getAllVanKhanId(id: Int): VanKhanEntity
}
