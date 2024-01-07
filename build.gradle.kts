plugins {
    kotlin("jvm") version "1.9.20"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.9.20"
    id("org.jetbrains.kotlinx.benchmark") version "0.4.10"
    kotlin("plugin.serialization") version "1.9.20"
}

tasks.test {
    useJUnitPlatform()
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
    implementation("org.jetbrains.kotlinx:kotlinx-benchmark-runtime:0.4.10")
    implementation(group = "org.jetbrains.kotlinx", name = "kotlinx-serialization-json", version = "1.6.2" )

    testImplementation(kotlin("test"))
    testImplementation(group = "org.junit.jupiter", name = "junit-jupiter-params", version = "5.5.2")
}