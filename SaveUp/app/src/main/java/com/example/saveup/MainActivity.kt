package com.example.saveup

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.LocaleList
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import java.util.*

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadLocale()

        val changeLangButton: Button = findViewById(R.id.buttonChangeLang)

        changeLangButton.setText(R.string.change_lang)

        changeLangButton.setOnClickListener {
            val languages = arrayOf("Chinese", "Russian", "English")

            val langSelectorBuilder = AlertDialog.Builder(this@MainActivity)
            langSelectorBuilder.setTitle("Choose language:")
            langSelectorBuilder.setSingleChoiceItems(languages, -1) { dialog, selection ->
                when(selection) {
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

    fun startLogin(view: View) {
        val intent = Intent (this, LoginActivity::class.java)
        startActivity(intent)
    }
    fun startRegistration(view: View) {
        val intent = Intent (this, RegistrationActivity::class.java)
        startActivity(intent)
    }
}