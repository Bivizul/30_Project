package aaa.bivizul.a30project.ui.apost

import com.arkivanov.decompose.ComponentContext

class ItemApostComponent(
    componentContext: ComponentContext,
    private val onClick: () -> Unit
) : ItemApost, ComponentContext by componentContext {

    override fun onClicked() {
        onClick()
    }
}