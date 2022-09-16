package aaa.bivizul.a30project.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MainContent(
    component: ItemMain,
    modifier: Modifier = Modifier
) {

    Column(modifier = modifier.fillMaxSize()){
        Text("MainContent")
        Button(
            onClick = { component.onClicked() }
        ){
            Text("List")
        }
    }


}