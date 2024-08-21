package io.github.bitfist.particle.spring.window;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bitfist.particle.ParticleWindow;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;

@AutoConfiguration
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE)
@ConditionalOnBean(ParticleWindowURLProvider.class)
@ConditionalOnMissingBean(ParticleWindow.class)
@EnableConfigurationProperties(ParticleWindowProperties.class)
public class ParticleWindowAutoConfiguration {

    @Bean
    @ParticleObjectMapper
    @ConditionalOnMissingBean
    ObjectMapper particleObjectMapper() {
        return new ObjectMapper();
    }

    @Bean(destroyMethod = "")
    @ConditionalOnMissingBean
    Display display() {
        return new Display();
    }

    @Bean(destroyMethod = "")
    @ConditionalOnMissingBean
    Shell shell(Display display, ParticleWindowProperties properties) {
        var shell = new Shell(display);

        if (properties.getMinimumWidth() != null && properties.getMinimumHeight() != null) {
            shell.setMinimumSize(properties.getMinimumWidth(), properties.getMinimumHeight());
        }

        if (properties.getMaximumWidth() != null && properties.getMaximumHeight() != null) {
            shell.setMaximumSize(properties.getMaximumWidth(), properties.getMaximumHeight());
        }

        if (properties.getTitle() != null) {
            shell.setText(properties.getTitle());
        }

        if (properties.getIconUrl() != null) {
            shell.setImage(
                    new Image(
                            display,
                            ParticleWindowAutoConfiguration.class.getResourceAsStream(properties.getIconUrl())
                    )
            );
        }

        shell.setMaximized(properties.isMaximized());

        return shell;
    }

    @Bean
    public ParticleWindow particleWindow(Shell shell, @ParticleObjectMapper ObjectMapper particleObjectMapper) {
        return new ParticleWindow(shell, particleObjectMapper);
    }
}
