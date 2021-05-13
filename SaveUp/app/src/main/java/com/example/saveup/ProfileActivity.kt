package com.example.saveup

import android.content.Intent
import android.os.Bundle
import android.util.JsonReader
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.saveup.ui.form.FormData
import com.example.saveup.ui.form.ItemAdapter
import org.json.JSONArray
import org.json.JSONException
import java.io.Reader
import java.lang.Thread.sleep
import java.net.URLEncoder

class ProfileActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val fab: View = findViewById(R.id.form_button)
        fab.setOnClickListener {
            val intent = Intent (this, FormActivity::class.java)
            startActivity(intent)
        }

        getExpensesFromDatabase()
    }

    private fun getExpensesFromDatabase(){
        val queue = Volley.newRequestQueue(this)
        val url = "https://saveup.weisl.cc/userdata"

        val stringReq : StringRequest =
            object : StringRequest(Method.GET, url,
                Response.Listener { response ->
                    // response
                    val json_string = response.toString()
                    Log.d("API", json_string)
                    Toast.makeText(this, "Got data for list", Toast.LENGTH_SHORT).show()
                    displayListOfData(json_string)
                },
                Response.ErrorListener { error ->
                    Log.d("API", "error => $error")
                    Toast.makeText(this, "Requesting expenses failed", Toast.LENGTH_SHORT).show()
                }
            ){}
        queue.add(stringReq)
    }

    private fun displayListOfData(json_string: String)
    {
        try {
            // val encodedString = URLEncoder.encode(json_string, "utf-8")
            val jsonArray = JSONArray(json_string)
            val arrayList: ArrayList<FormData> = ArrayList()
            var i = 0
            while (i < jsonArray.length()) {
                val data = FormData(
                    jsonArray.getJSONObject(i)["date"].toString(),
                    jsonArray.getJSONObject(i)["category"].toString(),
                    jsonArray.getJSONObject(i)["amount"].toString()
                )
                arrayList.add(data)
                i += 1
            }

            val recyclerView = findViewById<RecyclerView>(R.id.form_list)
            recyclerView.adapter = ItemAdapter(this, arrayList)
            recyclerView.setHasFixedSize(true)
        }
        catch (e: JSONException) {
            println(e)
        }
    }
}