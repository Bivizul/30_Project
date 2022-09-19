package aaa.bivizul.a30project.ui.list

import aaa.bivizul.a30project.data.apoststore.ApostpopcryptStore
import aaa.bivizul.a30project.data.model.Apostpopcrypt
import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.StateFlow

class ItemListComponent(
    componentContext: ComponentContext,
    apostpopcryptStore: ApostpopcryptStore,
    private val onItemSelected: (id: Int) -> Unit,
) : ItemList, ComponentContext by componentContext {

    override val state: StateFlow<List<Apostpopcrypt>?> = apostpopcryptStore.apostpopcrypt

    override fun onItemClicked(id: Int) {
        onItemSelected(id)
    }

}