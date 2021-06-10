package com.example.saveup

import android.content.Context
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.DrawerActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Thread.sleep

@RunWith(AndroidJUnit4::class)
class ProfileActivityTest {

    @get:Rule var activityRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Before fun setUp()
    {
        if(getApplicationContext<Context>().getSharedPreferences("User", Context.MODE_PRIVATE).getString("user_token", null) == null)
        {
            onView(withId(R.id.Log_In)).perform(click())
            onView(withId(R.id.login_email)).perform(typeText("root@root.at"))
            onView(withId(R.id.login_password)).perform(typeText("root")).
            perform(ViewActions.closeSoftKeyboard())
            onView(withId(R.id.login_button)).perform(click())
            sleep(1500) // due to login delay
        }
    }

    @After fun tearDown()
    {
        if(getApplicationContext<Context>().getSharedPreferences("User", Context.MODE_PRIVATE).getString("user_token", null) != null)
        {
            onView(withId(R.id.drawerLayout)).perform(DrawerActions.open())
            onView(withId(R.id.navigation_logout)).perform(click())
        }
    }

    @Test
    fun checkLogout() {
        onView(withId(R.id.drawerLayout)).perform(DrawerActions.open())
        onView(withId(R.id.navigation_logout)).perform(click())
        onView(withId(R.id.Log_In)).check(matches(isDisplayed()))
        assertNull(getApplicationContext<Context>().getSharedPreferences("User", Context.MODE_PRIVATE).getString("user_token", null))
    }

    @Test
    fun checkFormButtonIsDisplayed() {
        onView(withId(R.id.form_button)).check(matches(isDisplayed()))
    }

    @Test
    fun checkAFormButtonIsClickable() {
        onView(withId(R.id.form_button)).check(matches(isClickable()))
    }

    @Test
    fun checkIncomeButton() {
        onView(withId(R.id.form_button)).perform(click())

        onView(withText(R.string.tab_text_1)).check(matches(isDisplayed()))
        pressBack()
    }

    @Test
    fun checkExpenseButton() {
        onView(withId(R.id.form_button)).perform(click())
        onView(withText(R.string.tab_text_2)).check(matches(isDisplayed()))
        pressBack()
    }

    @Test
    fun checkAllIncomeTextViewsAreDisplayed() {
        onView(withId(R.id.form_button)).perform(click())

        onView(withId(R.id.euro_income)).check(matches(isDisplayed()))
        onView(withId(R.id.date_input_field_income)).check(matches(isDisplayed()))
        onView(withId(R.id.account_input_field_income)).check(matches(isDisplayed()))
        onView(withId(R.id.category_input_field_income)).check(matches(isDisplayed()))
        onView(withId(R.id.description_input_field_income)).check(matches(isDisplayed()))
        pressBack()
    }

    @Test
    fun checkAllExpenseTextViewsAreDisplayed() {
        onView(withId(R.id.form_button)).perform(click())
        onView(withText(R.string.tab_text_2)).perform(click())

        onView(withId(R.id.euro_expense)).check(matches(isDisplayed()))
        onView(withId(R.id.date_input_field_expense)).check(matches(isDisplayed()))
        onView(withId(R.id.account_input_field_expense)).check(matches(isDisplayed()))
        onView(withId(R.id.category_input_field_expense)).check(matches(isDisplayed()))
        onView(withId(R.id.description_input_field_expense)).check(matches(isDisplayed()))
        pressBack()
    }

    @Test
    fun checkAllIncomeTextViewsAreWritable() {
        onView(withId(R.id.form_button)).perform(click())

        onView(withId(R.id.euro_income)).perform(typeText("1000"))
        onView(withId(R.id.date_input_field_income)).perform(typeText("01.01.2020"))
        onView(withId(R.id.account_input_field_income)).perform(typeText("business"))
        onView(withId(R.id.category_input_field_income)).perform(typeText("computer"))
            .perform(ViewActions.closeSoftKeyboard())
        onView(withId(R.id.description_input_field_income))
            .perform(typeText("monitor with keyboard"))
            .perform(ViewActions.closeSoftKeyboard())
        pressBack()
    }

    @Test
    fun checkAllExpenseTextViewsAreWritable() {
        onView(withId(R.id.form_button)).perform(click())
        onView(withText(R.string.tab_text_2)).perform(click())

        onView(withId(R.id.euro_expense)).perform(typeText("1000"))
        onView(withId(R.id.date_input_field_expense)).perform(typeText("1.1.2020"))
        onView(withId(R.id.account_input_field_expense)).perform(typeText("business"))
        onView(withId(R.id.category_input_field_expense)).perform(typeText("computer"))
            .perform(ViewActions.closeSoftKeyboard())
        onView(withId(R.id.description_input_field_expense))
            .perform(typeText("monitor with keyboard"))
            .perform(ViewActions.closeSoftKeyboard())

        pressBack()
    }

