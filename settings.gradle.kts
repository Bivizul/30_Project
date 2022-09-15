pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }

    plugins {

        val kotlinVersion = extra["kotlin.version"] as String
        val agpVersion = extra["agp.version"] as String
        val jetbrainsComposeVersion = extra["compose.version"] as String
        val onesignalVersion = extra["onesignal.version"] as String

        id("com.android.application").version(agpVersion)
        id("com.android.library").version(agpVersion)
        id("org.jetbrains.compose").version(jetbrainsComposeVersion)
        id("com.onesignal.androidsdk.onesignal-gradle-plugin").version(onesignalVersion)
        kotlin("android").version(kotlinVersion)
        kotlin("multiplatform").version(kotlinVersion)
        kotlin("jvm").version(kotlinVersion)
        kotlin("plugin.serialization").version(kotlinVersion)
    }

}

rootProject.name = "30_Project"
include(":androidApp")
include(":shared")