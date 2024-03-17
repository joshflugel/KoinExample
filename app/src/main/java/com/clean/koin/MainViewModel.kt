package com.clean.koin

import androidx.lifecycle.ViewModel

/*  No DI, this instance var is NOT swappable
class MainviewModel: ViewModel(){
    private val repository = MainRepositoryImpl()
 */

// In CONSTRUCTOR INJECTION the instance var is now swapable,
// This improves flexibility because now,
// the ViewModel relies on the Interface, not the Implementation
// Other versions of MainRepository that don't use the actual API
// but rather use simulations or mocks can be swapped in.
class MainViewModel(
    private val repository: MainRepository
): ViewModel() {

    fun doNetworkCall() {
        println("Doing NETWORK_CALL")
        //repository.doNetworkCall()
    }
}