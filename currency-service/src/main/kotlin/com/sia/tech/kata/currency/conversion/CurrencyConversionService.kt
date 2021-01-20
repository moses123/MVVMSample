package com.sia.tech.kata.currency.conversion

import com.sia.tech.kata.currency.conversion.model.CurrencyConversionResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface CurrencyConversionService {

    @GET("/latest")
    fun getLatestUpdate(): Observable<CurrencyConversionResponse>
}
