import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "no.nav.pensjon"
version = "2"
description = "pensjon-pol-innsyn"

plugins {
    kotlin("jvm") version "1.4.0"
    kotlin("plugin.spring") version "1.4.0"
    kotlin("plugin.noarg") version "1.4.0"
    id("org.springframework.boot") version "2.3.3.RELEASE"
    id("io.spring.dependency-management") version "1.0.10.RELEASE"
}

repositories {

    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))
    implementation("io.micrometer","micrometer-registry-prometheus","1.5.4")
    implementation("net.logstash.logback","logstash-logback-encoder","6.4")
    implementation("no.nav.security","token-validation-spring", "1.3.0")
    implementation("org.apache.poi","poi-ooxml","4.1.2")
    implementation("org.springframework.boot","spring-boot-starter-actuator")
    implementation("org.springframework.boot","spring-boot-starter-web")
    implementation("org.springframework.boot","spring-boot-starter-jdbc")
    implementation("org.springframework.boot","spring-boot-starter-data-jpa")
    testImplementation(kotlin("test-junit5"))
    testImplementation("no.nav.security","token-validation-test-support", "1.3.0")
    testImplementation("org.springframework.boot","spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
    testImplementation ("org.mockito","mockito-junit-jupiter","3.5.2")
    testRuntimeOnly("com.h2database","h2","1.4.200")
}

noArg {
    annotation("javax.persistence.Entity")
}

tasks{
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "13"
    }
    test{
        useJUnitPlatform()
    }
}
