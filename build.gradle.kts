plugins {
	id("buildlogic.java-library-conventions")
	id("buildlogic.swt-library-conventions")
	id("buildlogic.version-conventions")
	id("buildlogic.publishing-conventions")
	id("buildlogic.github-package-repository-conventions")
}

dependencies {
	api("io.github.bitfist:particle:0.1.3")

	implementation(platform("org.springframework.boot:spring-boot-dependencies:3.3.2"))
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("com.fasterxml.jackson.core:jackson-databind")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}
