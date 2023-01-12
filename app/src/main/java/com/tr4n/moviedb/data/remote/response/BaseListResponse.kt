package com.tr4n.moviedb.data.remote.response

import com.google.gson.annotations.SerializedName
import org.jetbrains.annotations.TestOnly

open class BaseListResponse<Item>(
    @SerializedName("page")
    val page: Int? = null,
    @SerializedName("total_results")
    val totalResults: Int? = null,
    @SerializedName("total_pages")
    val totalPages: Int? = null,
    @SerializedName("results")
    var results: List<Item>? = null
) {
    @TestOnly
    fun isSameAs(other: Any): Boolean {
        return page == (other as BaseListResponse<*>).page &&
                totalResults == other.totalResults &&
                totalPages == other.totalPages &&
                results == other.results
    }
}
