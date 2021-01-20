package com.sia.tech.kata.currency

import androidx.lifecycle.*
import com.sia.tech.kata.currency.conversion.CurrencyConversionService
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class CurrencyViewModel @Inject constructor(
    private val currencyConversionService: CurrencyConversionService,
    private val compositeDisposable: CompositeDisposable
) : ViewModel(), LifecycleObserver {

    var currencyLiveData = MutableLiveData("")

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onViewCreated() {
        currencyLiveData.value = "Date will be display here!"

        val disposable = currencyConversionService.getLatestUpdate()
            .subscribe {
                currencyLiveData.postValue(it.date)
            }

        compositeDisposable.add(disposable)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onViewPaused() {
        compositeDisposable.clear()
    }
}