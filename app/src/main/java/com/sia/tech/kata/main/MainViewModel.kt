package com.sia.tech.kata.main

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor() : ViewModel(), LifecycleObserver {

    var mainLiveData = MutableLiveData(false)

    fun goToCurrencyButtonClicked() {
        mainLiveData.value = true
    }
}