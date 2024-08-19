package io.github.bitfist.particle.spring.function.javascript;

import io.github.bitfist.particle.ParticleWindow;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;

import java.util.Set;
import java.util.logging.Logger;

public class JavaScriptFileBeanRegistrar implements BeanFactoryPostProcessor {

    public static final Logger log = Logger.getLogger(JavaScriptFileBeanRegistrar.class.getName());

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
        var particleWindow = beanFactory.getBean(ParticleWindow.class);

        var javaScriptFileScanner = new JavaScriptFileScanner(beanFactory);
        Set<Class<?>> javaScriptFiles = javaScriptFileScanner.scanClasspath();

        for (Class<?> javaScriptFile : javaScriptFiles) {
            registerJavaScriptFileBean((BeanDefinitionRegistry) beanFactory, particleWindow, javaScriptFile);
        }
    }

    private <T> void registerJavaScriptFileBean(
            BeanDefinitionRegistry registry,
            ParticleWindow particleWindow,
            Class<T> javaScriptFile
    ) {
        log.fine("Registering @JavaScriptFile proxy for: " + javaScriptFile.getName());
        T proxy = particleWindow.registerJavaScriptFile(javaScriptFile);

        var beanDefinition = BeanDefinitionBuilder
                .genericBeanDefinition(javaScriptFile, () -> proxy)
                .getBeanDefinition();

        registry.registerBeanDefinition(javaScriptFile.getName(), beanDefinition);
    }
}
