package aaa.bivizul.a30project.ui.main

import aaa.bivizul.a30project.data.apostutil.Apostcon.APOSTARROW
import aaa.bivizul.a30project.data.apostutil.Apostcon.APOSTNA
import aaa.bivizul.a30project.data.apostutil.Apostcon.APOSTTEXT
import aaa.bivizul.a30project.ui.apostwidget.Apostbtn
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun MainContent(
    component: ItemMain,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier.padding(8.dp).fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = APOSTNA,
            style = MaterialTheme.typography.h3,
            textAlign = TextAlign.Center
        )
        Text(
            text = APOSTTEXT,
            style = MaterialTheme.typography.h6,
            textAlign = TextAlign.Center
        )
        Apostbtn(
            onClick = { component.onClicked() },
            text = APOSTARROW
        )
    }

}