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
    implementation("com.lagradost:cloudstream3-core:+")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation("org.jsoup:jsoup:1.17.1")
}

// Tambahkan konfigurasi Java plugin
configure<JavaPluginExtension> {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks {
    val jar by getting(Jar::class) {
        archiveFileName.set("Dramaid-v${project.version}.cs3")
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
        from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
    }
    
    compileKotlin {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
}