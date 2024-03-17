package com.clean.koin

import org.junit.Test
import org.koin.test.KoinTest
import org.koin.test.verify.verify

class CheckKoinTest : KoinTest {
    @Test
    fun checkAllModules() {
        appModule.verify()
    }
}