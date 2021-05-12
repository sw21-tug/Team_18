package com.example.saveup

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun login(view: View) {
        val email = findViewById<EditText>(R.id.login_email).text.toString()
        val password = findViewById<EditText>(R.id.login_password).text.toString()

        if (email == "root@root.at" && password == "root") {
            val sharedPref = getSharedPreferences("User", Context.MODE_PRIVATE).edit()
            sharedPref.putString("user_token", "asdfasdfasdfasdfasfd")
            sharedPref.apply()
            val intent = Intent (this, ProfileActivity::class.java)
            startActivity(intent)

        } else {
            Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
        }
    }
}