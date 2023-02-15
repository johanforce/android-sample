package com.jarvis.amlich.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jarvis.amlich.domain.mapper.MapAbleToModel
import com.jarvis.amlich.domain.model.QueModel


@Entity(tableName = "que")
data class QueEntity(
    @PrimaryKey
    @ColumnInfo(name = "id") var id: Int? = 0,
    @ColumnInfo(name = "ten_que") var tenQUe: String? = null,
    @ColumnInfo(name = "stt") var stt: Int? = null,
    @ColumnInfo(name = "vi_tri_bat_quai") var status: String? = null,
    @ColumnInfo(name = "tich_xua") var tichXua: String? = null,
    @ColumnInfo(name = "tho_nom") var thoNom: String? = null,
    @ColumnInfo(name = "tho_dich") var thoDich: String? = null,
) : MapAbleToModel<QueModel> {

    override fun toModel(): QueModel {
        return QueModel(
            id = id,
            thoNom = thoNom,
            thoDich = thoDich,
            stt = stt,
            status = status,
            tenQUe = tenQUe,
            tichXua = tichXua,
        )
    }
}