package aaa.bivizul.a30project.ui.list

import aaa.bivizul.a29project.ui.spbkwidget.Apostcp
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState

@Composable
fun ListContent(
    component: ItemList,
    modifier: Modifier = Modifier
) {

    val apostpopcryptList by component.state.collectAsState()
//    val model by component.models.subscribeAsState()

    if (apostpopcryptList != null) {
        apostpopcryptList?.let { list ->

            LazyColumn(modifier = modifier.fillMaxSize()) {
                items(list) { apostpopcrypt ->
//                    val isSelected = apostpopcrypt.id == model.selectedItemId
                    Button(
                        onClick = {
                            println("ListContent onClick id : ${apostpopcrypt.id}")
                            component.onItemClicked(id = apostpopcrypt.id)
                        }
                    ){
                        Text(apostpopcrypt.aposttitle)
                    }
                }
            }
        }

    } else {
        Apostcp()
    }

    /*Column(modifier = modifier.fillMaxSize()) {
        Text("ListContent")
//        Text(text = if (a!= "") a else "tutu")
        Button(
            onClick = { component.onClicked() }
        ) {
            Text("Details")
        }
//        Button(
//            onClick = { component.onItemClicked() }
//        ) {
//            Text("Details")
//        }
    }*/


}