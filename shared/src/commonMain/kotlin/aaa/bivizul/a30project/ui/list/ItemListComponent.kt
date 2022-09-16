package aaa.bivizul.a30project.ui.list

import aaa.bivizul.a30project.data.apoststore.ApostpopcryptStore
import aaa.bivizul.a30project.data.model.Apostpopcrypt
import androidx.compose.runtime.collectAsState
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

interface ItemList {

    val models: Value<Model>

    fun onClicked()

    fun onItemClicked(id: Int)

//    data class Model(
//        val list: List<ItemListApostpopcrypt>,
//        val selectedItemId: Int?
//    )

//    data class Model(
//        val list: List<Apostpopcrypt>,
//        val selectedItemId: Int?
//    )

    data class Model(
        val list : Flow<List<Apostpopcrypt>?>
    )

    data class ItemListApostpopcrypt(
        val id: Int,
        val aposttitle: String,
        val apostdescription: String,
    )

}

class ItemListComponent(
    componentContext: ComponentContext,
//    data : ApostApi,
    val data: ApostpopcryptStore,
    private val onItemSelected: (id: Int) -> Unit,
    private val onClick: () -> Unit
) : ItemList, ComponentContext by componentContext {

    private val _models =
        MutableValue(
            ItemList.Model(
                list = data.apostpopcrypt,
//                selectedItemId = null
            )
        )

//    private val _models =
//        MutableValue(
//            ItemList.Model(
//                list = data.apostpopcrypt.collectAsState().value!!,
//                selectedItemId = null
//            )
//        )

//    val a = {
//        CoroutineScope(Dispatchers.Default).launch {
//            data.getApostpopcrypt()
//        }
//    }

    override val models: Value<ItemList.Model> = _models

    override fun onClicked() {
        onClick()
    }

    override fun onItemClicked(id: Int) {
        onItemSelected(id)
    }

    private fun Apostpopcrypt.toApostpopcrypt(): ItemList.ItemListApostpopcrypt =
        ItemList.ItemListApostpopcrypt(
            id = id,
            aposttitle = aposttitle,
            apostdescription = apostdescription
        )

}