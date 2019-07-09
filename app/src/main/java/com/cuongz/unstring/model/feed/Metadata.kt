package com.cuongz.unstring.model.feed

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Metadata {

    @SerializedName("total_count")
    @Expose
    var totalCount: Int? = null
    @SerializedName("total_pages")
    @Expose
    var totalPages: Int? = null
    @SerializedName("next_page")
    @Expose
    var nextPage: Int? = null
    @SerializedName("prev_pages")
    @Expose
    var prevPages: Int? = null
    @SerializedName("current_page")
    @Expose
    var currentPage: Int? = null
    @SerializedName("current_per_page")
    @Expose
    var currentPerPage: Int? = null

}