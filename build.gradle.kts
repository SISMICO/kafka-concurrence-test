import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
}

group = "br.com.sismico"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val kafka_clients = "3.2.1"

dependencies {
    implementation("org.apache.kafka:kafka-clients:$kafka_clients")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
