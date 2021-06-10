package com.example.saveup

import android.content.Context
import android.content.Intent
import android.widget.Button
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
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

class RegistrationActivityTest {

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
    fun checkSignUpButtonDisplayed() {
        onView(withId(R.id.Sign_Up)).check(matches(isDisplayed()))
        onView(withId(R.id.Sign_Up)).check(matches(isClickable()))
    }

    @Test
    fun checkSignUpFormCheckFields() {
        onView(withId(R.id.Sign_Up)).perform(click())
        onView(withText("First Name")).check(matches(isDisplayed()))
        onView(withText("Name")).check(matches(isDisplayed()))
        onView(withText("Email")).check(matches(isDisplayed()))
        onView(withText("Password")).check(matches(isDisplayed()))
        onView(withText("Create Account")).check(matches(isDisplayed()))
    }

    @Test
    fun checkRegistrationFlowWorks() {
        onView(withId(R.id.Sign_Up)).perform(click())
        onView(withId(R.id.registration_prename)).perform(typeText("Max"))
        onView(withId(R.id.registration_lastname)).perform(typeText("Mustermann"))
        onView(withId(R.id.registration_email)).perform(typeText("max@mustermann.xxx")).
        perform(ViewActions.closeSoftKeyboard())
        onView(withId(R.id.registration_password)).perform(typeText("test123")).
        perform(ViewActions.closeSoftKeyboard())
        onView(withId(R.id.registration_button)).perform(click())
    }
}