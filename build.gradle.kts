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

    //Decompose
    implementation("com.arkivanov.decompose:decompose:$decomposeVersion")
    // Decompose Extension
    implementation("com.arkivanov.decompose:extensions-compose-jetbrains:$decomposeVersion")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
    kotlinOptions.freeCompilerArgs += "-Xuse-experimental=androidx.compose.foundation.ExperimentalFoundationApi"
    kotlinOptions.freeCompilerArgs += "-Xuse-experimental=androidx.compose.ui.ExperimentalComposeUiApi"
    kotlinOptions.freeCompilerArgs += "-Xuse-experimental=kotlin.io.path.ExperimentalPathApi"
}

compose.desktop {
    application {
        mainClass = "dev.spikeysanju.jetquotes.view.MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "JetQuotes"
            packageVersion = "1.0.0"
//            description = "A Quotes Application built to Demonstrate the Compose for Desktop UI"
//            copyright = "© 2021 Spikey Sanju. All rights reserved."
//            vendor = "Spikey Sanju"

            val iconsRoot = project.file("src/main/resources/drawable")

            linux {
                iconFile.set(iconsRoot.resolve("launchericons/ic_jetquotes.png"))
            }

            windows {
                iconFile.set(iconsRoot.resolve("launchericons/ic_jetquotes.ico"))
                upgradeUuid = "7c4b7fa1-6b40-4de6-86b5-53972976f6b7"
                menuGroup = packageName
                perUserInstall = true
            }

            macOS {
                iconFile.set(iconsRoot.resolve("launchericons/ic_jetquotes.icns"))
            }
        }
    }
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = JavaVersion.VERSION_11.toString()
}