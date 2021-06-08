package com.example.saveup

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test

import org.junit.Rule
import org.junit.runner.RunWith
import java.lang.Thread.sleep

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
    fun checkWelcomeIsDisplayed() {
        onView(withId(R.id.Log_In)).perform(click())
        onView(withId(R.id.welcome_back)).check(matches(isDisplayed()))
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
        onView(withId(R.id.login_password)).perform(typeText("root")).
            perform(closeSoftKeyboard())
        onView(withId(R.id.login_button)).perform(click())
        onView(withId(R.id.form_list)).check(matches(isDisplayed()))
    }

    @Test
    fun checkLoginFormChinese() {
        onView(withId(R.id.buttonChangeLang)).perform(click())
        onView(withText("Chinese")).check(matches(isDisplayed()))
        onView(withText("Chinese")).perform(click())
        onView(withId(R.id.Log_In)).perform(click())
        onView(withText("歡迎回來！")).check(matches(isDisplayed()))
        onView(withText("電子郵件")).check(matches(isDisplayed()))
        onView(withText("密碼")).check(matches(isDisplayed()))
    }

    @Test
    fun checkChangeLanguageChinese() {
        onView(withId(R.id.buttonChangeLang)).perform(click())
        onView(withText("Chinese")).check(matches(isDisplayed()))
        onView(withText("Chinese")).perform(click())
        onView(withId(R.id.Log_In)).perform(click())
        onView(withId(R.id.login_email)).perform(typeText("root@root.at"))
        onView(withId(R.id.login_password)).perform(typeText("root")).
        perform(ViewActions.closeSoftKeyboard())
        onView(withId(R.id.login_button)).perform(click())
        onView(withId(R.id.form_list)).check(matches(isDisplayed()))
    }

    @Test
    fun checkLoginFormRussian() {
        onView(withId(R.id.buttonChangeLang)).perform(click())
        onView(withText("Russian")).check(matches(isDisplayed()))
        onView(withText("Russian")).perform(click())
        onView(withId(R.id.Log_In)).perform(click())
        onView(withText("Добро пожаловать обратно!")).check(matches(isDisplayed()))
        onView(withText("Электронное письмо")).check(matches(isDisplayed()))
        onView(withText("Пароль")).check(matches(isDisplayed()))
    }

    @Test
    fun checkChangeLanguageRussian() {
        onView(withId(R.id.buttonChangeLang)).perform(click())
        onView(withText("Russian")).check(matches(isDisplayed()))
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
        onView(withId(R.id.buttonChangeLang)).perform(click())
        onView(withText("English")).check(matches(isDisplayed()))
        onView(withText("English")).perform(click())
        onView(withId(R.id.Log_In)).perform(click())
        onView(withId(R.id.login_email)).perform(typeText("root@root.at"))
        onView(withId(R.id.login_password)).perform(typeText("root")).
        perform(ViewActions.closeSoftKeyboard())
        onView(withId(R.id.login_button)).perform(click())
        onView(withId(R.id.form_list)).check(matches(isDisplayed()))
    }
    @Test
    fun checkDatabaseLoginTrue() {
        onView(withId(R.id.buttonChangeLang)).perform(click())
        onView(withText("English")).check(matches(isDisplayed()))
        onView(withText("English")).perform(click())

        onView(withId(R.id.Sign_Up)).perform(click())
        onView(withId(R.id.registration_prename)).perform(typeText("Max"))
        onView(withId(R.id.registration_lastname)).perform(typeText("Mustermann"))
        onView(withId(R.id.registration_email)).perform(typeText("max@mustermann.xxx")).
        perform(ViewActions.closeSoftKeyboard())
        onView(withId(R.id.registration_password)).perform(typeText("test123")).
        perform(ViewActions.closeSoftKeyboard())
        onView(withId(R.id.registration_button)).perform(click())
        sleep(5000)

        onView(withId(R.id.login_email)).perform(typeText("max@mustermann.xxx"))
        onView(withId(R.id.login_password)).perform(typeText("test123")).
        perform(ViewActions.closeSoftKeyboard())
        onView(withId(R.id.login_button)).perform(click())
        sleep(5000)
        onView(withText("profile page")).check(matches(isDisplayed()))
    }
    @Test
    fun checkDatabaseLoginFalse() {
        onView(withId(R.id.buttonChangeLang)).perform(click())
        onView(withText("English")).check(matches(isDisplayed()))
        onView(withText("English")).perform(click())

        onView(withId(R.id.Sign_Up)).perform(click())
        onView(withId(R.id.registration_prename)).perform(typeText("Max"))
        onView(withId(R.id.registration_lastname)).perform(typeText("Mustermann"))
        onView(withId(R.id.registration_email)).perform(typeText("max@mustermann.xxx")).
        perform(ViewActions.closeSoftKeyboard())
        onView(withId(R.id.registration_password)).perform(typeText("test123")).
        perform(ViewActions.closeSoftKeyboard())
        onView(withId(R.id.registration_button)).perform(click())
        sleep(5000)

        onView(withId(R.id.login_email)).perform(typeText("max@mustermann.xxx"))
        onView(withId(R.id.login_password)).perform(typeText("apfel123")).
        perform(ViewActions.closeSoftKeyboard())
        onView(withId(R.id.login_button)).perform(click())
        onView(withId(R.id.login_email)).check(matches(isDisplayed()))
    }

}