plugins {
    kotlin("jvm") version "1.9.0"
}

group = "com.example.dramaid"
version = "1.0.0"

repositories {
    mavenCentral()
    google()
    maven("https://jitpack.io")
}

dependencies {
    implementation(fileTree("libs") { include("*.jar") })
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.0")
}

// SOLUSI: Tambahkan JVM toolchain
kotlin {
    jvmToolchain(17)
}

// Opsional: Konfigurasi tambahan
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "17"
        freeCompilerArgs = listOf("-Xjsr305=strict")
    }
}