package com.sia.tech.kata.base

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.os.StrictMode
import androidx.test.runner.AndroidJUnitRunner
import com.sia.tech.kata.SampleApplication

class EspressoTechKataTestRunner : AndroidJUnitRunner() {

    override fun onCreate(arguments: Bundle) {
        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder().permitAll().build())
        super.onCreate(arguments)
    }

    override fun newApplication(cl: ClassLoader, className: String, context: Context): Application {
        RxIdlerController.initialize()
        return super.newApplication(cl, SampleApplication::class.java.name, context)
    }
}
