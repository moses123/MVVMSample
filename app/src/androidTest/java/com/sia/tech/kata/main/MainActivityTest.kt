package com.sia.tech.kata.main

import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.sia.tech.kata.base.TechKataTestRule
import com.sia.tech.kata.currency.CurrencyActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {

    @get:Rule
    val activityRule = TechKataTestRule(MainActivity::class.java)

    private val mainActivityRobot = MainActivityRobot()

    @Test
    fun onLaunchMainScreen_seesLoginButton() {
        activityRule.launchActivity(null)

        mainActivityRobot
            .seesLoginButton()
            .clicksButton()

        intended(hasComponent(CurrencyActivity::class.java.name))
    }
}