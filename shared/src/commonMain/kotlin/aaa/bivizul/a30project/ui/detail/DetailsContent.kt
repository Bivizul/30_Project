package aaa.bivizul.a30project.ui.detail

import aaa.bivizul.a29project.ui.spbkwidget.Apostcp
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

    if (apostpopcryptList != null) {
        apostpopcryptList?.let { list ->
            list[model.selectedItemId].let { item ->
                Column {
                    Text(
                        text = item.aposttitle
                    )
                    Text(
                        text = item.apostdescription
                    )
                }
            }
        }
    } else {
        Apostcp()
    }
}