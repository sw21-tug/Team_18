package com.example.saveup

import android.content.Intent
import android.widget.Button
import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)

class RegistrationActivityTest {

    @Rule @JvmField var activityRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

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

    @Test
    fun checkSignUpFormEnglish() {
        onView(withId(R.id.buttonChangeLang)).perform(click())
        onView(withText("English")).check(matches(isDisplayed()))
        onView(withText("English")).perform(click())
        onView(withId(R.id.Sign_Up)).perform(click())
        onView(withText("First Name")).check(matches(isDisplayed()))
        onView(withText("Name")).check(matches(isDisplayed()))
        onView(withText("Email")).check(matches(isDisplayed()))
        onView(withText("Password")).check(matches(isDisplayed()))
        onView(withText("Create Account")).check(matches(isDisplayed()))
    }

    @Test
    fun checkSignUpFormRussian() {
        onView(withId(R.id.buttonChangeLang)).perform(click())
        onView(withText("Russian")).check(matches(isDisplayed()))
        onView(withText("Russian")).perform(click())
        onView(withId(R.id.Sign_Up)).perform(click())
        onView(withText("Имя")).check(matches(isDisplayed()))
        onView(withText("Фамилия")).check(matches(isDisplayed()))
        onView(withText("Электронное письмо")).check(matches(isDisplayed()))
        onView(withText("Пароль")).check(matches(isDisplayed()))
        onView(withText("Зарегистрироваться")).check(matches(isDisplayed()))
    }

    @Test
    fun checkSignUpFormChinese() {
        onView(withId(R.id.buttonChangeLang)).perform(click())
        onView(withText("Chinese")).check(matches(isDisplayed()))
        onView(withText("Chinese")).perform(click())
        onView(withId(R.id.Sign_Up)).perform(click())
        onView(withText("名")).check(matches(isDisplayed()))
        onView(withText("姓")).check(matches(isDisplayed()))
        onView(withText("電子郵件")).check(matches(isDisplayed()))
        onView(withText("密碼")).check(matches(isDisplayed()))
        onView(withText("創建帳號")).check(matches(isDisplayed()))
    }
}