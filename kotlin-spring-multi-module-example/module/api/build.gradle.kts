tasks.getByName("bootJar") {
    enabled = true
}

tasks.getByName("jar") {
    enabled = false
}

dependencies {
    implementation(project(":module:domain"))
    implementation(project(":support:logging"))
    implementation(project(":support:util"))
    implementation("org.springframework.boot:spring-boot-starter-web")
}
