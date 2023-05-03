plugins {
    kotlin("jvm") version "1.8.0"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.8.0"
    id("org.jetbrains.kotlinx.benchmark") version "0.4.7"
    kotlin("plugin.serialization") version "1.8.0"
}

group = "dev.bachemedei"
version = "1.0-SNAPSHOT"

allOpen {
    annotation("org.openjdk.jmh.annotations.State")
}

benchmark {
    targets {
        register("main")
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlinx:kotlinx-benchmark-runtime:0.4.7")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.3.3")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.3")
}
