plugins {
    `kotlin-dsl`                                // Kotlin DSL 지원
    `java-gradle-plugin`                       // Gradle Plugin 패키징
    id("com.gradle.plugin-publish") version "1.3.1"
}

// 그룹/버전 설정
group = "com.github.monorail-team"
version = "0.0.10"

repositories {
    gradlePluginPortal()    // plugin-publish 플러그인용
    mavenCentral()          // 일반 라이브러리용
    maven { url = uri("https://jitpack.io") } // contract4k 의존성용
}

java {
    withJavadocJar()
    withSourcesJar()
}

gradlePlugin {

    website = "https://github.com/monorail-team/contract4k"
    vcsUrl   = "https://github.com/monorail-team/contract4k.git"


    plugins {
        create("contract4k") {
            id = "com.github.monorail-team.contract4k"
            implementationClass = "com.github.monorailteam.contract4k.gradle.Contract4kPlugin"
            tags     = listOf("contract4k", "aspectj", "kotlin", "gradle-plugin")
        }
    }
}



dependencies {
    compileOnly(kotlin("gradle-plugin", "2.0.21"))
    compileOnly("io.freefair.gradle:aspectj-plugin:8.4")
    implementation("com.github.monorail-team:contract4k:${version}")
    implementation("org.aspectj:aspectjrt:1.9.21")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
}
