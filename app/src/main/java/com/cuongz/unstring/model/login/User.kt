package com.cuongz.unstring.model.login

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class User {

    @SerializedName("code")
    @Expose
    var code: Int? = null
    @SerializedName("message")
    @Expose
    var message: String? = null
    @SerializedName("status")
    @Expose
    var status: Boolean? = null
    @SerializedName("data")
    @Expose
    var data: Data? = null

}