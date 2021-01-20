package com.sia.tech.kata.price

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sia.tech.kata.base.TechKataTestRule
import com.sia.tech.kata.base.mockconfig.MockWebServerRobot
import com.sia.tech.kata.base.mockconfig.MockWebServerRule
import com.sia.tech.kata.base.mockconfig.UserAction
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PriceActivityTest {

    @get:Rule
    val activityRule = TechKataTestRule(PriceActivity::class.java)

    @get:Rule
    val mockWebServerRule = MockWebServerRule()

    private val mockWebServerRobot = MockWebServerRobot(mockWebServerRule)
    private val priceActivityRobot = PriceActivityRobot()

    @Test
    fun onLaunch_seesPrice() {
        activityRule.launchActivity()

//        mockWebServerRobot
//            .useDefaultDispatcher()
//            .performNoSyncAction(object : UserAction {
//                override fun perform() {
//                    priceActivityRobot
//                        .seesPriceText("100")
//                }
//
//            })

        priceActivityRobot
            .seesPriceText("price : 9.1412")

    }

}
