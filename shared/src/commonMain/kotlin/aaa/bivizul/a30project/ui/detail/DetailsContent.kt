package aaa.bivizul.a30project.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DetailsContent(
    component: ItemDetails,
    modifier: Modifier = Modifier
) {

    Column(modifier = modifier.fillMaxSize()){
        Text("DetailsContent")
//        Button(
//            onClick = { component.onClicked() }
//        ){
//            Text("Next")
//        }
    }


}