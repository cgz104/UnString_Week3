package com.cuongz.unstring.model.feed

import com.cuongz.unstring.model.login.User
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Datum {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("type")
    @Expose
    var type: String? = null
    @SerializedName("title")
    @Expose
    var title: String? = null
//    @SerializedName("description")
//    @Expose
//    var description: String? = null
//    @SerializedName("coverImage")
//    @Expose
//    var coverImage: CoverImage? = null
//    @SerializedName("strungCounter")
//    @Expose
//    var strungCounter: Int? = null
//    @SerializedName("likeCounter")
//    @Expose
//    var likeCounter: Int? = null
//    @SerializedName("commentCounter")
//    @Expose
//    var commentCounter: Int? = null
//    @SerializedName("isPrivate")
//    @Expose
//    var isPrivate: Boolean? = null
//    @SerializedName("strungFromID")
//    @Expose
//    var strungFromID: Any? = null
//    @SerializedName("created_at")
//    @Expose
//    var createdAt: String? = null
//    @SerializedName("updated_at")
//    @Expose
//    var updatedAt: String? = null
//    @SerializedName("user")
//    @Expose
//    var user: User? = null
//    @SerializedName("isLiked")
//    @Expose
//    var isLiked: Boolean? = null
//    @SerializedName("strungFrom")
//    @Expose
//    var strungFrom: Any? = null
//    @SerializedName("itineraries")
//    @Expose
//    var itineraries: Any? = null
    @SerializedName("photos")
    @Expose
    var photos: List<Photo>? = null
    @SerializedName("address")
    @Expose
    var address: String? = null
//    @SerializedName("lat")
//    @Expose
//    var lat: Double? = null
//    @SerializedName("long")
//    @Expose
//    var long: Double? = null
//    @SerializedName("workingHours")
//    @Expose
//    var workingHours: WorkingHours? = null
//    @SerializedName("websiteUrl")
//    @Expose
//    var websiteUrl: String? = null
//    @SerializedName("placeID")
//    @Expose
//    var placeID: String? = null
//    @SerializedName("tags")
//    @Expose
//    var tags: List<Any>? = null
//    @SerializedName("videos")
//    @Expose
//    var videos: Any? = null
//    @SerializedName("saveCounter")
//    @Expose
//    var saveCounter: Int? = null
//    @SerializedName("place")
//    @Expose
//    var place: Place? = null
//    @SerializedName("isSaved")
//    @Expose
//    var isSaved: Boolean? = null

}