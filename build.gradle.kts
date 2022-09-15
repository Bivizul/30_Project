plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.application").apply(false)
    id("com.android.library").apply(false)
    id("org.jetbrains.compose").apply(false)
    id("com.onesignal.androidsdk.onesignal-gradle-plugin").apply(false)
    kotlin("android").apply(false)
    kotlin("multiplatform").apply(false)
    kotlin("jvm").apply(false)
    kotlin("plugin.serialization").apply(false)
}

subprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
