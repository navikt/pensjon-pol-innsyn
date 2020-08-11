import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "no.nav.pensjon"
version = "2"
description = "pensjon-pol-innsyn"

plugins {
    kotlin("jvm") version "1.3.72"
    kotlin("plugin.spring") version "1.3.72"
    id("org.springframework.boot") version "2.2.7.RELEASE"
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
}

repositories {

    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))
    implementation("no.nav.security","token-validation-spring", "1.2.0")
    implementation ("org.apache.poi", "poi","4.1.0")
    implementation ("org.apache.poi","poi-ooxml","4.1.0")
    implementation ("org.springframework.boot","spring-boot-starter-web")
    implementation("org.springframework.boot","spring-boot-starter-jdbc")
    implementation("org.springframework.boot","spring-boot-starter-data-jpa")
    implementation ("com.oracle.ojdbc","ojdbc8","19.3.0.0")
    implementation ("com.zaxxer","HikariCP","3.3.1")
    testImplementation("org.springframework.boot","spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
    testImplementation ("org.testcontainers","junit-jupiter","1.11.4")
    testImplementation ("org.testcontainers","oracle-xe","1.13.0")
    testImplementation ("org.mockito","mockito-junit-jupiter","2.28.2")
    testImplementation ("org.postgresql","postgresql","42.2.5")
    testImplementation ("org.testcontainers","postgresql","1.11.4")
    implementation(kotlin("stdlib"))
}

java {
    sourceCompatibility = JavaVersion.VERSION_13
    targetCompatibility = JavaVersion.VERSION_13
}

tasks{
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "13"
    }
    test{
        useJUnitPlatform()
    }
}
