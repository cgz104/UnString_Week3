package com.cuongz.unstring.model.login

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class NotificationSettings {

    @SerializedName("likes")
    @Expose
    var likes: String? = null
    @SerializedName("comments")
    @Expose
    var comments: String? = null
    @SerializedName("new_followes")
    @Expose
    var newFollowes: String? = null
    @SerializedName("post_saves")
    @Expose
    var postSaves: String? = null
    @SerializedName("string")
    @Expose
    var string: String? = null

}