    @Test
    fun checkIfSaveButtonIsDisplayedAndClickableInIncome() {
        onView(withId(R.id.form_button)).perform(click())

        onView(withId(R.id.save_button_income)).check(matches(isDisplayed()))
        onView(withId(R.id.save_button_income)).check(matches(isClickable()))
        pressBack()
    }

    @Test
    fun checkIfSaveButtonIsDisplayedAndClickableInExpense() {
        onView(withId(R.id.form_button)).perform(click())
        onView(withText(R.string.tab_text_2)).perform(click())

        onView(withId(R.id.save_button_expense)).check(matches(isDisplayed()))
        onView(withId(R.id.save_button_expense)).check(matches(isClickable()))
        pressBack()
    }

    @Test
    fun checkTableHeaderIsDisplayed() {
        onView(withId(R.id.form_list)).check(matches(isDisplayed()))
    }

    @Test
    fun checkFormFieldResetIncome() {
        onView(withId(R.id.form_button)).perform(click())

        onView(withId(R.id.euro_income)).perform(typeText("1000"))
        onView(withId(R.id.date_input_field_income)).perform(typeText("01.01.2020"))
        onView(withId(R.id.account_input_field_income)).perform(typeText("business"))
        onView(withId(R.id.category_input_field_income)).perform(typeText("computer"))
            .perform(ViewActions.closeSoftKeyboard())
        onView(withId(R.id.description_input_field_income))
            .perform(typeText("monitor with keyboard"))
            .perform(ViewActions.closeSoftKeyboard())
        onView(withId(R.id.save_button_income)).perform(click())
        onView(withText("1000")).check(doesNotExist())
        onView(withText("01.01.2020")).check(doesNotExist())
        onView(withText("business")).check(doesNotExist())
        onView(withText("computer")).check(doesNotExist())
        onView(withText("monitor with keyboard")).check(doesNotExist())
        pressBack()
    }

    @Test
    fun checkFormFieldResetExpense() {
        onView(withId(R.id.form_button)).perform(click())
        onView(withText(R.string.tab_text_2)).perform(click())

        onView(withId(R.id.euro_expense)).perform(typeText("1000"))
        onView(withId(R.id.date_input_field_expense)).perform(typeText("01.01.2020"))
        onView(withId(R.id.account_input_field_expense)).perform(typeText("business"))
        onView(withId(R.id.category_input_field_expense)).perform(typeText("computer"))
            .perform(ViewActions.closeSoftKeyboard())
        onView(withId(R.id.description_input_field_expense))
            .perform(typeText("monitor with keyboard"))
            .perform(ViewActions.closeSoftKeyboard())
        onView(withId(R.id.save_button_expense)).perform(click())
        onView(withText("1000")).check(doesNotExist())
        onView(withText("01.01.2020")).check(doesNotExist())
        onView(withText("business")).check(doesNotExist())
        onView(withText("computer")).check(doesNotExist())
        onView(withText("monitor with keyboard")).check(doesNotExist())
        pressBack()
    }

    @Test
    fun checkChangeLanguageButtonDisplayed()
    {
        onView(withId(R.id.drawerLayout)).perform(DrawerActions.open())
        onView(withId(R.id.buttonChangeLang)).check(matches(isDisplayed()))
    }

    @Test
    fun checkChangeLanguageDisplayed()
    {
        onView(withId(R.id.drawerLayout)).perform(DrawerActions.open())
        onView(withId(R.id.buttonChangeLang)).perform(click())
        onView(withText("Russian")).check(matches(isDisplayed()))
        onView(withText("Chinese")).check(matches(isDisplayed()))
        onView(withText("English")).check(matches(isDisplayed()))
        pressBack()
    }

    @Test
    fun checkSelectLanguageChinese()
    {
        onView(withId(R.id.drawerLayout)).perform(DrawerActions.open())
        onView(withId(R.id.buttonChangeLang)).perform(click())
        onView(withText("Chinese")).check(matches(isDisplayed()))
        onView(withText("Chinese")).perform(click())
    }

    @Test
    fun checkSelectLanguageRussian()
    {
        onView(withId(R.id.drawerLayout)).perform(DrawerActions.open())
        onView(withId(R.id.buttonChangeLang)).perform(click())
        onView(withText("Russian")).check(matches(isDisplayed()))
        onView(withText("Russian")).perform(click())
    }

