package com.clean.koin

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val appModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://google.com")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(MyApi::class.java)  //MyApi specifies the interface that needs to be created
    }
    
    // single always the same instance
    // factory returns a new instance for every val
    single<MainRepository> { // < > is used to return the Abstraction of the Implementation
        MainRepositoryImpl(get())  //MyApi is needed, get() tells this dependency can be taken from this module
    }

    // Injecting ViewModels in Koin works like this:
    viewModel {
        MainViewModel(get())
    }
}