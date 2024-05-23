tasks.getByName("bootJar") {
    enabled = true
}

tasks.getByName("jar") {
    enabled = false
}

dependencies {
    implementation(project(":module:domain"))
    runtimeOnly(project(":module:infrastructure:rdb"))
    implementation(project(":support:logging"))
    implementation(project(":support:util"))
    implementation("org.springframework.boot:spring-boot-starter-web")
}
