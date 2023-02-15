package com.jarvis.amlich.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jarvis.amlich.domain.mapper.MapAbleToModel
import com.jarvis.amlich.domain.model.DoanBenhModel


@Entity(tableName = "doan_benh")
data class DoanBenhEntity(
    @PrimaryKey
    @ColumnInfo(name = "id") var id: Int? = 0,
    @ColumnInfo(name = "tho_nom") var thoNom: String? = null,
    @ColumnInfo(name = "tho_dich") var thoDich: String? = null,
    @ColumnInfo(name = "ban_luan") var banLuan: String? = null,
): MapAbleToModel<DoanBenhModel> {

    override fun toModel(): DoanBenhModel {
        return DoanBenhModel(
            id = id,
            thoNom = thoNom,
            thoDich = thoDich,
            banLuan = banLuan,
        )
    }
}