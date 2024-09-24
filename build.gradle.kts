plugins {
	id("buildlogic.java-library-conventions")
	id("buildlogic.swt-library-conventions")
	id("buildlogic.publishing-conventions")
	id("buildlogic.github-package-repository-conventions")
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

dependencies {
	api("io.github.bitfist:particle:0.1.3")

	val springBootVersion = "3.3.3"
	implementation(platform("org.springframework.boot:spring-boot-dependencies:$springBootVersion"))
	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor:$springBootVersion")
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("com.fasterxml.jackson.core:jackson-databind")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
}
