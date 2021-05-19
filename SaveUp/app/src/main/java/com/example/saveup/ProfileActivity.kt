package com.example.saveup

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class ProfileActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val sharedPref = getSharedPreferences("User", Context.MODE_PRIVATE)
        val tokenToGet: String = sharedPref.getString("user_token", "")!!
        Log.d("TOKEN", tokenToGet)

        val fab: View = findViewById(R.id.form_button)
        fab.setOnClickListener {
            val intent = Intent (this, FormActivity::class.java)
            startActivity(intent)
        }

    }
}