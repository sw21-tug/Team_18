package com.example.saveup

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.snackbar.Snackbar
import org.json.JSONStringer
import java.nio.charset.Charset

class ProfileActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val fab: View = findViewById(R.id.form_button)
        fab.setOnClickListener {
            val intent = Intent (this, FormActivity::class.java)
            startActivity(intent)
        }

        getExpenses()
    }

    private fun getExpenses(){
        val queue = Volley.newRequestQueue(this)
        val url = "https://saveup.weisl.cc/userdata"

        val stringReq : StringRequest =
            object : StringRequest(Method.GET, url,
                Response.Listener { response ->
                    // response
                    val strResp = response.toString()

                    Log.d("API", strResp)
                    Toast.makeText(this, "Got data", Toast.LENGTH_SHORT).show()
                },
                Response.ErrorListener { error ->
                    Log.d("API", "error => $error")
                    Toast.makeText(this, "Requesting expenses failed", Toast.LENGTH_SHORT).show()
                }
            ){}
        queue.add(stringReq)
    }
}