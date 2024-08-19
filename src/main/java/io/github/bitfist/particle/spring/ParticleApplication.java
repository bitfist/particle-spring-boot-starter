package io.github.bitfist.particle.spring;

import io.github.bitfist.particle.ParticleWindow;
import io.github.bitfist.particle.spring.window.ParticleWindowURLProvider;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.springframework.boot.SpringApplication;

public class ParticleApplication {

    public static void start(Class<?> applicationClass, String[] args) {
        System.setProperty("java.awt.headless", "false");
        var applicationContext = SpringApplication.run(applicationClass, args);

        var particleWindow = applicationContext.getBean(ParticleWindow.class);
        var urlProvider = applicationContext.getBean(ParticleWindowURLProvider.class);
        var display = applicationContext.getBean(Display.class);
        var shell = applicationContext.getBean(Shell.class);

        particleWindow.open(urlProvider.getURL());
        startEventLoop(display, shell);
    }

    private static void startEventLoop(Display display, Shell shell) {
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
        System.exit(0);
    }

}
