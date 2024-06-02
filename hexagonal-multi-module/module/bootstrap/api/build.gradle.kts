dependencies {
    implementation(project(":module:usecase"))
    implementation(project(":module:domain"))
    implementation(project(":module:infrastructure:kafka"))

    implementation(libs.spring.boot.starter.web)
    developmentOnly(libs.spring.boot.devtools)
    developmentOnly(libs.spring.boot.docker.compose)
    testImplementation(libs.testcontainers)
    testImplementation(libs.testcontainers.junit.jupiter)
    testImplementation(libs.kotest.extensions.testcontainers)
}
