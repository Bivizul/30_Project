package aaa.bivizul.a30project.ui.root

import aaa.bivizul.a30project.data.apoststore.ApostStore
import aaa.bivizul.a30project.data.apoststore.ApostpopcryptStore
import aaa.bivizul.a30project.ui.apost.ItemApost
import aaa.bivizul.a30project.ui.apost.ItemApostComponent
import aaa.bivizul.a30project.ui.detail.ItemDetails
import aaa.bivizul.a30project.ui.detail.ItemDetailsComponent
import aaa.bivizul.a30project.ui.list.ItemList
import aaa.bivizul.a30project.ui.list.ItemListComponent
import aaa.bivizul.a30project.ui.main.ItemMain
import aaa.bivizul.a30project.ui.main.ItemMainComponent
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.*
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize

class RootComponent constructor(
    componentContext: ComponentContext,
    private val context: Any
) : Root, ComponentContext by componentContext {

    private val navigation = StackNavigation<Config>()
    val apostpopcryptStore = ApostpopcryptStore()
    val apostStore = ApostStore()

    private val stack =
        childStack(
            source = navigation,
            initialConfiguration = Config.Apost,
            handleBackButton = true,
            childFactory = ::createChild,
        )

    override val childStack: Value<ChildStack<*, Root.Child>> get() = stack

    private fun createChild(config: Config, componentContext: ComponentContext): Root.Child =
        when (config) {
            is Config.Apost -> Root.Child.ApostChild(itemApost(componentContext))
            is Config.Main -> Root.Child.MainChild(itemMain(componentContext))
            is Config.List -> Root.Child.ListChild(itemList(componentContext))
            is Config.Details -> Root.Child.DetailsChild(itemDetails(componentContext, config))
        }

    private fun itemApost(componentContext: ComponentContext): ItemApost =
        ItemApostComponent(
            componentContext = componentContext,
            context = context,
            apostStore = apostStore,
            onReplaceCur = {
                navigation.replaceCurrent(Config.Main)
            },
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
            apostpopcryptStore = apostpopcryptStore,
            onItemSelected = {
                navigation.push(Config.Details(itemId = it))
            }
        )

    private fun itemDetails(
        componentContext: ComponentContext,
        config: Config.Details
    ): ItemDetails =
        ItemDetailsComponent(
            componentContext = componentContext,
            data = apostpopcryptStore,
            itemId = config.itemId
        )

    private sealed class Config : Parcelable {
        @Parcelize
        object Apost : Config()

        @Parcelize
        object Main : Config()

        @Parcelize
        object List : Config()

        @Parcelize
        data class Details(val itemId: Int) : Config()
    }
}
