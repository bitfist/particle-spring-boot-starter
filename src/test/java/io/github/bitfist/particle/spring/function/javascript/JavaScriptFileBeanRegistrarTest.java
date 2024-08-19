package io.github.bitfist.particle.spring.function.javascript;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Import({TestApplication.class, JavaScriptFileBeanRegistrar.class})
class JavaScriptFileBeanRegistrarTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void givenJavaScriptFile_whenPostProcess_thenProxyRegistered() {
        var bean = applicationContext.getBean(SomeJavaScript.class);

        assertThat(bean).isNotNull();
    }
}