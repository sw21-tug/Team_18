package com.example.saveup

import ListAdapter
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.saveup.ui.form.FormData
import org.json.JSONArray
import org.json.JSONException
import kotlinx.android.synthetic.main.activity_profile.*

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

        val usersList: ArrayList<FormData> = ArrayList()
        form_list.layoutManager = LinearLayoutManager(this)
        val itemAdapter = ListAdapter(this, usersList)
        form_list.adapter = itemAdapter
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
                    updateList(json_string)
                },
                Response.ErrorListener { error ->
                    Log.d("API", "error => $error")
                    Toast.makeText(this, "Requesting expenses failed", Toast.LENGTH_SHORT).show()
                }
            ){}
        queue.add(stringReq)
    }

    private fun updateList(json_string: String) {
        val usersList: ArrayList<FormData> = ArrayList()

        try {
            val usersArray = JSONArray(json_string)

            for (i in 0 until usersArray.length()) {
                val user = usersArray.getJSONObject(i)
                val id = user.getString("id")
                val type = user.getString("type")
                val date = user.getString("date")
                val description = user.getString("description")
                val amount = user.getString("amount")

                val formDetails = FormData(id, type, date, description, amount)

                usersList.add(formDetails)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        if (usersList.size == 0) {
            no_expense_yet_text.visibility = View.VISIBLE
        }

        form_list.layoutManager = LinearLayoutManager(this)
        val itemAdapter = ListAdapter(this, usersList)
        form_list.adapter = itemAdapter
    }
}