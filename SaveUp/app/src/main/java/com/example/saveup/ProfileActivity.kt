package com.example.saveup

import ListAdapter
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.saveup.ui.form.FormData
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.content_profile.*
import kotlinx.android.synthetic.main.navigation_header.*
import org.json.JSONArray
import org.json.JSONException
import java.lang.NullPointerException

class ProfileActivity: AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val sharedPref = getSharedPreferences("User", Context.MODE_PRIVATE)
        val tokenToGet: String = sharedPref.getString("user_token", "")!!
        Log.d("TOKEN", tokenToGet)

        setSupportActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)
        toggle.isDrawerIndicatorEnabled = true
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // create listener for the form_button
        val fab: View = findViewById(R.id.form_button)
        fab.setOnClickListener {
            val intent = Intent (this, FormActivity::class.java)
            startActivity(intent)
        }

        // get and display all the data for the user from the database
        getExpensesFromDatabase()
        val usersList: ArrayList<FormData> = ArrayList()
        form_list.layoutManager = LinearLayoutManager(this)
        val itemAdapter = ListAdapter(this, usersList)
        form_list.adapter = itemAdapter

        // set user info for drawer
        try {
            val name: String = sharedPref.getString("user_prename", " ")+
                    " " + sharedPref.getString("user_surname", " ")
            val mail: String = sharedPref.getString("user_mail", " ")!!
            Log.d("drawer_name: ", name)
            drawer_name.text = name
            drawer_mail.text = mail
            Log.d("drawer_mail: ", mail)
        }
        catch(e: NullPointerException)
        {
            print(e)
        }

        setNavigationViewListener()
    }

    override fun onResume() {
        super.onResume()
        getExpensesFromDatabase()

        val usersList: ArrayList<FormData> = ArrayList()
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


    // DRAWER CONTENT
    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.navigation_home -> {
                val intent = Intent (this, MainActivity::class.java)
                startActivity(intent)
            }
            R.id.navigation_else -> println("Create another activity")
            else -> println("This button isn't implemented yet")
        }

        drawerLayout.closeDrawer(GravityCompat.START)
        return true;
    }

    fun setNavigationViewListener() {
        nav_menu.setNavigationItemSelectedListener(this)
    }
}