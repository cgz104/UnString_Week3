package com.cuongz.unstring.model.feed

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class NotificationSettings {

    @SerializedName("likes")
    @Expose
    var likes: Boolean? = null
    @SerializedName("comments")
    @Expose
    var comments: Boolean? = null
    @SerializedName("new_followes")
    @Expose
    var newFollowes: Boolean? = null
    @SerializedName("post_saves")
    @Expose
    var postSaves: Boolean? = null
    @SerializedName("string")
    @Expose
    var string: Boolean? = null

}