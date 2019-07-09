package com.cuongz.unstring.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import com.cuongz.unstring.R
import com.cuongz.unstring.getUser.GetUserInterface
import com.cuongz.unstring.getUser.GetUserPresenter
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity() {
    private var backButtonCount = 1
    private var fcm_token: String? = null
    private var presenter = GetUserPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        intent
        fcm_token = intent.getStringExtra("fcm_token")
        Log.w("fcm_token_intent", fcm_token)

        button_login.setOnClickListener {
//            presenter.userLogIn(fcm_token, username.text.toString(), password.text.toString())
            presenter.userLogIn(fcm_token, "cuong.le1004@gmail.com", "123123")


            Handler().postDelayed({
                val intentSendToken = Intent(this@SignInActivity, FeedActivity::class.java)
                intentSendToken.putExtra("accessToken", presenter.getAccessToken())
                startActivity(intentSendToken)
            }, 1000)

        }
    }

    override fun onBackPressed() {
        if(backButtonCount > 1){
            val intent = Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_HOME)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            finish()
            startActivity(intent)
        }else{
            Toast.makeText(this, "Press again to close", Toast.LENGTH_SHORT).show();
            backButtonCount++
        }
    }
}
