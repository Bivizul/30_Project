package aaa.bivizul.a30project.ui.list

import aaa.bivizul.a30project.data.model.Apostpopcrypt
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.StateFlow

interface ItemList {

    val state : StateFlow<List<Apostpopcrypt>?>

    fun onItemClicked(id: Int)

}