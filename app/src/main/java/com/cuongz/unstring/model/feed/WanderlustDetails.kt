package com.cuongz.unstring.model.feed

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class WanderlustDetails {

    @SerializedName("location")
    @Expose
    var location: Location? = null
    @SerializedName("isWanderlust")
    @Expose
    var isWanderlust: Boolean? = null

}