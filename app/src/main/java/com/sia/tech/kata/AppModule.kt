package com.sia.tech.kata

import android.content.Context
import com.sia.tech.kata.currency.CurrencyApiLibrary
import com.sia.tech.kata.currency.conversion.CurrencyConversionService
import com.sia.tech.kata.network.NetworkLibrary
import com.sia.tech.kata.network.support.NetworkConfiguration
import com.sia.tech.kata.support.NetworkConfigurationImpl
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import io.reactivex.disposables.CompositeDisposable
import retrofit2.Retrofit

@Module
class AppModule {

    @Provides
    fun providesNetworkConfiguration(context: Context): NetworkConfiguration =
        NetworkConfigurationImpl(context)

    @Provides
    fun providesNetworkLibrary(networkConfiguration: NetworkConfiguration) =
        NetworkLibrary(networkConfiguration)

    @Provides
    fun providesRetrofit(
        networkLibrary: NetworkLibrary
    ): Retrofit {
        val okHttpBuilder = networkLibrary.okHttpClient()
            .newBuilder()

        val okHttpClient = okHttpBuilder
            .build()

        return networkLibrary.retrofit().newBuilder().client(okHttpClient).build()
    }

    @Provides
    fun providesCompositeDisposable(): CompositeDisposable = CompositeDisposable()


    @Provides
    fun providesCurrencyApiLibrary(retrofit: Retrofit, networkConfiguration: NetworkConfiguration) =
        CurrencyApiLibrary(retrofit, networkConfiguration)

    @Provides
    fun providesCurrencyConversionService(library: CurrencyApiLibrary): CurrencyConversionService =
        library.currencyConversionService()

}
