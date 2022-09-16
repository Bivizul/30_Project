package aaa.bivizul.a30project.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState

@Composable
fun DetailsContent(
    component: ItemDetails,
    modifier: Modifier = Modifier
) {

    val apostpopcryptList by component.state.collectAsState()
    val model by component.models.subscribeAsState()
    val a = model.selectedItemId

    println("DetailsContent a : $a")

    if (apostpopcryptList != null) {
        apostpopcryptList?.let { list ->
//            println("DetailsContent list : $list")
        }

    }

    Column(modifier = modifier.fillMaxSize()) {
        Text("DetailsContent")
//        Button(
//            onClick = { component.onClicked() }
//        ){
//            Text("Next")
//        }
    }


}