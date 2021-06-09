package com.example.saveup

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test

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
        onView(withId(R.id.buttonChangeLangtest)).check(matches(isDisplayed()))
    }

    @Test
    fun checkChangeLanguageDisplayed() {
        onView(withId(R.id.buttonChangeLangtest)).perform(click())
        onView(withText("Russian")).check(matches(isDisplayed()));
        onView(withText("Chinese")).check(matches(isDisplayed()));
        onView(withText("English")).check(matches(isDisplayed()));
    }
    @Test
    fun checkChangeLanguageChinese() {
        onView(withId(R.id.buttonChangeLangtest)).perform(click())
        onView(withText("Chinese")).check(matches(isDisplayed()));
        onView(withText("Chinese")).perform(click())
        onView(withId(R.id.Log_In)).perform(click())
        onView(withId(R.id.login_email)).perform(typeText("root@root.at"))
        onView(withId(R.id.login_password)).perform(typeText("root")).
        perform(ViewActions.closeSoftKeyboard())
        onView(withId(R.id.login_button)).perform(click())
        onView(withId(R.id.form_list)).check(matches(isDisplayed()))
    }
    @Test
    fun checkChangeLanguageRussian() {
        onView(withId(R.id.buttonChangeLangtest)).perform(click())
        onView(withText("Russian")).check(matches(isDisplayed()));
        onView(withText("Russian")).perform(click())
        onView(withId(R.id.Log_In)).perform(click())
        onView(withId(R.id.login_email)).perform(typeText("root@root.at"))
        onView(withId(R.id.login_password)).perform(typeText("root")).
        perform(ViewActions.closeSoftKeyboard())
        onView(withId(R.id.login_button)).perform(click())
        onView(withId(R.id.form_list)).check(matches(isDisplayed()))
    }
    @Test
    fun checkChangeLanguageEnglish() {
        onView(withId(R.id.buttonChangeLangtest)).perform(click())
        onView(withText("English")).check(matches(isDisplayed()));
        onView(withText("English")).perform(click())
        onView(withId(R.id.Log_In)).perform(click())
        onView(withId(R.id.login_email)).perform(typeText("root@root.at"))
        onView(withId(R.id.login_password)).perform(typeText("root")).
        perform(ViewActions.closeSoftKeyboard())
        onView(withId(R.id.login_button)).perform(click())
        onView(withId(R.id.form_list)).check(matches(isDisplayed()))
    }
}