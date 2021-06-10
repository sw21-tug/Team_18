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
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.saveup.ui.form.FormData
import com.example.saveup.ui.form.SortSpinner
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.content_profile.*
import kotlinx.android.synthetic.main.fragment_income.view.*
import org.json.JSONArray
import org.json.JSONException
import java.nio.charset.Charset
import java.util.*
import kotlin.collections.ArrayList


class ProfileActivity: AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    // Tag-Filters
    private var tags_checked = booleanArrayOf(false, false, false, false, false, false, false, false, false, false)
    private val tags_as_string  = arrayOfNulls<String>(10)
    private var selected_tags : MutableList<String> = ArrayList()

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
            val intent = Intent(this, FormActivity::class.java)
            startActivity(intent)
        }

        // init filter tags
        tags_as_string.set(0,resources.getString(R.string.string_salary))
        tags_as_string.set(1,resources.getString(R.string.string_gifts))
        tags_as_string.set(2,resources.getString(R.string.string_payback))
        tags_as_string.set(3,resources.getString(R.string.string_car))
        tags_as_string.set(4,resources.getString(R.string.string_groceries))
        tags_as_string.set(5,resources.getString(R.string.string_personal_hygiene))
        tags_as_string.set(6,resources.getString(R.string.string_cleaning_products))
        tags_as_string.set(7,resources.getString(R.string.string_clothes))
        tags_as_string.set(8,resources.getString(R.string.string_rent))
        tags_as_string.set(9,resources.getString(R.string.string_luxury))

        val filter_tags: View = findViewById(R.id.filter_tags_button)
        filter_tags.setOnClickListener {
            lateinit var tags: android.app.AlertDialog

            val builder = android.app.AlertDialog.Builder(this, R.style.MyDialogTheme)
            builder.setTitle(R.string.string_choose_tags)
            builder.setMultiChoiceItems(tags_as_string, tags_checked) { dialog, which, isChecked ->
                tags_checked[which] = isChecked
            }
            builder.setPositiveButton("OK") { _, _ ->
                var z = 0
                while(z < tags_as_string.size) {
                    if(tags_checked[z]) {
                        selected_tags.add(tags_as_string[z].toString())
                    }
                    z++
                }
            }
            tags = builder.create()
            tags.show()
        }

        val filter_submit: View = findViewById(R.id.filter_submit)
        filter_submit.setOnClickListener {
            val filterText = findViewById<EditText>(R.id.filter_description).text.toString()
            val filterAmountStart = findViewById<EditText>(R.id.filter_amount_start).text.toString()
            val filterAmountEnd = findViewById<EditText>(R.id.filter_amount_end).text.toString()
            val filterTags = selected_tags.joinToString(",")
            getUserdataFromDatabase(filterText, filterAmountStart, filterAmountEnd, filterTags)
        }

        // get and display all the data for the user from the database
        // is called on load of activity -> therefore no filters are applied
        getUserdataFromDatabase()

        // set user info for drawer
        val name: String = sharedPref.getString("user_prename", " ")+
                " " + sharedPref.getString("user_surname", " ")
        val mail: String = sharedPref.getString("user_mail", " ")!!
        nav_menu.getHeaderView(0).findViewById<TextView>(R.id.drawer_name).text = name
        nav_menu.getHeaderView(0).findViewById<TextView>(R.id.drawer_mail).text = mail

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

        val filterText = findViewById<EditText>(R.id.filter_description).text.toString()
        val filterAmountStart = findViewById<EditText>(R.id.filter_amount_start).text.toString()
        val filterAmountEnd = findViewById<EditText>(R.id.filter_amount_end).text.toString()
        val filterTags = selected_tags.joinToString(",")
        getUserdataFromDatabase(filterText, filterAmountStart, filterAmountEnd, filterTags)

        val usersList: ArrayList<FormData> = ArrayList()
        val itemAdapter = ListAdapter(this, usersList)
        form_list.adapter = itemAdapter
    }

    private fun getUserdataFromDatabase(filterText: String = "", filterAmountStart:String = "", filterAmountEnd:String = "", filterTags:String = "") {
        val queue = Volley.newRequestQueue(this)

        val sharedPref = getSharedPreferences("User", Context.MODE_PRIVATE)
        val token = sharedPref.getString("user_token", null)

        val url = "https://saveup.weisl.cc/userdata?token=" + token + "&filterText=" + filterText + "&filterAmountStart=" + filterAmountStart + "&filterAmountEnd=" + filterAmountEnd + "&filterTags=" + filterTags

        Log.d("url", url);

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
                val amount = user.getInt("amount")
                val tags = user.getString("tags")

                val formDetails = FormData(id, type, date, description, amount, tags)

                usersList.add(formDetails)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        if (usersList.size == 0) {
            no_expense_yet_text.visibility = View.VISIBLE
        } else {
            no_expense_yet_text.visibility = View.INVISIBLE
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