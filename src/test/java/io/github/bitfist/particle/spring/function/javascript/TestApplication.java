package io.github.bitfist.particle.spring.function.javascript;

import io.github.bitfist.particle.ParticleWindow;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootApplication
public class TestApplication {

    @Primary
    @Bean
    ParticleWindow particleWindow() {
        ParticleWindow particleWindow = mock(ParticleWindow.class);
        when(particleWindow.registerJavaScriptFile(any())).thenReturn((SomeJavaScript) () -> {

        });
        return particleWindow;
    }
}
