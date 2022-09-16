package aaa.bivizul.a30project.ui.splash

import com.arkivanov.decompose.ComponentContext

interface ItemSplash {

    fun onClicked()

}

class ItemSplashComponent(
    componentContext: ComponentContext,
    private val onClick: () -> Unit
) : ItemSplash, ComponentContext by componentContext {

    override fun onClicked() {
        onClick()
    }
}