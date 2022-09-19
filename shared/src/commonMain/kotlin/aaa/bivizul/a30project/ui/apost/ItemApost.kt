package aaa.bivizul.a30project.ui.apost

import aaa.bivizul.a30project.data.model.Getapost
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.StateFlow

interface ItemApost {

    val models: Value<Model>
    val state: StateFlow<Getapost?>

    fun onReplace()

    data class Model(
        val activity: Any
    )

}