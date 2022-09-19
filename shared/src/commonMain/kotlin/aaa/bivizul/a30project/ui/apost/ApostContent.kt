package aaa.bivizul.a30project.ui.apost

import aaa.bivizul.a29project.ui.spbkwidget.Apostcp
import aaa.bivizul.a30project.data.apostutil.getApostact
import aaa.bivizul.a30project.data.apostutil.sigApostoff
import aaa.bivizul.a30project.data.model.Apostvar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import kotlinx.coroutines.delay

@Composable
fun ApostContent(
    component: ItemApost,
    modifier: Modifier = Modifier
) {

    val getapost by component.state.collectAsState()
    val model by component.models.subscribeAsState()

    Apostcp()

    LaunchedEffect(Unit) {
        delay(1000)
        getapost?.getapost?.let {
            if (it == Apostvar.AVNO.av) {
                component.onReplace()
            } else if (it == Apostvar.AVNP.av) {
                sigApostoff()
                component.onReplace()
            } else {
                getApostact(model.activity, it)
            }
        }
    }
}