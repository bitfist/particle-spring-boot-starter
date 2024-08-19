package io.github.bitfist.particle.spring.function.java;

import io.github.bitfist.particle.ParticleWindow;
import io.github.bitfist.particle.function.java.BrowserMapping;
import io.github.bitfist.particle.spring.window.ParticleWindowAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.ApplicationContext;

@AutoConfiguration
@AutoConfigureAfter(ParticleWindowAutoConfiguration.class)
@ConditionalOnBean(ParticleWindow.class)
public class BrowserMappingAutoConfiguration {

    public BrowserMappingAutoConfiguration(ApplicationContext applicationContext, ParticleWindow window) {
        var browserMapping = applicationContext.getBeansWithAnnotation(BrowserMapping.class).values();
        window.registerBrowserMappings(browserMapping);
    }

}
