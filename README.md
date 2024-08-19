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