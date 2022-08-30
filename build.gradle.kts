plugins {
    kotlin("jvm") version "1.7.10"
}

group = "dev.bcmedeiros"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))

    implementation("io.ktor:ktor-client-core:2.1.0")
    implementation("io.ktor:ktor-client-java:2.1.0")
}