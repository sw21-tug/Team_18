package com.example.saveup

import android.content.Context
import android.content.Intent
import android.widget.Button
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.DrawerActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule @JvmField var activityRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp()
    {
        if(ApplicationProvider.getApplicationContext<Context>()
                .getSharedPreferences("User", Context.MODE_PRIVATE).getString("user_token", null) != null)
        {
            onView(withId(R.id.drawerLayout)).perform(DrawerActions.open())
            onView(withId(R.id.navigation_logout)).perform(click())
        }
    }

    @Test
    fun checkLoginButtonDisplayed() {
        onView(withId(R.id.Log_In)).check(matches(isDisplayed()))
    }

    @Test
    fun checkSignUpButtonDisplayed() {
        onView(withId(R.id.Log_In)).check(matches(isDisplayed()))
    }

}