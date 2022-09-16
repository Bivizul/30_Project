package aaa.bivizul.a30project.ui.Root

import aaa.bivizul.a30project.ui.detail.ItemDetails
import aaa.bivizul.a30project.ui.detail.ItemDetailsComponent
import aaa.bivizul.a30project.ui.list.ItemList
import aaa.bivizul.a30project.ui.list.ItemListComponent
import aaa.bivizul.a30project.ui.main.ItemMain
import aaa.bivizul.a30project.ui.main.ItemMainComponent
import aaa.bivizul.a30project.ui.splash.ItemSplash
import aaa.bivizul.a30project.ui.splash.ItemSplashComponent
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.*
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize

interface Root {

    val childStack: Value<ChildStack<*, Child>>

    sealed class Child {
        class SplashChild(val component: ItemSplash) : Child()
        class MainChild(val component: ItemMain) : Child()
        class ListChild(val component: ItemList) : Child()
        class DetailsChild(val component: ItemDetails) : Child()
    }
}

class RootComponent constructor(
    componentContext: ComponentContext,
) : Root, ComponentContext by componentContext {

    private val navigation = StackNavigation<Config>()

    private val stack =
        childStack(
            source = navigation,
            initialConfiguration = Config.Splash,
            handleBackButton = true, // Pop the back stack on back button press
            childFactory = ::createChild,
        )

    override val childStack: Value<ChildStack<*, Root.Child>> get() = stack

    private fun createChild(config: Config, componentContext: ComponentContext): Root.Child =
        when (config) {
            is Config.Splash -> Root.Child.SplashChild(itemSplash(componentContext))
            is Config.Main -> Root.Child.MainChild(itemMain(componentContext))
            is Config.List -> Root.Child.ListChild(itemList(componentContext))
            is Config.Details -> Root.Child.DetailsChild(itemDetails(componentContext))


        }

    private fun itemSplash(componentContext: ComponentContext): ItemSplash =
        ItemSplashComponent(
            componentContext = componentContext,
            onClick = {
                navigation.push(Config.Main)
            }
        )

    private fun itemMain(componentContext: ComponentContext): ItemMain =
        ItemMainComponent(
            componentContext = componentContext,
            onClick = {
                navigation.push(Config.List)
            }
        )

    private fun itemList(componentContext: ComponentContext): ItemList =
        ItemListComponent(
            componentContext = componentContext,
            onClick = {
                navigation.push(Config.Details)
            }
        )

    private fun itemDetails(componentContext: ComponentContext): ItemDetails =
        ItemDetailsComponent(
            componentContext = componentContext
        )

    private sealed class Config : Parcelable {
        @Parcelize
        object Splash : Config()

        @Parcelize
        object Main : Config()

        @Parcelize
        object List : Config()

        @Parcelize
        object Details : Config()
    }
}
