package com.jarvis.amlich.domain.model

import com.jarvis.amlich.R
import com.jarvis.amlich.di.App
import com.jarvis.amlich.domain.mapper.MapAbleToModel

data class MuuVongModel(
    var id: Int? = 0,
    var thoNom: String? = null,
    var thoDich: String? = null,
    var banLuan: String? = null,
): MapAbleToModel<DetailModel> {

    override fun toModel(): DetailModel {
        return DetailModel(
            id = id,
            thoNom = thoNom,
            thoDich = thoDich,
            banLuan = banLuan,
            title = App.context.getString(R.string.muu_vong),
        )
    }
}