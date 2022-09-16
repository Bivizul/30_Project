package aaa.bivizul.a30project.ui.detail

import aaa.bivizul.a30project.data.model.Apostpopcrypt
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.StateFlow

interface ItemDetails {

    val models: Value<Model>

    val state: StateFlow<List<Apostpopcrypt>?>

    data class Model(
        val selectedItemId: Int
    )

}