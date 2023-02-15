package com.jarvis.amlich.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jarvis.amlich.domain.mapper.MapAbleToModel
import com.jarvis.amlich.domain.model.LucSucModel


@Entity(tableName = "luc_suc")
data class LucSucEntity(
    @PrimaryKey
    @ColumnInfo(name = "id") var id: Int? = 0,
    @ColumnInfo(name = "tho_nom") var thoNom: String? = null,
    @ColumnInfo(name = "tho_dich") var thoDich: String? = null,
    @ColumnInfo(name = "ban_luan") var banLuan: String? = null,
): MapAbleToModel<LucSucModel> {

    override fun toModel(): LucSucModel {
        return LucSucModel(
            id = id,
            thoNom = thoNom,
            thoDich = thoDich,
            banLuan = banLuan,
        )
    }
}