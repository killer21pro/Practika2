plugins {
    kotlin("jvm") version "1.9.25"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    
    // JAXB API (для Java 9+)
    implementation("javax.xml.bind:jaxb-api:2.3.1")
    
    // JAXB Implementation
    implementation("org.glassfish.jaxb:jaxb-runtime:2.3.1")
    
    // Для активации JAXB
    implementation("javax.activation:activation:1.1.1")
}

application {
    mainClass.set("MainKt")
    applicationDefaultJvmArgs = listOf("-Dfile.encoding=UTF-8")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "20"
}

java {
    sourceCompatibility = JavaVersion.VERSION_20
    targetCompatibility = JavaVersion.VERSION_20
}

