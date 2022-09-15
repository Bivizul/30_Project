package aaa.bivizul.a30project

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform