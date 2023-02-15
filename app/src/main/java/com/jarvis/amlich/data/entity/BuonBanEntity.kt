package com.jarvis.amlich.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jarvis.amlich.domain.mapper.MapAbleToModel
import com.jarvis.amlich.domain.model.BuonBanModel


@Entity(tableName = "buon_ban")
data class BuonBanEntity(
    @PrimaryKey
    @ColumnInfo(name = "id") var id: Int? = 0,
    @ColumnInfo(name = "tho_nom") var thoNom: String? = null,
    @ColumnInfo(name = "tho_dich") var thoDich: String? = null,
    @ColumnInfo(name = "ban_luan") var banLuan: String? = null,
) : MapAbleToModel<BuonBanModel> {

    override fun toModel(): BuonBanModel {
        return BuonBanModel(
            id = id,
            thoNom = thoNom,
            thoDich = thoDich,
            banLuan = banLuan,
        )
    }
}
