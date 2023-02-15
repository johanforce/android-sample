package com.jarvis.amlich.domain.model

import com.jarvis.amlich.R
import com.jarvis.amlich.di.App
import com.jarvis.amlich.domain.mapper.MapAbleToModel

data class DoanBenhModel(
    var id: Int? = 0,
    var thoNom: String? = null,
    var thoDich: String? = null,
    var banLuan: String? = null,
) : MapAbleToModel<DetailModel> {

    override fun toModel(): DetailModel {
        return DetailModel(
            id = id,
            title = App.context.getString(R.string.doan_benh),
            thoNom = thoNom,
            thoDich = thoDich,
            banLuan = banLuan,
        )
    }
}