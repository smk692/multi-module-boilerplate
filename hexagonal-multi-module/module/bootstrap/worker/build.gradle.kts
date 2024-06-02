dependencies {
    implementation(project(":module:domain"))
    implementation(project(":module:usecase"))
    implementation(project(":module:infrastructure:persistence"))

    implementation(libs.spring.boot.starter.web)
    implementation(libs.spring.kafka)
    developmentOnly(libs.spring.boot.devtools)
    developmentOnly(libs.spring.boot.docker.compose)
}
