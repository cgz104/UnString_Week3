package com.cuongz.unstring.model.feed

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Location {

    @SerializedName("address")
    @Expose
    var address: String? = null
    @SerializedName("description")
    @Expose
    var description: String? = null
    @SerializedName("lat")
    @Expose
    var lat: String? = null
    @SerializedName("long")
    @Expose
    var long: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("placeID")
    @Expose
    var placeID: String? = null
    @SerializedName("websiteUrl")
    @Expose
    var websiteUrl: String? = null

}