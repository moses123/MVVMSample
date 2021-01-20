package com.sia.tech.kata.price

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
import java.math.BigDecimal

@RunWith(MockitoJUnitRunner::class)
class PriceViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @InjectMocks
    private lateinit var subject: PriceViewModel

    @Mock
    private lateinit var currencyConversionService: CurrencyConversionService

    @Mock
    private lateinit var compositeDisposable: CompositeDisposable

    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    lateinit var response: CurrencyConversionResponse


    @Before
    fun setUp() {
        `when`(currencyConversionService.getLatestUpdate()).thenReturn(
            Observable.just(
                response
            )
        )
        `when`(response.rates.HKD).thenReturn(BigDecimal.TEN)
    }

    @Test
    fun onViewCreated_providedApiCallSuccess_returnsValue() {
        subject.onViewCreated()

        verify(currencyConversionService).getLatestUpdate()
        assertThat(subject.priceLiveData.value).isEqualTo("price : 10")
    }

    @Test
    fun onViewPaused_clearsDisposable() {
        subject.onViewPaused(       )
        verify(compositeDisposable).clear()
    }
}
