plugins {
    kotlin("jvm") version "1.5.31"
    java
}

group = "io.github.taesk"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

sourceSets.main {
    java.srcDirs("src/main/java", "src/main/kotlin", "build/generated/sources/annotationProcessor/java/main")
}
sourceSets.test {
    java.srcDirs("src/test/java", "src/test/kotlin", "build/generated/sources/annotationProcessor/java/test")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(project(":annotation-processor"))
    annotationProcessor(project(":annotation-processor"))
    testAnnotationProcessor(project(":annotation-processor"))

    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.5.31")
    implementation("org.mockito:mockito-all:1.10.19")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}