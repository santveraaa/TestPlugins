import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

plugins {
    kotlin("android") // Ganti dengan kotlin android
    id("com.android.library") // Tambahkan plugin android library
}

version = "13"

repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
}

dependencies {
	implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation("org.jsoup:jsoup:1.17.1")
}

// Tambahkan konfigurasi Java plugin
configure<JavaPluginExtension> {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "17"
            freeCompilerArgs = listOf("-Xjsr305=strict")
        }
    }
}