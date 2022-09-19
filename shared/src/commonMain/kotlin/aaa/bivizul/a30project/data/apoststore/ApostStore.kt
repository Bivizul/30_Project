package aaa.bivizul.a30project.data.apoststore

import aaa.bivizul.a30project.data.apostnet.ApostApi
import aaa.bivizul.a30project.data.apostutil.ioDispatcher
import aaa.bivizul.a30project.data.model.Apost
import aaa.bivizul.a30project.data.model.Getapost
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ApostStore {

    private val spbkApi = ApostApi()

    val job = SupervisorJob()
    val scope = CoroutineScope(ioDispatcher + job)

    private val _getapost = MutableStateFlow<Getapost?>(null)
    val getapost: StateFlow<Getapost?> = _getapost.asStateFlow()

    fun getGetapost(apost: Apost) {
        scope.launch {
            val response = spbkApi.getGetapost(apost)
            _getapost.emit(response)
        }
    }

}