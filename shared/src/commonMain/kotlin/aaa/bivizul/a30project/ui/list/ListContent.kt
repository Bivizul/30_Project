package aaa.bivizul.a30project.ui.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ListContent(
    component: ItemList,
    modifier: Modifier = Modifier
) {

    Column(modifier = modifier.fillMaxSize()){
        Text("ListContent")
        Button(
            onClick = { component.onClicked() }
        ){
            Text("Details")
        }
    }


}