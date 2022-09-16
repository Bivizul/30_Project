package aaa.bivizul.a30project.ui.main

import com.arkivanov.decompose.ComponentContext

class ItemMainComponent(
    componentContext: ComponentContext,
    private val onClick: () -> Unit
) : ItemMain, ComponentContext by componentContext {

    override fun onClicked() {
        onClick()
    }
}