plugins {
    `java-library`
    `maven-publish`
}

version = "13"

repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
}

dependencies {
	implementation(kotlin("stdlib"))
    implementation("com.lagradost:cloudstream3-core:3.6.5")
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