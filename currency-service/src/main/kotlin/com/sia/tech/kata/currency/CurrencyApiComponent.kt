package com.sia.tech.kata.currency

import com.sia.tech.kata.currency.conversion.CurrencyConversionService
import com.sia.tech.kata.network.support.NetworkConfiguration
import dagger.BindsInstance
import dagger.Component
import retrofit2.Retrofit

@Component(modules = [CurrencyApiModule::class])
interface CurrencyApiComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun retrofit(retrofit: Retrofit): Builder

        @BindsInstance
        fun networkConfiguration(networkConfiguration: NetworkConfiguration): Builder

        fun build(): CurrencyApiComponent
    }

    fun provideCurrencyConversionService() : CurrencyConversionService
}
