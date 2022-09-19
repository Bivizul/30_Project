package aaa.bivizul.a30project.ui.list

import aaa.bivizul.a30project.data.model.Apostpopcrypt
import kotlinx.coroutines.flow.StateFlow

interface ItemList {

    val state: StateFlow<List<Apostpopcrypt>?>

    fun onItemClicked(id: Int)

}