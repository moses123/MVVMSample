package com.sia.tech.kata.currency

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.sia.tech.kata.currency.conversion.CurrencyConversionService
import com.sia.tech.kata.currency.conversion.model.CurrencyConversionResponse
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Answers
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CurrencyViewModelTest {

    @InjectMocks
    private lateinit var subject: CurrencyViewModel

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    lateinit var currencyConversionService: CurrencyConversionService
    @Mock
    lateinit var compositeDisposable: CompositeDisposable

    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    lateinit var response: CurrencyConversionResponse

    @Before
    fun setUp() {
        `when`(currencyConversionService.getLatestUpdate())
            .thenReturn(Observable.just(response))
        `when`(response.date).thenReturn("date")
    }

    @Test
    fun onViewCreated_verifyServiceCall() {
        subject.onViewCreated()

        verify(currencyConversionService).getLatestUpdate()
    }

    @Test
    fun onViewCreated_givenServiceSuccess_showsPriceValue() {
        subject.onViewCreated()

        assertThat(subject.currencyLiveData.value).isEqualTo("date")
    }

    @Test
    fun onViewPaused_clearDisposable() {
        subject.onViewPaused()

        verify(compositeDisposable).clear()
    }
}