    @Test
    fun checkSelectLanguageEnglish() {
        onView(withId(R.id.drawerLayout)).perform(DrawerActions.open())
        onView(withId(R.id.buttonChangeLang)).perform(click())
        onView(withText("English")).check(matches(isDisplayed()))
        onView(withText("English")).perform(click())
    }

    @Test
    fun checkChangeLanguageChinese() {
        onView(withId(R.id.drawerLayout)).perform(DrawerActions.open())
        onView(withId(R.id.buttonChangeLang)).perform(click())
        onView(withText("Chinese")).check(matches(isDisplayed()))
        onView(withText("Chinese")).perform(click())
        onView(withId(R.id.drawerLayout)).perform(DrawerActions.close())
        onView(withId(R.id.form_button)).perform(click())
        onView(withText("費用")).check(matches(isDisplayed()))
        pressBack()
    }

    @Test
    fun checkChangeLanguageRussian() {
        onView(withId(R.id.drawerLayout)).perform(DrawerActions.open())
        onView(withId(R.id.buttonChangeLang)).perform(click())
        onView(withText("Russian")).check(matches(isDisplayed()))
        onView(withText("Russian")).perform(click())
        onView(withId(R.id.drawerLayout)).perform(DrawerActions.close())
        onView(withId(R.id.form_button)).perform(click())
        onView(withText("Расходы")).check(matches(isDisplayed()))
        pressBack()
    }

    @Test
    fun checkChangeLanguageEnglish() {
        onView(withId(R.id.drawerLayout)).perform(DrawerActions.open())
        onView(withId(R.id.buttonChangeLang)).perform(click())
        onView(withText("English")).check(matches(isDisplayed()))
        onView(withText("English")).perform(click())
        onView(withId(R.id.drawerLayout)).perform(DrawerActions.close())
        onView(withId(R.id.form_button)).perform(click())
        onView(withText(R.string.tab_text_2)).check(matches(isDisplayed()))
        pressBack()
    }

    @Test
    fun checkFilter() {
        onView(withId(R.id.filter_description)).perform(typeText("key"))
        onView(withId(R.id.filter_amount_start)).perform(typeText("90"))
        onView(withId(R.id.filter_amount_end)).perform(typeText("110"))
        onView(withId(R.id.filter_tags_button)).perform(click())
        onView(withText("Salary")).check(matches(isDisplayed()))
        onView(withText("Salary")).perform(click())
        onView(withText("OK")).perform(click())
        onView(withId(R.id.filter_submit)).perform(click())
        pressBack()
    }

    @Test
    fun checkTagsExpenses() {
        onView(withId(R.id.form_button)).perform(click())
        onView(withText(R.string.tab_text_2)).perform(click())

        onView(withId(R.id.euro_expense)).perform(typeText("1000"))
        onView(withId(R.id.date_input_field_expense)).perform(typeText("01.01.2020"))
        onView(withId(R.id.account_input_field_expense)).perform(typeText("business"))
        onView(withId(R.id.category_input_field_expense)).perform(typeText("computer"))
            .perform(ViewActions.closeSoftKeyboard())
        onView(withId(R.id.description_input_field_expense))
            .perform(typeText("monitor"))
            .perform(ViewActions.closeSoftKeyboard())
        onView(withId(R.id.tags_button_expense)).perform(click())
        onView(withText("Car")).check(matches(isDisplayed()))
        onView(withText("Car")).perform(click())
        onView(withText("OK")).perform(click())
        onView(withId(R.id.save_button_expense)).perform(click())
        pressBack()
    }

    @Test
    fun checkTagsIncome() {
        onView(withId(R.id.form_button)).perform(click())
        onView(withText(R.string.tab_text_1)).perform(click())

        onView(withId(R.id.euro_income)).perform(typeText("12000"))
        onView(withId(R.id.date_input_field_income)).perform(typeText("01.01.2020"))
        onView(withId(R.id.account_input_field_income)).perform(typeText("business"))
        onView(withId(R.id.category_input_field_income)).perform(typeText("Salary January"))
            .perform(ViewActions.closeSoftKeyboard())
        onView(withId(R.id.description_input_field_income))
            .perform(typeText("Salary"))
            .perform(ViewActions.closeSoftKeyboard())
        onView(withId(R.id.tags_button_income)).perform(click())
        onView(withText("Salary")).check(matches(isDisplayed()))
        onView(withText("Salary")).perform(click())
        onView(withText("OK")).perform(click())
        onView(withId(R.id.save_button_income)).perform(click())
        pressBack()
    }
}