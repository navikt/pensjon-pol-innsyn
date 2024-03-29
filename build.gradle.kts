import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "no.nav.pensjon"
version = "1"

plugins {
    kotlin("jvm") version "1.9.10"
    kotlin("plugin.noarg") version "1.9.10"
    kotlin("plugin.spring") version "1.9.10"
    id("org.springframework.boot") version "2.7.15"
    id("io.spring.dependency-management") version "1.1.3"
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("reflect"))
    implementation("com.oracle.database.jdbc", "ojdbc10", "19.7.0.0")
    implementation("io.micrometer", "micrometer-registry-prometheus", "1.5.5")
    implementation("net.logstash.logback", "logstash-logback-encoder", "6.4")
    implementation("no.nav.security", "token-validation-spring", "1.3.0")
    implementation("org.apache.poi", "poi-ooxml", "4.1.2")
    implementation("org.springframework.boot", "spring-boot-starter-web")
    implementation("org.springframework.boot", "spring-boot-starter-jdbc")
    implementation("org.springframework.boot", "spring-boot-starter-data-jpa")
    implementation("org.springframework.boot", "spring-boot-starter-actuator")
    implementation("org.springframework.boot", "spring-boot-starter-validation")
    testImplementation(kotlin("test-junit5"))
    testImplementation("com.ninja-squad", "springmockk", "2.0.3")
    testImplementation("no.nav.security", "token-validation-test-support", "1.3.0")
    testImplementation("org.springframework.boot", "spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
        exclude(module = "mockito-core")
    }
    testRuntimeOnly("com.h2database", "h2", "1.4.200")
}

noArg {
    annotation("javax.persistence.Entity")
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "17"
    }
    test {
        useJUnitPlatform()
    }
}
