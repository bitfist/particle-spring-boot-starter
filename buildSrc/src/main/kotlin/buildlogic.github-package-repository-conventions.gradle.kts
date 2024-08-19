plugins {
    id("buildlogic.java-library-conventions")
}

repositories {
    maven {
        name = "GitHubPackages"
        url = uri("https://maven.pkg.github.com/bitfist/particle")
        credentials {
            username = project.property("GITHUB_ACTOR") as String? ?: System.getenv("GITHUB_ACTOR")
            password = project.property("GITHUB_TOKEN") as String? ?: System.getenv("GITHUB_TOKEN")
        }
    }
}