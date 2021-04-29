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

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ProfileActivityTest {

    @Rule @JvmField var activityRule: ActivityScenarioRule<MainActivity> =
            ActivityScenarioRule(MainActivity::class.java)

    private fun getToProfilePage() {
        onView(withId(R.id.Log_In)).perform(click())
        onView(withId(R.id.login_email)).perform(typeText("root@root.at"))
        onView(withId(R.id.login_password)).perform(typeText("root")).
        perform(ViewActions.closeSoftKeyboard())
        onView(withId(R.id.login_button)).perform(click())
        onView(withId(R.id.profile_title)).check(matches(isDisplayed()))
    }

    @Test
    fun checkFormButtonIsDisplayed() {
        getToProfilePage()
        onView(withId(R.id.form_button)).check(matches(isDisplayed()))
    }

    @Test
    fun checkAFormButtonIsClickable() {
        getToProfilePage()
        onView(withId(R.id.form_button)).check(matches(isClickable()))
    }

    @Test
    fun checkIncomeButton() {
        getToProfilePage()
        onView(withId(R.id.formular_button)).perform(click())

        onView(withId(R.id.formular_button)).check(matches(isDisplayed()))
        onView(withId(R.id.formular_button)).check(matches(isClickable()))
    }

    @Test
    fun checkExpenseButton() {
        getToProfilePage()
        onView(withId(R.id.formular_button)).perform(click())

        onView(withId(R.id.formular_button)).check(matches(isDisplayed()))
        onView(withId(R.id.formular_button)).check(matches(isClickable()))
    }

    @Test
    fun checkAllIncomeTextViewsAreDisplayed() {
        getToProfilePage()
        onView(withId(R.id.form_button)).perform(click())

        onView(withId(R.id.income_title)).check(matches(isDisplayed()))
        onView(withId(R.id.date_title)).check(matches(isDisplayed()))
        onView(withId(R.id.account_title)).check(matches(isDisplayed()))
        onView(withId(R.id.category_title)).check(matches(isDisplayed()))
        onView(withId(R.id.description_title)).check(matches(isDisplayed()))
    }

    @Test
    fun checkAllExpenseTextViewsAreDisplayed() {
        getToProfilePage()
        onView(withId(R.id.form_button)).perform(click())
        onView(withId(R.id.expense_button)).perform(click())

        onView(withId(R.id.income_title)).check(matches(isDisplayed()))
        onView(withId(R.id.date_title)).check(matches(isDisplayed()))
        onView(withId(R.id.account_title)).check(matches(isDisplayed()))
        onView(withId(R.id.category_title)).check(matches(isDisplayed()))
        onView(withId(R.id.description_title)).check(matches(isDisplayed()))
    }

    @Test
    fun checkAllIncomeTextViewsAreWritable() {
        getToProfilePage()
        onView(withId(R.id.form_button)).perform(click())

        onView(withId(R.id.income_text)).perform(typeText("1000"))
        onView(withId(R.id.date_text)).perform(typeText("1.1.2020"))
        onView(withId(R.id.account_text)).perform(typeText("business"))
        onView(withId(R.id.category_text)).perform(typeText("computer"))
        onView(withId(R.id.description_text)).
            perform(typeText("monitor with keyboard"))
    }

    @Test
    fun checkAllExpenseTextViewsAreWritable() {
        getToProfilePage()
        onView(withId(R.id.form_button)).perform(click())
        onView(withId(R.id.expense_button)).perform(click())

        onView(withId(R.id.income_text)).perform(typeText("1000"))
        onView(withId(R.id.date_text)).perform(typeText("1.1.2020"))
        onView(withId(R.id.account_text)).perform(typeText("business"))
        onView(withId(R.id.category_text)).perform(typeText("computer"))
        onView(withId(R.id.description_text)).
        perform(typeText("monitor with keyboard"))
    }

    @Test
    fun checkIfSaveButtonIsDisplayedAndClickableInIncome() {
        getToProfilePage()
        onView(withId(R.id.form_button)).perform(click())

        onView(withId(R.id.save_button)).check(matches(isDisplayed()))
        onView(withId(R.id.save_button)).check(matches(isClickable()))
    }

    @Test
    fun checkIfSaveButtonIsDisplayedAndClickableInExpense() {
        getToProfilePage()
        onView(withId(R.id.form_button)).perform(click())
        onView(withId(R.id.expense_button)).perform(click())

        onView(withId(R.id.save_button)).check(matches(isDisplayed()))
        onView(withId(R.id.save_button)).check(matches(isClickable()))
    }

    @Test
    fun checkFormBackButton() {
        getToProfilePage()
        onView(withId(R.id.form_button)).perform(click())
        onView(withId(R.id.form_back_button)).check(matches(isDisplayed()))
        onView(withId(R.id.form_back_button)).check(matches(isClickable()))
    }

    @Test
    fun checkReturnToProfilePage() {
        getToProfilePage()
        onView(withId(R.id.form_button)).perform(click())
        onView(withId(R.id.form_back_button)).perform(click())
        onView(withId(R.id.profile_title)).check(matches(isDisplayed()))
    }
}