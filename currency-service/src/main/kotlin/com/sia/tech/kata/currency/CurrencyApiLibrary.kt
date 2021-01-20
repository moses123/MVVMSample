package com.sia.tech.kata.currency

import com.sia.tech.kata.network.support.NetworkConfiguration
import retrofit2.Retrofit

class CurrencyApiLibrary(
    private val retrofit: Retrofit,
    private val networkConfiguration: NetworkConfiguration
) {

    private val component = DaggerCurrencyApiComponent.builder()
        .apply {
            retrofit(retrofit)
            networkConfiguration(networkConfiguration)
        }.build()

    fun currencyConversionService() = component.provideCurrencyConversionService()
}
