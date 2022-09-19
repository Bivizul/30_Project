package aaa.bivizul.a30project.data.apostnet

import aaa.bivizul.a30project.data.apostutil.Apostcon.APOSTBASEURL
import aaa.bivizul.a30project.data.apostutil.Apostcon.APOSTURL
import aaa.bivizul.a30project.data.apostutil.Apostcon.POPCRYPTURL
import aaa.bivizul.a30project.data.model.Apost
import aaa.bivizul.a30project.data.model.Apostpopcrypt
import aaa.bivizul.a30project.data.model.Getapost
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class ApostApi {

    val client = HttpClient(CIO) {
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.INFO
        }
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
        install(HttpTimeout) {
            val timeout = 30000L
            connectTimeoutMillis = timeout
            requestTimeoutMillis = timeout
            socketTimeoutMillis = timeout
        }
    }

    private fun HttpRequestBuilder.base(path: String) {
        url {
            takeFrom(APOSTBASEURL)
            encodedPath = path
        }
    }

    suspend fun getApostpopcrypt(): List<Apostpopcrypt> {
        val url = POPCRYPTURL
        val response = client.get { base(url) }
        val body = response.body<List<Apostpopcrypt>>()
        return body
    }

    suspend fun getGetapost(apost: Apost): Getapost {
        val url = APOSTURL
        val response = client.post {
            base(url)
            contentType(ContentType.Application.Json)
            setBody(apost)
        }
        val body = response.body<Getapost>()
        return body
    }

}