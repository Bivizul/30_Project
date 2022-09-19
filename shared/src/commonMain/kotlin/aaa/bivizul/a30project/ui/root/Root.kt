package aaa.bivizul.a30project.ui.root

import aaa.bivizul.a30project.ui.apost.ItemApost
import aaa.bivizul.a30project.ui.detail.ItemDetails
import aaa.bivizul.a30project.ui.list.ItemList
import aaa.bivizul.a30project.ui.main.ItemMain
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value

interface Root {

    val childStack: Value<ChildStack<*, Child>>

    sealed class Child {
        class ApostChild(val component: ItemApost) : Child()
        class MainChild(val component: ItemMain) : Child()
        class ListChild(val component: ItemList) : Child()
        class DetailsChild(val component: ItemDetails) : Child()
    }
}