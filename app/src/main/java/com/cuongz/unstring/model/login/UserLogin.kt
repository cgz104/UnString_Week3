package com.cuongz.unstring.model.login

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserLogin(
    @SerializedName("username")
    @Expose
    var username: String? = null,
    @SerializedName("password")
    @Expose
    var password: String? = null,
    @SerializedName("fcm_token")
    @Expose
    var fcm_token: String? = null
)


