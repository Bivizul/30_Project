package aaa.bivizul.a30project.ui.list

import aaa.bivizul.a30project.data.apoststore.ApostpopcryptStore
import aaa.bivizul.a30project.data.model.Apostpopcrypt
import androidx.compose.runtime.collectAsState
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ItemListComponent(
    componentContext: ComponentContext,
//    data : ApostApi,
    val data: ApostpopcryptStore,
    private val onItemSelected: (id: Int) -> Unit,
//    private val onClick: () -> Unit
) : ItemList, ComponentContext by componentContext {

    override val state: StateFlow<List<Apostpopcrypt>?> = data.apostpopcrypt

//    private val _models =
//        MutableValue(
//            ItemList.Model(
//                list = emptyList(),
//                selectedItemId = null
//            )
//        )
//
//    override val models: Value<ItemList.Model> = _models

//    override fun onClicked() {
//        onClick()
//    }

    override fun onItemClicked(id: Int) {
        onItemSelected(id)
    }

//    private fun Apostpopcrypt.toApostpopcrypt(): ItemList.ItemListApostpopcrypt =
//        ItemList.ItemListApostpopcrypt(
//            id = id,
//            aposttitle = aposttitle,
//            apostdescription = apostdescription
//        )

}