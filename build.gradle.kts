plugins {
    kotlin("jvm") version "1.8.20"
}
repositories {
    mavenCentral()
}
group = "com.github.ltyocg.kommons"
version = "0.0.1"
subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    repositories {
        mavenCentral()
    }
    dependencies {
        testImplementation(kotlin("test"))
    }
    tasks.test {
        useJUnitPlatform()
    }
}
kotlin {
    jvmToolchain(8)
}