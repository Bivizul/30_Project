package aaa.bivizul.a30project.ui.apost

import aaa.bivizul.a30project.data.apoststore.ApostStore
import aaa.bivizul.a30project.data.apostutil.*
import aaa.bivizul.a30project.data.model.Apost
import aaa.bivizul.a30project.data.model.Getapost
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.StateFlow

class ItemApostComponent(
    componentContext: ComponentContext,
    context: Any,
    apostStore: ApostStore,
    private val onReplaceCur: () -> Unit
) : ItemApost, ComponentContext by componentContext {

    private val _models = MutableValue(ItemApost.Model(activity = context))
    override val models: Value<ItemApost.Model> = _models

    override val state: StateFlow<Getapost?> = apostStore.getapost

    init {
        try {
            apostStore.getGetapost(
                Apost(
                    getApostmm(),
                    getApostsim(context),
                    getApostid(context),
                    getApostl(),
                    getApostt()
                )
            )
        } catch (e: Exception) {
            getApostdlg(context)
        }
    }

    override fun onReplace() {
        onReplaceCur()
    }
}