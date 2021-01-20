package com.sia.tech.kata.currency

import com.sia.tech.kata.R
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText

class CurrencyActivityRobot {

    fun seesValue(titleString: String) {
        onView(withId(R.id.currencyText))
            .check(matches(withText(titleString)))
    }
}