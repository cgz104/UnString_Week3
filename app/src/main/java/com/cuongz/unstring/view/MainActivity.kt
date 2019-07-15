package com.cuongz.unstring.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.cuongz.unstring.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var firebasetoken: String? = null
//    private var ggDetail = GetDetails()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val slideup: Animation = AnimationUtils.loadAnimation(stringLogo.context,
            R.anim.logo_animation
        )

//        ggDetail.getDetailsFromGoogle()


        stringLogo.startAnimation(slideup)


        FirebaseInstanceId.getInstance().instanceId
            .addOnCompleteListener(OnCompleteListener { task ->
                if (!task.isSuccessful) {
//                    Log.w(TAG, "getInstanceId failed", task.exception)
                    return@OnCompleteListener
                }

                // Get new Instance ID token
                firebasetoken = task.result?.token

                // Log and toast
//                val msg = getString(R.string.msg_token_fmt, firebasetoken)
//                Log.d("show token", firebasetoken)
//                Toast.makeText(baseContext, msg, Toast.LENGTH_SHORT).show()
            })

        Handler().postDelayed({
            if(firebasetoken == null){
                Toast.makeText(this, "Check Internet and open app again", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, SignInActivity::class.java)
                intent.putExtra("fcm_token", firebasetoken)
                startActivity(intent)
                finish()
            }

        }, 2000)



    }

//    companion object {
//
//        private const val TAG = "MainActivity"
//    }
}
