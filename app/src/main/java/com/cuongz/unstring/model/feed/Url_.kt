package com.cuongz.unstring.model.feed

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Url_ {

    @SerializedName("original")
    @Expose
    var original: String? = null
    @SerializedName("medium")
    @Expose
    var medium: String? = null
    @SerializedName("thumb")
    @Expose
    var thumb: String? = null

}