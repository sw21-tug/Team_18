package com.example.saveup

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.LocaleList
import android.view.View
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import java.util.*

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPref = getSharedPreferences("User", Context.MODE_PRIVATE)
        if(sharedPref.getString("user_token", null) != null)
        {
            val intent = Intent (this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }

    fun startLogin(view: View) {
        val intent = Intent (this, LoginActivity::class.java)
        startActivity(intent)
    }
    fun startRegistration(view: View) {
        val intent = Intent (this, RegistrationActivity::class.java)
        startActivity(intent)
    }
}