package com.sia.tech.kata.network

import com.sia.tech.kata.network.support.NetworkConfiguration
import okhttp3.OkHttpClient
import retrofit2.Retrofit

class NetworkLibrary constructor(configuration: NetworkConfiguration) {

    private var component: NetworkComponent = DaggerNetworkComponent.factory().create(configuration)

    fun retrofit(): Retrofit {
        return component.retrofit()
    }

    fun okHttpClient(): OkHttpClient {
        return component.okHttpClient()
    }
}
