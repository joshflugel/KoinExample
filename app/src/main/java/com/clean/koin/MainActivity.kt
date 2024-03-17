package com.clean.koin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.clean.koin.ui.theme.KoinTheme
import org.koin.android.ext.android.inject
import org.koin.android.scope.AndroidScopeComponent
import org.koin.androidx.scope.activityRetainedScope
import org.koin.androidx.scope.activityScope
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named
import org.koin.core.scope.Scope

// Set Scoped Dependency Injection, with AndroidScopeComponent, and ActivityScope
class MainActivity : ComponentActivity(), AndroidScopeComponent {
    override val scope: Scope by activityScope() //viewModelScope
    private val hello by inject<String>(named("hello")) //import thread safety, hello is rotation-resistant
    private val bye by inject<String>(named("bye"))

    //  private val viewModel by viewModel<MainViewModel>()   FOR XML ACTIVITIES

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println(hello)
        println(bye)
        setContent {
            KoinTheme {
                val viewModel = getViewModel<MainViewModel>() // FOR COMPOSE ACTIVITIES
                viewModel.doNetworkCall()

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KoinTheme {
        Greeting("Android")
    }
}