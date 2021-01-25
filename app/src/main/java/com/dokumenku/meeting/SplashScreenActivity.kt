package com.dokumenku.meeting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.gms.auth.api.signin.GoogleSignIn
import java.util.*

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        if(isAlreadyLogin())
            redirectToDashboard()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
    }

    override fun onStart(){
        val timerInMilis = 3000L
        super.onStart()

        //start 3 sec timer then redirect
        Timer().schedule(object : TimerTask() {
            override fun run() {
                redirectToLogin()
            }
        }, timerInMilis)
    }

    private fun isAlreadyLogin() : Boolean{
        val account = GoogleSignIn.getLastSignedInAccount(this)
        return account != null
    }

    private fun redirectToLogin(){
        // TO DO : redirect to login
        Log.d("SplashScreen", "To Login")
//        finish()
    }

    private fun redirectToDashboard(){
        // TO DO : redirect to Dashboard
        Log.d("SplashScreen", "To Dashboard")
//        finish()
    }
}