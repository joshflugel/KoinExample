package com.clean.koin

class MainRepositoryImpl(
    private val api: MyApi
): MainRepository {

    // don't declare vars here!!

    override fun doNetworkCall() {
        api.callApi()
    }

}