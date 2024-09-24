plugins {
    id("buildlogic.java-library-conventions")
}

repositories {
    maven {
        name = "GitHubPackages"
        url = uri("https://maven.pkg.github.com/bitfist/particle")
        credentials {
            username = (project.findProperty("GPR_USER") as String? ?: System.getenv("GITHUB_ACTOR")) ?: throw IllegalStateException("GitHub Package Registry username missing")
            password = (project.findProperty("GPR_KEY") as String? ?: System.getenv("GPR_KEY")) ?: throw IllegalStateException("GitHub Package Registry token missing")
            println("using auth $username=$password")
        }
    }
}