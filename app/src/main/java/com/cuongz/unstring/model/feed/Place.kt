package com.cuongz.unstring.model.feed

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Place {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("lat")
    @Expose
    var lat: Double? = null
    @SerializedName("long")
    @Expose
    var long: Double? = null
    @SerializedName("placeID")
    @Expose
    var placeID: String? = null
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("address")
    @Expose
    var address: String? = null
    @SerializedName("photo")
    @Expose
    var photo: Photo_? = null

}