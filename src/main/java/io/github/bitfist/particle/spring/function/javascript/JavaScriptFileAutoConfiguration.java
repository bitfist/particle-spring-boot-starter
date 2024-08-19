package io.github.bitfist.particle.spring.function.javascript;

import io.github.bitfist.particle.spring.window.ParticleWindowAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Import;
import org.springframework.core.Ordered;

@AutoConfiguration
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE + 10)
@AutoConfigureAfter(ParticleWindowAutoConfiguration.class)
@Import(JavaScriptFileBeanRegistrar.class)
public class JavaScriptFileAutoConfiguration {

}