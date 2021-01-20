package com.sia.tech.kata.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sia.tech.kata.R
import com.sia.tech.kata.TechKataApplication
import com.sia.tech.kata.currency.CurrencyActivity
import com.sia.tech.kata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), LifecycleOwner {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var viewDataBinding: ViewDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as TechKataApplication).appComponent.inject(this)
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        lifecycle.addObserver(mainViewModel)

        (viewDataBinding as ActivityMainBinding).lifecycleOwner = this
        (viewDataBinding as ActivityMainBinding).mainViewModel = mainViewModel

        mainViewModel.mainLiveData.observe(this, Observer {
            if (it) {
                startActivity(Intent(this, CurrencyActivity::class.java))
            }
        })
    }
}