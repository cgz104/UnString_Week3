package com.cuongz.unstring.api

import com.cuongz.unstring.model.feed.Feed
import com.cuongz.unstring.model.login.User
import com.cuongz.unstring.model.login.UserLogin
import retrofit2.Call
import retrofit2.http.*

interface ApiMethod {
    @POST("users-login")
    fun getUser(
        @Body user: UserLogin
    ): Call<User>

    @GET("feed")
    fun getFeed(
        @Header ("Authorization") accessToken: String,
        @Query("page") page: String?,
        @Query("current_per_page") current_per_page: String?
    ): Call<Feed>

//    @GET("json")
//    fun getGoogleDetails(
//        @Query ("placeid") placeid: String?,
//        @Query ("fields") fields: String?
//    ): Call<GooglePlaceDetail>
}