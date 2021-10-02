val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

plugins {
    application
    kotlin("jvm") version "1.5.31"
    kotlin("plugin.serialization") version "1.5.31"
}

group = "com.alias111"
version = "0.0.1"
application {
    mainClass.set("com.alias111.ApplicationKt")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    implementation("io.ktor:ktor-gson:$ktor_version")
    // DATABASE ##########################################################
    implementation("mysql:mysql-connector-java:8.0.25")
    implementation("org.ktorm:ktorm-core:3.4.1")
    implementation ("org.ktorm:ktorm-support-mysql:3.4.1")
    // ########################################################## DATABASE
    implementation("io.ktor:ktor-serialization:$ktor_version")
    testImplementation("io.ktor:ktor-server-tests:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.5.31")
}