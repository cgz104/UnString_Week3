package com.cuongz.unstring.api.apiFeed

import com.cuongz.unstring.api.ApiMethod
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiFeed {
    companion object{
        private var BASE_URL = "http://string-api.vinova.sg/api/"

        private fun builder(): Retrofit {
            return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client())
                .build()
        }

        private fun client(): OkHttpClient {
            return OkHttpClient.Builder().addNetworkInterceptor{ chain ->
                var request = chain.request()
                val url = request.url().newBuilder()
                    .build()
                request = request.newBuilder().url(url).build()
                chain.proceed(request)
            }.build()
        }

        fun createService(): ApiMethod {
            return builder()
                .create(ApiMethod::class.java)
        }
    }
}