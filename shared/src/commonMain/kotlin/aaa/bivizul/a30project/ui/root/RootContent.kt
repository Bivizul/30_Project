package aaa.bivizul.a30project.ui.root

import aaa.bivizul.a30project.ui.detail.DetailsContent
import aaa.bivizul.a30project.ui.list.ListContent
import aaa.bivizul.a30project.ui.main.MainContent
import aaa.bivizul.a30project.ui.apost.ApostContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState

@Composable
fun RootContent(root: Root, modifier: Modifier = Modifier) {

    val childStack by root.childStack.subscribeAsState()
    val activeComponent = childStack.active.instance

    Children(
        stack = childStack,
        modifier = Modifier,
    ) {
        when (val child = it.instance) {
            is Root.Child.SplashChild -> ApostContent(component = child.component)
            is Root.Child.MainChild -> MainContent(component = child.component)
            is Root.Child.ListChild -> ListContent(component = child.component)
            is Root.Child.DetailsChild -> DetailsContent(component = child.component)
        }

    }

}

