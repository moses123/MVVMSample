package com.sia.tech.kata

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sia.tech.kata.support.ViewModelFactory
import dagger.Binds
import dagger.MapKey
import dagger.Module
import kotlin.reflect.KClass

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelProviderFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Target(AnnotationTarget.FUNCTION)
    @Retention(AnnotationRetention.RUNTIME)
    @MapKey
    annotation class ViewModelKey(val value: KClass<out ViewModel>)
}