import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.3.4.RELEASE"
	id("io.spring.dependency-management") version "1.0.10.RELEASE"
	kotlin("jvm") version "1.3.72"
	kotlin("plugin.spring") version "1.3.72"
}

group = "com.example.lab.inbox"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

object Versions {
	const val springCloud = "Hoxton.RELEASE"
	const val r2dbc = "Arabba-SR5"
	const val springDataR2dbc = "1.1.1.RELEASE"
	const val logback = "6.4"
	const val springMockK = "2.0.0"
	const val bouncyCastle = "1.64"
	const val mockkVersion = "1.10.0"
}
dependencyManagement {
	imports {
		mavenBom("io.r2dbc:r2dbc-bom:${Versions.r2dbc}")
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${Versions.springCloud}")
	}
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
	implementation("org.springframework.boot:spring-boot-starter-data-redis-reactive")
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
	implementation("org.springframework.cloud:spring-cloud-stream")
	implementation("org.springframework.cloud:spring-cloud-starter-stream-kafka")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
	implementation("com.h2database:h2")
	implementation("io.r2dbc:r2dbc-h2")
	implementation("io.r2dbc:r2dbc-pool")
	implementation("io.r2dbc:r2dbc-mssql")
	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}
	testImplementation("io.projectreactor:reactor-test")
	testImplementation("io.mockk:mockk:${Versions.mockkVersion}")
	implementation("net.logstash.logback:logstash-logback-encoder:${Versions.logback}")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}
