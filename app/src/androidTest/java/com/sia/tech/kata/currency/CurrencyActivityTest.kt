package com.sia.tech.kata.currency

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.sia.tech.kata.base.TechKataTestRule
import com.sia.tech.kata.base.mockconfig.MockWebServerRobot
import com.sia.tech.kata.base.mockconfig.MockWebServerRule
import com.sia.tech.kata.base.mockconfig.UserAction
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class CurrencyActivityTest {

    @get:Rule
    val activityRule = TechKataTestRule(CurrencyActivity::class.java)
    @get:Rule
    val mockWebServerRule = MockWebServerRule()

    private val mockWebServerRobot = MockWebServerRobot(mockWebServerRule)
    private val currencyActivityRobot = CurrencyActivityRobot()

    @Test
    fun onLaunchCurrencyScreen_seesDate() {
        activityRule.launchActivity(null)

        mockWebServerRobot
            .useDefaultDispatcher()
            .performNoSyncAction(object : UserAction {
                override fun perform() {
                    currencyActivityRobot
                        .seesValue("2019-10-10")
                }
            })
    }
}