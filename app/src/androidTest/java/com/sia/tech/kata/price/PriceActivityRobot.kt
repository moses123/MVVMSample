package com.sia.tech.kata.price

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.sia.tech.kata.R

class PriceActivityRobot {

    fun seesPriceText(text: String): PriceActivityRobot {
        Espresso.onView(withId(R.id.priceText))
            .check(matches(withText(text)))
        return this
    }
}
