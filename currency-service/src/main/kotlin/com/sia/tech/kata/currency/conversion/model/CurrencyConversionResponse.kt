package com.sia.tech.kata.currency.conversion.model

import java.math.BigDecimal

data class CurrencyConversionResponse(
    val rates: Rates,
    val date: String,
) {
    data class Rates(
        val USD: BigDecimal,
        val JPY: BigDecimal,
        val HKD: BigDecimal,
        val INR: BigDecimal
    )
}
