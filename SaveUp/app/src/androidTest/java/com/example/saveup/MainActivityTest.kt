package com.example.saveup

import android.content.Intent
import android.widget.Button
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
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
class MainActivityTest {

    @Rule @JvmField var activityRule: ActivityScenarioRule<MainActivity> =
            ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkLoginButtonDisplayed() {
        onView(withId(R.id.Log_In)).check(matches(isDisplayed()))
    }

    @Test
    fun checkSignUpButtonDisplayed() {
        onView(withId(R.id.Log_In)).check(matches(isDisplayed()))
    }

    @Test
    fun checkChangeLanguageButtonDisplayed() {
        onView(withId(R.id.buttonChangeLang)).check(matches(isDisplayed()))
    }

    @Test
    fun checkChangeLanguageDisplayed() {
        onView(withId(R.id.buttonChangeLang)).perform(click())
        onView(withText("Russian")).check(matches(isDisplayed()));
        onView(withText("Chinese")).check(matches(isDisplayed()));
        onView(withText("English")).check(matches(isDisplayed()));
    }
    @Test
    fun checkChangeLanguageChinese() {
        onView(withId(R.id.buttonChangeLang)).perform(click())
        onView(withText("Chinese")).check(matches(isDisplayed()));
        onView(withText("Chinese")).perform(click())
    }
    @Test
    fun checkChangeLanguageRussian() {
        onView(withId(R.id.buttonChangeLang)).perform(click())
        onView(withText("Russian")).check(matches(isDisplayed()));
        onView(withText("Russian")).perform(click())
    }
    @Test
    fun checkChangeLanguageEnglish() {
        onView(withId(R.id.buttonChangeLang)).perform(click())
        onView(withText("English")).check(matches(isDisplayed()));
        onView(withText("English")).perform(click())
    }

}