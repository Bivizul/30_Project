package aaa.bivizul.a30project.ui.list

import aaa.bivizul.a29project.ui.spbkwidget.Apostcp
import aaa.bivizul.a30project.ui.apostwidget.Apostbtn
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ListContent(
    component: ItemList,
    modifier: Modifier = Modifier
) {

    val apostpopcryptList by component.state.collectAsState()

    if (apostpopcryptList != null) {
        apostpopcryptList?.let { list ->

            LazyColumn(
                modifier = modifier.padding(8.dp).fillMaxSize(),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.End
            ) {
                items(list) { apostpopcrypt ->
                    Apostbtn(
                        onClick = { component.onItemClicked(id = apostpopcrypt.id) },
                        text = apostpopcrypt.aposttitle
                    )
                }
            }
        }

    } else {
        Apostcp()
    }
}