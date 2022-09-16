import Deps.Versions.kotlin

object Deps {

    object Versions {
        const val compileSdk = 33
        const val minSdk = 24
        const val targetSdk = compileSdk

        const val kotlin = "1.7.10"
        const val agp = "7.2.2"
        const val jetbrains_compose = "1.2.0-alpha01-dev753"
        const val compose_compiler = "1.2.0"
        const val onesignal = "0.14.0"
    }

    object JetBrains {
        object Kotlin {
            private val VERSION get() = kotlin
            val gradlePlugin get() = "org.jetbrains.kotlin:kotlin-gradle-plugin:$VERSION"
            val testCommon get() = "org.jetbrains.kotlin:kotlin-test-common:$VERSION"
            val testJunit get() = "org.jetbrains.kotlin:kotlin-test-junit:$VERSION"
            val testJs get() = "org.jetbrains.kotlin:kotlin-test-js:$VERSION"
            val testAnnotationsCommon get() = "org.jetbrains.kotlin:kotlin-test-annotations-common:$VERSION"
        }

        object Serialization {
            private val VERSION get() = "1.4.0"
            val serializationJson get() = "org.jetbrains.kotlinx:kotlinx-serialization-json:$VERSION"
        }

        object KotlinCoroutines {
            private val VERSION get() = "1.6.4"
            val android get() = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$VERSION"
            val core get() = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$VERSION"
        }

        object Compose {
            private val VERSION get() = "1.2.1"
            val gradlePlugin get() = "org.jetbrains.compose:compose-gradle-plugin:$VERSION"
            val materialDesign get()= "androidx.compose.material:material:$VERSION"
        }

    }

    object Android {
        object Tools {
            object Build {
                const val gradlePlugin = "com.android.tools.build:gradle:7.2.2"
            }
        }


    }

    object AndroidX {

        const val appCompat = "androidx.appcompat:appcompat:1.5.1"
        const val core_ktx = "androidx.core:core-ktx:1.8.0"
        const val activityCompose = "androidx.activity:activity-compose:1.5.1"


    }

    object ArkIvanov {
        object MVIKotlin {
            private const val VERSION = "3.0.0-beta01"
            const val rx = "com.arkivanov.mvikotlin:rx:$VERSION"
            const val mvikotlin = "com.arkivanov.mvikotlin:mvikotlin:$VERSION"
            const val mvikotlinMain = "com.arkivanov.mvikotlin:mvikotlin-main:$VERSION"
            const val mvikotlinLogging = "com.arkivanov.mvikotlin:mvikotlin-logging:$VERSION"
            const val mvikotlinTimeTravel = "com.arkivanov.mvikotlin:mvikotlin-timetravel:$VERSION"
            const val mvikotlinExtensionsReaktive =
                "com.arkivanov.mvikotlin:mvikotlin-extensions-reaktive:$VERSION"
        }

        object Decompose {
//                        private const val VERSION = "0.5.1"
//                        private const val VERSION = "0.8.0"
                        private const val VERSION = "1.0.0-alpha-04-native-compose"
//            private const val VERSION = "1.0.0-alpha-04"
            const val decompose = "com.arkivanov.decompose:decompose:$VERSION"
            const val extensionsComposeJetbrains = "com.arkivanov.decompose:extensions-compose-jetbrains:$VERSION"
            const val extensionsComposeJetpack = "com.arkivanov.decompose:extensions-compose-jetpack:$VERSION"
            const val extensionsAndroid = "com.arkivanov.decompose:extensions-android:$VERSION"
        }

        object Essenty {
            private const val VERSION = "0.5.2"
            const val lifecycle = "com.arkivanov.essenty:lifecycle:$VERSION"
            const val stateKeeper = "com.arkivanov.essenty:state-keeper:$VERSION"
            const val instanceKeeper = "com.arkivanov.essenty:instance-keeper:$VERSION"
            const val backHandler = "com.arkivanov.essenty:back-handler:$VERSION"
        }
    }

    object Badoo {
        object Reaktive {
            private const val VERSION = "1.2.1"
            const val reaktive = "com.badoo.reaktive:reaktive:$VERSION"
            const val reaktiveTesting = "com.badoo.reaktive:reaktive-testing:$VERSION"
            const val utils = "com.badoo.reaktive:utils:$VERSION"
            const val coroutinesInterop = "com.badoo.reaktive:coroutines-interop:$VERSION"
        }
    }

    object Squareup {
        object SQLDelight {
            private const val VERSION = "1.5.3"
            const val gradlePlugin = "com.squareup.sqldelight:gradle-plugin:$VERSION"
            const val androidDriver = "com.squareup.sqldelight:android-driver:$VERSION"
            const val sqliteDriver = "com.squareup.sqldelight:sqlite-driver:$VERSION"
            const val nativeDriver = "com.squareup.sqldelight:native-driver:$VERSION"
            const val sqljsDriver = "com.squareup.sqldelight:sqljs-driver:$VERSION"
        }
    }

    object Kmp {
        object Ktor {
            private const val VERSION = "2.1.0"
            const val core = "io.ktor:ktor-client-core:$VERSION"
            const val logging = "io.ktor:ktor-client-logging:$VERSION"
            const val cio = "io.ktor:ktor-client-cio:$VERSION"
            const val negotiation = "io.ktor:ktor-client-content-negotiation:$VERSION"
            const val json = "io.ktor:ktor-serialization-kotlinx-json:$VERSION"
        }

        object Util {
            //            const val settings = "com.russhwolf:multiplatform-settings:${Version.settings_version}"
            const val onesignal = "com.onesignal:OneSignal:4.8.2"
            const val landscapist = "com.github.skydoves:landscapist-coil:2.0.0"
        }
    }
}