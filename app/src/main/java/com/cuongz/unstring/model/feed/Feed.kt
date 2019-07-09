package com.cuongz.unstring.model.feed

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Feed {

    @SerializedName("code")
    @Expose
    var code: Int? = null

    @SerializedName("message")
    @Expose
    var message: String? = null

    @SerializedName("status")
    @Expose
    var status: Boolean? = null

    @SerializedName("metadata")
    @Expose
    var metadata: Metadata? = null

    @SerializedName("data")
    @Expose
    var data: List<Datum>? = null

}