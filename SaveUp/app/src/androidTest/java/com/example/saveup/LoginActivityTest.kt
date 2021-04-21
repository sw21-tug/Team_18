package com.example.saveup

import android.content.Intent
import android.widget.Button
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginActivityTest {

    @Rule @JvmField var activityRule: ActivityScenarioRule<MainActivity> =
            ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkLoginFieldIsDisplayed() {
        onView(withId(R.id.Log_In)).perform(click())
        onView(withId(R.id.login_email)).check(matches(isDisplayed()))
    }

    @Test
    fun checkPasswordFieldIsDisplayed() {
        onView(withId(R.id.Log_In)).perform(click())
        onView(withId(R.id.login_password)).check(matches(isDisplayed()))
    }

    @Test
    fun checkLoginButtonIsDisplayed() {
        onView(withId(R.id.Log_In)).perform(click())
        onView(withId(R.id.login_button)).check(matches(isDisplayed()))
    }

    @Test
    fun checkFieldsAreWritableDisplayed() {
        onView(withId(R.id.Log_In)).perform(click())
        onView(withId(R.id.login_email)).perform(typeText("root@root.at"))
        onView(withId(R.id.login_password)).perform(typeText("root"))
    }

    @Test
    fun checkLoginButtonIsClickable() {
        onView(withId(R.id.Log_In)).perform(click())
        onView(withId(R.id.login_button)).check(matches(isClickable()))
    }

    @Test
    fun checkLoginFlowWorks() {
        onView(withId(R.id.Log_In)).perform(click())
        onView(withId(R.id.login_email)).perform(typeText("root@root.at"))
        onView(withId(R.id.login_password)).perform(typeText("root"))
        onView(withId(R.id.login_button)).perform(click())
        onView(withId(R.id.dashboard_title)).check(matches(isDisplayed()))
    }
}