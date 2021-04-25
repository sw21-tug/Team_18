package com.example.saveup

import android.content.Intent
import android.os.Bundle
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
    }

    fun register(view: View) {
        val prename = findViewById<EditText>(R.id.registration_prename).text.toString()
        val lastname = findViewById<EditText>(R.id.registration_lastname).text.toString()
        val email = findViewById<EditText>(R.id.registration_email).text.toString()
        val password = findViewById<EditText>(R.id.registration_password).text.toString()

        val queue = Volley.newRequestQueue(this)
        val url = "https://saveup.weisl.cc/users"

        val requestBody = "prename=" + prename + "&lastname=" + lastname + "&email=" + email + "&pw=" + password
        val stringReq : StringRequest =
            object : StringRequest(Method.POST, url,
                Response.Listener { response ->
                    // response
                    val strResp = response.toString()

                    Log.d("API", strResp)
                },
                Response.ErrorListener { error ->
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