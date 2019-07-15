package com.cuongz.unstring.model.feed

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Itinerary {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("poiID")
    @Expose
    var poiID: Int? = null
    @SerializedName("orderNo")
    @Expose
    var orderNo: Int? = null
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("photos")
    @Expose
    var photos: Photo? = null

}