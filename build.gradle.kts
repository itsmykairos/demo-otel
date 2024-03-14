plugins {
	java
	id("org.springframework.boot") version "3.2.3"
	id("io.spring.dependency-management") version "1.1.4"
}

group = "com.example.otel"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencyManagement {
	imports {
		mavenBom("io.opentelemetry:opentelemetry-bom:1.36.0")
		mavenBom("io.opentelemetry.instrumentation:opentelemetry-instrumentation-bom-alpha:2.1.0-alpha")
	}
}
dependencies {
//	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
//	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.projectreactor:reactor-test")

	implementation("io.opentelemetry.instrumentation:opentelemetry-spring-boot-starter")
	implementation("com.h2database:h2")

	implementation("io.opentelemetry.instrumentation:opentelemetry-spring-webflux-5.3")


}

tasks.withType<Test> {
	useJUnitPlatform()
}
