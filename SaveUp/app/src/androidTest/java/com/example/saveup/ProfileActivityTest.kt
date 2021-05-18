package com.example.saveup

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
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
        onView(withId(R.id.form_list)).check(matches(isDisplayed()))
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
        onView(withId(R.id.form_button)).perform(click())

        onView(withText("Income")).check(matches(isDisplayed()))
    }

    @Test
    fun checkExpenseButton() {
        getToProfilePage()
        onView(withId(R.id.form_button)).perform(click())

        onView(withText("Expense")).check(matches(isDisplayed()))
    }

    @Test
    fun checkAllIncomeTextViewsAreDisplayed() {
        getToProfilePage()
        onView(withId(R.id.form_button)).perform(click())

        onView(withId(R.id.euro_income)).check(matches(isDisplayed()))
        onView(withId(R.id.date_input_field_income)).check(matches(isDisplayed()))
        onView(withId(R.id.account_input_field_income)).check(matches(isDisplayed()))
        onView(withId(R.id.category_input_field_income)).check(matches(isDisplayed()))
        onView(withId(R.id.description_input_field_income)).check(matches(isDisplayed()))
    }

    @Test
    fun checkAllExpenseTextViewsAreDisplayed() {
        getToProfilePage()
        onView(withId(R.id.form_button)).perform(click())
        onView(withText("Expense")).perform(click())

        onView(withId(R.id.euro_expense)).check(matches(isDisplayed()))
        onView(withId(R.id.date_input_field_expense)).check(matches(isDisplayed()))
        onView(withId(R.id.account_input_field_expense)).check(matches(isDisplayed()))
        onView(withId(R.id.category_input_field_expense)).check(matches(isDisplayed()))
        onView(withId(R.id.description_input_field_expense)).check(matches(isDisplayed()))
    }

    @Test
    fun checkAllIncomeTextViewsAreWritable() {
        getToProfilePage()
        onView(withId(R.id.form_button)).perform(click())

        onView(withId(R.id.euro_income)).perform(typeText("1000"))
        onView(withId(R.id.date_input_field_income)).perform(typeText("01.01.2020"))
        onView(withId(R.id.account_input_field_income)).perform(typeText("business"))
        onView(withId(R.id.category_input_field_income)).perform(typeText("computer"))
        onView(withId(R.id.description_input_field_income)).
            perform(typeText("monitor with keyboard"))
    }

    @Test
    fun checkAllExpenseTextViewsAreWritable() {
        getToProfilePage()
        onView(withId(R.id.form_button)).perform(click())
        onView(withText("Expense")).perform(click())

        onView(withId(R.id.euro_expense)).perform(typeText("1000"))
        onView(withId(R.id.date_input_field_expense)).perform(typeText("1.1.2020"))
        onView(withId(R.id.account_input_field_expense)).perform(typeText("business"))
        onView(withId(R.id.category_input_field_expense)).perform(typeText("computer"))
        onView(withId(R.id.description_input_field_expense)).
        perform(typeText("monitor with keyboard"))
    }

    @Test
    fun checkIfSaveButtonIsDisplayedAndClickableInIncome() {
        getToProfilePage()
        onView(withId(R.id.form_button)).perform(click())

        onView(withId(R.id.save_button_income)).check(matches(isDisplayed()))
        onView(withId(R.id.save_button_income)).check(matches(isClickable()))
    }

    @Test
    fun checkIfSaveButtonIsDisplayedAndClickableInExpense() {
        getToProfilePage()
        onView(withId(R.id.form_button)).perform(click())
        onView(withText("Expense")).perform(click())

        onView(withId(R.id.save_button_expense)).check(matches(isDisplayed()))
        onView(withId(R.id.save_button_expense)).check(matches(isClickable()))
    }

    @Test
    fun checkTableHeaderIsDisplayed() {
        getToProfilePage()
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

        onView(withId(R.id.form_button)).perform(click())

        onView(withId(R.id.euro_income)).check(matches(isDisplayed()))
        onView(withId(R.id.date_input_field_income)).check(matches(isDisplayed()))
        onView(withId(R.id.account_input_field_income)).check(matches(isDisplayed()))
        onView(withId(R.id.category_input_field_income)).check(matches(isDisplayed()))
        onView(withId(R.id.description_input_field_income)).check(matches(isDisplayed()))
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

        onView(withId(R.id.form_button)).perform(click())

        onView(withId(R.id.euro_income)).check(matches(isDisplayed()))
        onView(withId(R.id.date_input_field_income)).check(matches(isDisplayed()))
        onView(withId(R.id.account_input_field_income)).check(matches(isDisplayed()))
        onView(withId(R.id.category_input_field_income)).check(matches(isDisplayed()))
        onView(withId(R.id.description_input_field_income)).check(matches(isDisplayed()))
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

        onView(withId(R.id.form_button)).perform(click())

        onView(withId(R.id.euro_income)).check(matches(isDisplayed()))
        onView(withId(R.id.date_input_field_income)).check(matches(isDisplayed()))
        onView(withId(R.id.account_input_field_income)).check(matches(isDisplayed()))
        onView(withId(R.id.category_input_field_income)).check(matches(isDisplayed()))
        onView(withId(R.id.description_input_field_income)).check(matches(isDisplayed()))
    }
}