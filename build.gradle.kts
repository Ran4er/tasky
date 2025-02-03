
val ktor_version: String by project
val logback_version: String by project

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.ktor)
}

group = "com"
version = "0.0.1"

application {
    mainClass.set("io.ktor.server.netty.EngineMain")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {

    // Server dependencies (Ktor)
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.host.common)
    implementation(libs.ktor.server.metrics)
    implementation(libs.ktor.server.auth)
    implementation(libs.ktor.server.auth.jwt)
    implementation(libs.ktor.server.content.negotiation)
    implementation(libs.ktor.server.config.yaml)
    implementation("io.ktor:ktor-server-sessions")
    implementation(libs.ktor.server.netty)
    implementation("io.ktor:ktor-server-openapi:$ktor_version")
    implementation("io.ktor:ktor-server-swagger:$ktor_version")

    implementation("io.ktor:ktor-server-call-logging:$ktor_version")

    // serialization
    implementation(libs.ktor.serialization.jackson)
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310") // needed for multipart parsing
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jdk8") // needed for Optional<> parsing

    // Logging and test
    testImplementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation(libs.ktor.server.test.host)
    testImplementation(libs.kotlin.test.junit)
    testImplementation("io.mockk:mockk:1.13.16")

    implementation("com.zaxxer:HikariCP:6.2.1")
    implementation("org.flywaydb:flyway-core:11.3.0")
    implementation("at.favre.lib:bcrypt:0.10.2")

    // Exposed & PostgreSQL
    implementation("org.jetbrains.exposed:exposed-core:0.58.0")
    implementation("org.jetbrains.exposed:exposed-dao:0.58.0")
    runtimeOnly("org.jetbrains.exposed:exposed-jdbc:0.58.0")
    implementation("org.postgresql:postgresql:42.5.0")

    // Additional libraries
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core")
    runtimeOnly("org.jetbrains.kotlinx:kotlinx-datetime-jvm:0.6.1")


}
