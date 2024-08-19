![Coverage](.github/badges/jacoco.svg)
![Branches](.github/badges/branches.svg)

# Particle Spring Boot Starter

This is the Spring Boot Starter for Particle.

## Particle Window

A `ParticleWindow` will be provided as bean, which can be configured through
[properties](src/main/java/io/github/bitfist/particle/spring/window/ParticleWindowProperties.java).

## Particle Function Java

All beans present in the application context annotated with `@BrowserMapping` will be exposed to the autoconfigured
`ParticleWindow`.

## Particle Function JavaScript

All interfaces in the classpath annotated with `@JavaScriptFile` will be processed and the created proxies registered in
the application context.

--------------------------------------------------------------

## Using the GitHub Package Registry

GitHub requires authentication to use a project's package registry. The cleanest version is to set your GitHub user and
an access token in your global Gradle properties file under `~/.gradle/gradle.properties`. This example assumes that
GPR_USER (your GitHub username) and GPR_KEY (an access token) are set in the global properties file.

In case of a pipeline: `GITHUB_ACTOR` is a variable used in GitHub actions. Make sure to provide an access token through
a secret in your pipeline.

### Gradle Kotlin DSL

```kotlin
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
```
### GitHub pipeline

```yaml
name: 'test'
...
env:
  GPR_KEY: ${{ secrets.GPR_KEY }}
```