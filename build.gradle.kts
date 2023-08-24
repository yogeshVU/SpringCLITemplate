import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.util.*

plugins {
	id("org.springframework.boot") version "3.0.9"
	id("io.spring.dependency-management") version "1.1.2"
	kotlin("jvm") version "1.9.10"
	kotlin("plugin.spring") version "1.7.22"
}

group = "com.goalabs"
//version = "0.0.1-SNAPSHOT"
val CLI_VERSION:String by project
val CLI_RELEASE_URL:String by project

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("info.picocli:picocli-spring-boot-starter:4.7.4")
	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.projectreactor:reactor-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.named("classes") {
	dependsOn("createProperties")
}


tasks.create("createProperties") {
	dependsOn("processResources")

	doLast {
		File("$buildDir/resources/main/version.properties").writer().use { w ->
			val p = Properties()
			p["version"] = CLI_VERSION
			p["releaseURL"] = CLI_RELEASE_URL
			p.store(w, null)
		}
	}
}