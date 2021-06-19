import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.10"
    id("org.jetbrains.compose") version "0.4.0"
    kotlin("plugin.serialization") version "1.5.10"
    kotlin("kapt") version "1.5.10"
}

group = "me.spikeysanju"
version = "1.0"

repositories {
    google()
    mavenCentral()
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/compose/dev") }
}

val daggerVersion by extra("2.36")
val decomposeVersion by extra("0.2.6")


dependencies {
    implementation(compose.desktop.currentOs)
    // Kotlin Serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.1")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.3")
    testImplementation(compose("org.jetbrains.compose.ui:ui-test-junit4"))

    // Dagger : A fast dependency injector for Android and Java.
    api("com.google.dagger:dagger:$daggerVersion")
    kapt("com.google.dagger:dagger-compiler:$daggerVersion")
    kapt("com.google.dagger:dagger:$daggerVersion")
    kaptTest("com.google.dagger:dagger-compiler:$daggerVersion")

    //Decompose
    implementation("com.arkivanov.decompose:decompose:$decomposeVersion")
    // Decompose Extension
    implementation("com.arkivanov.decompose:extensions-compose-jetbrains:$decomposeVersion")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "15"
}

compose.desktop {
    application {
        mainClass = "dev.spikeysanju.jetquotes.view.MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "JetQuotes"
            packageVersion = "1.0.0"
        }
    }
}