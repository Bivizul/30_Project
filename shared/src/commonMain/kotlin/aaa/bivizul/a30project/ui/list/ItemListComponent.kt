package aaa.bivizul.a30project.ui.list

import com.arkivanov.decompose.ComponentContext

interface ItemList {

    fun onClicked()

}

class ItemListComponent(
    componentContext: ComponentContext,
    private val onClick: () -> Unit
) : ItemList, ComponentContext by componentContext {

    override fun onClicked() {
        onClick()
    }

}