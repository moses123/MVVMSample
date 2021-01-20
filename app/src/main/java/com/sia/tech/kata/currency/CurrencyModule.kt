package com.sia.tech.kata.currency

import androidx.lifecycle.ViewModel
import com.sia.tech.kata.ViewModelModule
import com.sia.tech.kata.price.PriceViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class CurrencyModule {

    @Binds
    @IntoMap
    @ViewModelModule.ViewModelKey(CurrencyViewModel::class)
    abstract fun bindCurrencyViewModel(mainViewModel: CurrencyViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelModule.ViewModelKey(PriceViewModel::class)
    abstract fun bindPriceViewModel(priceViewModel: PriceViewModel): ViewModel

}
