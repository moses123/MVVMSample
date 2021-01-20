package com.sia.tech.kata.base.mockconfig

import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest

class CurrencyRequestHandler : RecordedRequestHandler() {

    override fun canHandleRequest(request: RecordedRequest): Boolean {
        return request.method == "GET" && request.path.contains(CURRENCY_ENDPOINT)
    }

    override fun getResponse(request: RecordedRequest): MockResponse {
        val body = readJsonFile("currency/get.json")
        return getResponseWithBody(200, body)
    }

    companion object {

        private const val CURRENCY_ENDPOINT = "/latest"
    }
}
