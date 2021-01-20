package com.sia.tech.kata

import android.content.Context
import com.sia.tech.kata.currency.CurrencyActivity
import com.sia.tech.kata.currency.CurrencyModule
import com.sia.tech.kata.main.MainActivity
import com.sia.tech.kata.price.PriceActivity
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        ViewModelModule::class,
        CurrencyModule::class
    ]
)
interface ApplicationComponent {

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance context: Context): ApplicationComponent
    }

    fun inject(mainActivity: MainActivity)

    fun inject(currencyActivity: CurrencyActivity)

    fun inject(priceActivity: PriceActivity)
}
