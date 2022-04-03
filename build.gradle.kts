import org.jetbrains.kotlin.ir.backend.js.compile

val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val serialization_version: String by project
val kotlinx_datetime_version: String by project

plugins {
    application
    kotlin("jvm") version "1.6.10" //TODO use variable kotlin_version if possible
    kotlin("plugin.serialization") version "1.6.10"
}

group = "com.andigeeky.tripmate"
version = "0.0.1"
application {
    mainClass.set("com.andigeeky.tripmate.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/ktor/eap") }
}

dependencies {
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation("io.ktor:ktor-server-content-negotiation:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")

    testImplementation("io.ktor:ktor-server-test-host:$ktor_version")
    testImplementation("io.ktor:ktor-server-tests:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}