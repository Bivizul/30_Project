package aaa.bivizul.a30project.ui.list

import aaa.bivizul.a30project.data.apoststore.ApostpopcryptStore
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState

@Composable
fun ListContent(
    component: ItemList,
    modifier: Modifier = Modifier
) {

    val data = ApostpopcryptStore()

    LaunchedEffect(Unit){
        data.getApostpopcrypt()
    }

    val apostpopcrypt by data.apostpopcrypt.collectAsState()

//    val model: ItemList.Model by component.models.subscribeAsState()
//    val a = model.list[0].aposttitle

    if (apostpopcrypt != null){
        println("apostpopcrypt : $apostpopcrypt")
    }



    Column(modifier = modifier.fillMaxSize()){
        Text("ListContent")
//        Text(text = if (a!= "") a else "tutu")
        Button(
            onClick = { component.onClicked() }
        ){
            Text("Details")
        }
    }


}