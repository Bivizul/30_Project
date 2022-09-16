package aaa.bivizul.a30project.ui.main

import com.arkivanov.decompose.ComponentContext

interface ItemMain {

    fun onClicked()

}

class ItemMainComponent(
    componentContext: ComponentContext,
    private val onClick: () -> Unit
) : ItemMain, ComponentContext by componentContext {

    override fun onClicked() {
        onClick()
    }
}