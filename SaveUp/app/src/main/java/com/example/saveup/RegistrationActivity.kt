package com.example.saveup

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import java.nio.charset.Charset

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val sharedPref = getSharedPreferences("User", Context.MODE_PRIVATE)
        if(sharedPref.getString("user_token", null) != null)
        {
            val intent = Intent (this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }

    fun String.isEmailValid(): Boolean {
        return !TextUtils.isEmpty(this) && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }

    fun register(view: View) {
        val prename = findViewById<EditText>(R.id.registration_prename).text.toString()
        val lastname = findViewById<EditText>(R.id.registration_lastname).text.toString()
        val email = findViewById<EditText>(R.id.registration_email).text.toString()
        val password = findViewById<EditText>(R.id.registration_password).text.toString()

        if(!email.isEmailValid())
        {
            Toast.makeText(this, "Invalid email", Toast.LENGTH_SHORT).show()
            return
        }

        val queue = Volley.newRequestQueue(this)
        val url = "https://saveup.weisl.cc/users"

        val requestBody = "prename=" + prename + "&lastname=" + lastname + "&email=" + email + "&pw=" + password
        val stringReq : StringRequest =
            object : StringRequest(Method.POST, url,
                Response.Listener { response ->
                    // response
                    val strResp = response.toString()
                    Toast.makeText(this, "Registration successful!", Toast.LENGTH_SHORT).show()

                    Log.d("API", strResp)

                    val intent = Intent (this, LoginActivity::class.java)
                    startActivity(intent)
                },
                Response.ErrorListener { error ->
                    Toast.makeText(this, "Error. Please check input and internet connection.", Toast.LENGTH_SHORT).show()
                    Log.d("API", "error => $error")
                }
            ){
                override fun getBody(): ByteArray {
                    return requestBody.toByteArray(Charset.defaultCharset())
                }
            }
        queue.add(stringReq)
    }
}