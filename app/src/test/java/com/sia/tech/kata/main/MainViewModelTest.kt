package com.sia.tech.kata.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.assertj.core.api.Assertions.assertThat
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {

    @InjectMocks
    private lateinit var subject: MainViewModel

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Test
    fun onLoginClicked_() {
        subject.goToCurrencyButtonClicked()

        assertThat(subject.mainLiveData.value).isTrue()
    }
}