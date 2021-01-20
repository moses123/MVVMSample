package com.sia.tech.kata.price

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.sia.tech.kata.R
import com.sia.tech.kata.SampleApplication
import com.sia.tech.kata.databinding.ActivityPriceBinding
import dagger.android.DispatchingAndroidInjector
import kotlinx.android.synthetic.main.activity_price.*
import javax.inject.Inject

class PriceActivity : AppCompatActivity(), LifecycleOwner {

    private lateinit var viewDataBinding: ViewDataBinding
    private lateinit var priceViewModel: PriceViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Any>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as SampleApplication).appComponent.inject(this)
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_price)
        priceViewModel = ViewModelProvider(this, viewModelFactory)
            .get(PriceViewModel::class.java)
        lifecycle.addObserver(priceViewModel)

        (viewDataBinding as ActivityPriceBinding).lifecycleOwner = this
        (viewDataBinding as ActivityPriceBinding).priceViewModel = priceViewModel

        priceViewModel.priceLiveData.observe(this, {

            priceText.text = it
        })


    }
}
