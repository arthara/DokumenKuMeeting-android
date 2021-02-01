package com.dokumenku.meeting.modul

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.divyanshu.draw.widget.DrawView
import com.dokumenku.meeting.R
import java.io.ByteArrayOutputStream

class SignatureActivity : AppCompatActivity() {
    companion object {
        const val DATA_NAME = "signature"
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        setTheme(R.style.Theme_AppCompat_Dialog)
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_signature)
        initializeButtonsListener()
    }

    private fun initializeButtonsListener() {
        // cancel button
        findViewById<Button>(R.id.cancelSignatureBtn).setOnClickListener(View.OnClickListener {
            finish()
        })
        //ok button
        findViewById<Button>(R.id.okSignatureBtn).setOnClickListener(View.OnClickListener {
            sendImage()
        })
    }

    private fun sendImage(){
        val bStream = ByteArrayOutputStream()
        val bitmap = findViewById<DrawView>(R.id.signatureDrawer).getBitmap()
        val byteArray = bStream.toByteArray()
        val returnIntent = Intent()

        bitmap.compress(Bitmap.CompressFormat.PNG, 100, bStream)
        returnIntent.putExtra(DATA_NAME, byteArray)
        setResult(Activity.RESULT_OK,returnIntent)
        finish()
    }
}