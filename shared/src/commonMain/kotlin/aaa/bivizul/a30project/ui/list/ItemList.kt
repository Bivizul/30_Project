package aaa.bivizul.a30project.ui.list

import aaa.bivizul.a30project.data.model.Apostpopcrypt
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.StateFlow

interface ItemList {

//    val models: Value<Model>

//    fun onClicked()

    val state : StateFlow<List<Apostpopcrypt>?>

    fun onItemClicked(id: Int)

    data class Model(
        val list: List<Apostpopcrypt>,
        val selectedItemId: Int?
    )

//    data class Model(
//        val list: List<ItemListApostpopcrypt>,
//        val selectedItemId: Int?
//    )

//    data class ItemListApostpopcrypt(
//        val id: Int,
//        val aposttitle: String,
//        val apostdescription: String,
//    )

}