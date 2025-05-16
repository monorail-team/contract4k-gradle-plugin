package com.github.monorail_team.contract4k.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project
import io.freefair.gradle.plugins.aspectj.AspectJPlugin
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension

class Contract4kPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        // 1) AspectJ post-compile weaving 플러그인 적용
        project.plugins.apply(AspectJPlugin::class.java)

        // 2) contract4k 의존성 자동 추가
        project.dependencies.add("aspect", "com.github.monorail-team:contract4k:${project.version}")
        project.dependencies.add("implementation", "org.aspectj:aspectjrt:1.9.21")
        project.dependencies.add("implementation", "org.jetbrains.kotlin:kotlin-reflect")

        // 3) JVM 툴체인 강제 설정 (선택 사항)
        project.extensions.findByType(KotlinJvmProjectExtension::class.java)
            ?.jvmToolchain(21)
    }
}