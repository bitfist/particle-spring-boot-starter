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
	api(libs.particle)

	implementation(platform(libs.springBootPlatform))
	annotationProcessor(libs.springBootConfigurationProcessor)
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("com.fasterxml.jackson.core:jackson-databind")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
}
