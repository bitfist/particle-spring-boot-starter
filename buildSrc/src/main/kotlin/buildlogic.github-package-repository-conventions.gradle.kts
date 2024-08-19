plugins {
    id("buildlogic.java-library-conventions")
}

repositories {
    maven {
        name = "GitHubPackages"
        url = uri("https://maven.pkg.github.com/bitfist/particle")
        credentials {
            username = project.findProperty("GPR_USER") as String? ?: System.getenv("GITHUB_ACTOR")
            password = project.findProperty("GPR_KEY") as String? ?: System.getenv("GPR_KEY")
        }
    }
}