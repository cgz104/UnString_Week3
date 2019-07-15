package com.cuongz.unstring.getUser

import android.util.Log
import com.cuongz.unstring.api.apiLogin.ApiLogin
import com.cuongz.unstring.model.login.Data
import com.cuongz.unstring.model.login.User
import com.cuongz.unstring.model.login.UserLogin
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetUserPresenter: GetUserInterface.Presenter {
    private var result: Boolean = true
    private var _accessToken: String? = null
//    val username = "cuong.le1004@gmail.com"
//    val password = "123123"
//    val fcm_token = "dYxDNtZ3DRI:APA91bFlThcrx1q2-DI0dH_REN3bK-MJCmVQvqwXJjFSXKkpZRiwOb53nREpVkrPHtXze6Ic99-9rQjcOYdDz1U3j3-7xP4oTXZGUWX3DDhxN1OT_sN8ejC-AyfakZ0BEEHg1MO3XR0m"
    override fun userLogIn(token: String?, username: String?, password: String?){
        ApiLogin.createService().getUser(UserLogin(username, password, token)).enqueue(object : Callback<User>{
            override fun onResponse(call: Call<User>, response: Response<User>) {
                _accessToken = response.body()?.data?.accessToken.toString()
                result = response.body()?.status!!
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.w("test fail", "true")
            }

        })
    }

    fun getAccessToken(): String?{
        return _accessToken
    }

    fun getResult(): Boolean{
        return result
    }
}