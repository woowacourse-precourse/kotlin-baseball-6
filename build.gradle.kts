plugins {
    kotlin("jvm") version "1.9.0"
}

repositories {
    mavenCentral()
    maven { setUrl("https://jitpack.io") }
}

dependencies {
    implementation("com.github.woowacourse-projects:mission-utils:1.1.0")
    implementation(kotlin("stdlib-jdk8"))
}

java {
}

tasks {
    test {
        useJUnitPlatform()
    }
}
