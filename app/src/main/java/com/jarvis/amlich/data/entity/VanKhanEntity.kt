package com.jarvis.amlich.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jarvis.amlich.domain.mapper.MapAbleToModel
import com.jarvis.amlich.domain.model.VanKhanModel


@Entity(tableName = "van_khan")
data class VanKhanEntity(
    @PrimaryKey
    @ColumnInfo(name = "id") var id: Int? = 0,
    @ColumnInfo(name = "name") var name: String? = null,
    @ColumnInfo(name = "noi_dung") var noiDung: String? = null,
    @ColumnInfo(name = "the_loai") var theLoai: Int? = null,
): MapAbleToModel<VanKhanModel> {

    override fun toModel(): VanKhanModel {
        return VanKhanModel(
            id = id,
            name = name,
            noiDung = noiDung,
            theLoai = theLoai,
        )
    }
}