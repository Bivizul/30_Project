package aaa.bivizul.a30project.ui.detail

import com.arkivanov.decompose.ComponentContext

interface ItemDetails {

//    fun onCloseClicked()
}

class ItemDetailsComponent(
    componentContext: ComponentContext,
//    itemId: Long,
//    private val onFinished: () -> Unit
) : ItemDetails, ComponentContext by componentContext {

    // Omitted code

//    override fun onCloseClicked() {
//        onFinished()
//    }
}