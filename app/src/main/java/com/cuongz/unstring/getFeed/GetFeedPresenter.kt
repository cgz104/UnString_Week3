package com.cuongz.unstring.getFeed

import android.util.Log
import com.cuongz.unstring.api.apiFeed.ApiFeed
import com.cuongz.unstring.model.feed.Feed
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetFeedPresenter(var view: GetFeedInterface.View): GetFeedInterface.Presenter {

    override fun getFeedFromServer(accessToken: String) {
        val bearerToken = "Bearer $accessToken"
        ApiFeed.createService().getFeed(bearerToken,"1", "25").enqueue(object : Callback<Feed>{
            override fun onFailure(call: Call<Feed>, t: Throwable) {
                Log.w("test feed fail", "true")
            }
vxcvxcvxcv
            override fun onResponse(call: Call<Feed>, response: Response<Feed>) {
                Log.w("test feed fail", "false")
                val resBody = response.body()
                if(resBody != null){
                    view.onSuccess(resBody)
                }

            }

        })
    }
}