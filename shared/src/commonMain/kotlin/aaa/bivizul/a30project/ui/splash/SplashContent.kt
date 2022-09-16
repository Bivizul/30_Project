package aaa.bivizul.a30project.ui.splash

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay

@Composable
fun SplashContent(
    component: ItemSplash,
    modifier: Modifier = Modifier
) {

    println("SplashContent")

    LaunchedEffect(Unit){
        delay(3000)
        component.onClicked()
    }

    Column(modifier = modifier.fillMaxSize()) {
        Text("SplashContent")
        Button(
            onClick = {
                component.onClicked()
            }
        ) {
            Text("Main")
        }
    }


}