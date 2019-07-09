package com.cuongz.unstring.model.feed

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Photo {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("url")
    @Expose
    var url: Url_? = null

}