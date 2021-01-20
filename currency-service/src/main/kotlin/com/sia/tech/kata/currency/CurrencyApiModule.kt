package com.sia.tech.kata.currency

import com.sia.tech.kata.currency.conversion.CurrencyConversionService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class CurrencyApiModule {

    @Provides
    fun providesUserDetailsService(retrofit: Retrofit): CurrencyConversionService =
        retrofit.create(CurrencyConversionService::class.java)
}
