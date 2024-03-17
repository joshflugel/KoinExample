package com.clean.koin

import org.koin.core.qualifier.named
import org.koin.dsl.module

val activityModule = module {
    scope<MainActivity> {
        scoped(qualifier = named("hello")) {"Hello"}            //Scopes hello only to MainActivity's Lifecycle
        scoped(qualifier = named("bye")) {"Bye"}
    }
}