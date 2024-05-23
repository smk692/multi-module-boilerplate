val querydslVersion: String by project

allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.MappedSuperclass")
    annotation("jakarta.persistence.Embeddable")
}

dependencies {
    compileOnly(project(":module:domain"))
    implementation(project(":support:util"))
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    // h2
    runtimeOnly("com.h2database:h2")
    // querydsl
    implementation("com.querydsl:querydsl-jpa:5.0.0:jakarta")
    implementation("com.querydsl:querydsl-core:$querydslVersion")
    kapt("com.querydsl:querydsl-apt:$querydslVersion:jakarta")
    kapt("com.querydsl:querydsl-kotlin-codegen:$querydslVersion")
}

tasks.withType<JavaCompile> {
    options.annotationProcessorPath = configurations.kapt.get()
}

