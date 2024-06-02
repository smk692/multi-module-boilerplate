rootProject.name = "hexagonal-multi-module"
include(
    "module:bootstrap:api",
    "module:bootstrap:worker",
    "module:usecase",
    "module:domain",
    "module:infrastructure:kafka",
    "module:infrastructure:persistence",
)

project(":module:bootstrap:api").projectDir = file("module/bootstrap/api")
project(":module:bootstrap:worker").projectDir = file("module/bootstrap/worker")
project(":module:usecase").projectDir = file("module/usecase")
project(":module:domain").projectDir = file("module/domain")
project(":module:infrastructure:persistence").projectDir = file("module/infrastructure/persistence")
project(":module:infrastructure:kafka").projectDir = file("module/infrastructure/kafka")


pluginManagement {
    val kotlinVersion: String by settings
    val springBootVersion: String by settings
    val springDependencyManagementVersion: String by settings
    val ktlintVersion: String by settings

    resolutionStrategy {
        repositories {
            gradlePluginPortal()
            mavenCentral()
        }

        eachPlugin {
            when (requested.id.id) {
                "org.jetbrains.kotlin.jvm" -> useVersion(kotlinVersion)
                "org.jetbrains.kotlin.plugin.spring" -> useVersion(kotlinVersion)
                "org.jetbrains.kotlin.plugin.jpa" -> useVersion(kotlinVersion)
                "org.jetbrains.kotlin.kapt" -> useVersion(kotlinVersion)
                "org.springframework.boot" -> useVersion(springBootVersion)
                "io.spring.dependency-management" -> useVersion(springDependencyManagementVersion)
                "org.jlleitschuh.gradle.ktlint" -> useVersion(ktlintVersion)
            }
        }
    }
}

