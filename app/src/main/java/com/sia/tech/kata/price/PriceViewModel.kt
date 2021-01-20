package com.sia.tech.kata.price

import androidx.lifecycle.*
import com.sia.tech.kata.currency.conversion.CurrencyConversionService
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class PriceViewModel @Inject constructor(
    private val currencyConversionService: CurrencyConversionService,
    private val compositeDisposable: CompositeDisposable
) : ViewModel(), LifecycleObserver {

    var priceLiveData = MutableLiveData("100")

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onViewCreated() {

        val disposable = currencyConversionService.getLatestUpdate().subscribe {
            priceLiveData.postValue("price : ${it.rates.HKD}")
        }
        compositeDisposable.add(disposable)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onViewPaused() {
        compositeDisposable.clear()
    }
}
