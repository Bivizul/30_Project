package aaa.bivizul.a30project.data.apoststore

import aaa.bivizul.a30project.data.apostnet.ApostApi
import aaa.bivizul.a30project.data.apostutil.ioDispatcher
import aaa.bivizul.a30project.data.apostutil.uiDispatcher
import aaa.bivizul.a30project.data.model.Apostpopcrypt
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ApostpopcryptStore {

    private val spbkApi = ApostApi()

    //
    val job = SupervisorJob()
    val scope = CoroutineScope(ioDispatcher + job)

    private val _apostpopcrypt = MutableStateFlow<List<Apostpopcrypt>?>(null)
    val apostpopcrypt: StateFlow<List<Apostpopcrypt>?> = _apostpopcrypt.asStateFlow()

//    init {
//        getSportsbook()
//    }

    init {

    }

    fun getApostpopcrypt() {
        scope.launch {
            val response = spbkApi.getApostpopcrypt()
            _apostpopcrypt.emit(response)
        }
    }

//    fun getApostpopcrypt() : List<Apostpopcrypt> {
//        var list = emptyList<Apostpopcrypt>()
//        scope.launch {
//            val response = spbkApi.getApostpopcrypt()
//            list = response
//
//        }
//        println(" list : $list")
//        return list
//    }

//    suspend fun getApostpopcrypt() : List<Apostpopcrypt> = spbkApi.getApostpopcrypt()



}