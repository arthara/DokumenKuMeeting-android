package com.dokumenku.meeting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.gms.auth.api.signin.GoogleSignIn
import java.util.*

class SplashScreenActivity : AppCompatActivity() {
    companion object{
        private const val TAG = "SplashScreenActivity"
    }

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
        val intent = Intent(this, LoginActivity::class.java)

        startActivity(intent)
        Log.d(TAG, "To Login")
        finish()
    }

    private fun redirectToDashboard(){
        val intent = Intent(this, PdfMomActivity::class.java)

        startActivity(intent)
        Log.d(TAG, "To Dashboard")
        finish()
    }
}