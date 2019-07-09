package com.cuongz.unstring.model.login

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Data {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("email")
    @Expose
    var email: String? = null
    @SerializedName("username")
    @Expose
    var username: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("date_of_birth")
    @Expose
    var dateOfBirth: String? = null
    @SerializedName("facebookID")
    @Expose
    var facebookID: Any? = null
    @SerializedName("profilePhoto")
    @Expose
    var profilePhoto: Any? = null
    @SerializedName("gender")
    @Expose
    var gender: Any? = null
    @SerializedName("notificationSettings")
    @Expose
    var notificationSettings: NotificationSettings? = null
    @SerializedName("bio")
    @Expose
    var bio: Any? = null
    @SerializedName("website")
    @Expose
    var website: Any? = null
    @SerializedName("type")
    @Expose
    var type: String? = null
    @SerializedName("trash")
    @Expose
    var trash: Boolean? = null
    @SerializedName("isActive")
    @Expose
    var isActive: Boolean? = null
    @SerializedName("isSuperUser")
    @Expose
    var isSuperUser: Boolean? = null
    @SerializedName("currentLocation")
    @Expose
    var currentLocation: Any? = null
    @SerializedName("isNewUser")
    @Expose
    var isNewUser: Boolean? = null
    @SerializedName("created_at")
    @Expose
    var createdAt: String? = null
    @SerializedName("updated_at")
    @Expose
    var updatedAt: String? = null
    @SerializedName("access_token")
    @Expose
    var accessToken: String? = null
    @SerializedName("refresh_token")
    @Expose
    var refreshToken: String? = null
    @SerializedName("badge")
    @Expose
    var badge: Any? = null
    @SerializedName("wanderlust_details")
    @Expose
    var wanderlustDetails: Any? = null

}