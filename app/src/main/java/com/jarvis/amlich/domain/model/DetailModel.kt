package com.jarvis.amlich.domain.model

data class DetailModel (
    val title: String ?= null,
    var id: Int? = 0,
    var thoNom: String? = null,
    var thoDich: String? = null,
    var banLuan: String? = null,
)