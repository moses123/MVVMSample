package com.sia.tech.kata.currency

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sia.tech.kata.R
import com.sia.tech.kata.SampleApplication
import com.sia.tech.kata.databinding.ActivityCurrencyBinding
import com.sia.tech.kata.price.PriceViewModel
import kotlinx.android.synthetic.main.activity_currency.*
import javax.inject.Inject

class CurrencyActivity : AppCompatActivity(), LifecycleOwner {

    private lateinit var currencyViewModel: CurrencyViewModel
    private lateinit var priceViewModel: PriceViewModel
    private lateinit var viewDataBinding: ViewDataBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as SampleApplication).appComponent.inject(this)
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_currency)

        currencyViewModel = ViewModelProvider(this, viewModelFactory)
            .get(CurrencyViewModel::class.java)
        priceViewModel = ViewModelProvider(this, viewModelFactory)
            .get(PriceViewModel::class.java)

        lifecycle.addObserver(currencyViewModel)

        (viewDataBinding as ActivityCurrencyBinding).lifecycleOwner = this
        (viewDataBinding as ActivityCurrencyBinding).currencyViewModel = currencyViewModel
        (viewDataBinding as ActivityCurrencyBinding).priceViewModel = priceViewModel

        currencyViewModel.currencyLiveData.observe(
            this,
            Observer { currencyText.text = it }
        )

        priceViewModel.priceLiveData.observe(
            this,
            Observer { priceText.text = it }
        )
    }
}
