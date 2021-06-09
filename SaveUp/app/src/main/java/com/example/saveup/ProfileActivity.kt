package com.example.saveup

import ListAdapter
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.LocaleList
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.saveup.ui.form.FormData
import com.example.saveup.ui.form.SortSpinner
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.content_profile.*
import org.json.JSONArray
import org.json.JSONException
import java.util.*
import kotlin.collections.ArrayList


class ProfileActivity: AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val sharedPref = getSharedPreferences("User", Context.MODE_PRIVATE)
        val tokenToGet: String = sharedPref.getString("user_token", "")!!
        Log.d("TOKEN", tokenToGet)
        loadLocale()

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

        // set user info for drawer
        val name: String = sharedPref.getString("user_prename", " ")+
                " " + sharedPref.getString("user_surname", " ")
        val mail: String = sharedPref.getString("user_mail", " ")!!
        Log.d("drawer_name: ", name)
        nav_menu.getHeaderView(0).findViewById<TextView>(R.id.drawer_name).text = name
        nav_menu.getHeaderView(0).findViewById<TextView>(R.id.drawer_mail).text = mail
        Log.d("drawer_mail: ", mail)

        setNavigationViewListener()

        // set the spinner
        ArrayAdapter.createFromResource(
            this,
            R.array.spinner_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            sort_spinner.adapter = adapter
        }
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
                    updateList(json_string)
                },
                Response.ErrorListener { error ->
                    Log.d("API", "error => $error")
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
                val amount: Int
                if (type == "expense")
                    amount = user.getInt("amount").unaryMinus()
                else
                    amount = user.getInt("amount")

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

        // set spinner
        val spinner = SortSpinner(itemAdapter, this)
        sort_spinner.onItemSelectedListener = spinner
    }


    // DRAWER CONTENT
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.navigation_home -> {
                val intent = Intent (this, ProfileActivity::class.java)
                startActivity(intent)
            }
            R.id.buttonChangeLang -> {
                println("Create another activity")
                val languages = arrayOf("Chinese", "Russian", "English")

                val langSelectorBuilder = AlertDialog.Builder(this@ProfileActivity)
                langSelectorBuilder.setTitle("Choose language:")
                langSelectorBuilder.setSingleChoiceItems(languages, -1) { dialog, selection ->
                    when (selection) {
                        0 -> {
                            setLocale("zh")
                        }
                        1 -> {
                            setLocale("ru")
                        }
                        2 -> {
                            setLocale("en")
                        }
                    }
                    recreate()
                    dialog.dismiss()
                }
                langSelectorBuilder.create().show()
            }
            R.id.navigation_logout -> {
                getSharedPreferences("User", Context.MODE_PRIVATE).edit().clear().apply()
                val intent = Intent (this, MainActivity::class.java)
                startActivity(intent)
            }
            else -> println("This button isn't implemented yet")
        }

        return true
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun setLocale(localeToSet: String) {
        val localeListToSet = LocaleList(Locale(localeToSet))
        LocaleList.setDefault(localeListToSet)
        resources.configuration.setLocales(localeListToSet)
        resources.updateConfiguration(resources.configuration, resources.displayMetrics)
        val sharedPref = getSharedPreferences("Settings", Context.MODE_PRIVATE).edit()
        sharedPref.putString("locale_to_set", localeToSet)
        sharedPref.apply()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun loadLocale() {
        val sharedPref = getSharedPreferences("Settings", Context.MODE_PRIVATE)
        val localeToSet: String = sharedPref.getString("locale_to_set", "")!!
        setLocale(localeToSet)
    }

    private fun setNavigationViewListener() {
        nav_menu.setNavigationItemSelectedListener(this)
    }


    companion object {
        var sortListBy: String = ""
    }
}