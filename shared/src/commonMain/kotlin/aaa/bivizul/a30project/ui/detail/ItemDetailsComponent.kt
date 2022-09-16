package aaa.bivizul.a30project.ui.detail

import aaa.bivizul.a30project.data.apoststore.ApostpopcryptStore
import aaa.bivizul.a30project.data.model.Apostpopcrypt
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.StateFlow

class ItemDetailsComponent(
    componentContext: ComponentContext,
    val data: ApostpopcryptStore,
    itemId: Int,
) : ItemDetails, ComponentContext by componentContext {

    override val state: StateFlow<List<Apostpopcrypt>?> = data.apostpopcrypt

    private val _models = MutableValue(ItemDetails.Model(itemId))
    override val models: Value<ItemDetails.Model> = _models


    init {
        println("ItemDetailsComponent id : $itemId")
    }

//    override val models: Value<ItemDetails.Model>
//        get() = TODO("Not yet implemented")

}