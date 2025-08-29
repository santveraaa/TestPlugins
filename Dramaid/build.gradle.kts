group = "com.example.dramaid"
version = "1.0.0"

repositories {
    mavenCentral()
    google()
    maven("https://jitpack.io")
}

dependencies {
    implementation(fileTree("libs") { include("*.jar") })
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.0")  // Ganti dengan versi yang stabil
}

// SOLUSI: Tambahkan JVM toolchain
kotlin {
    jvmToolchain(17)  // Tentukan JVM 17 untuk Kotlin
}

// Opsional: Konfigurasi tambahan
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "17"  // Tentukan JVM 17 untuk Kotlin
        freeCompilerArgs = listOf("-Xjsr305=strict")
    }
}

android {
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17  // Ganti dengan JVM 17
        targetCompatibility = JavaVersion.VERSION_17  // Ganti dengan JVM 17
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "17"  // Tentukan JVM 17 untuk Kotlin
            freeCompilerArgs = listOf("-Xjsr305=strict")
        }
    }
}
