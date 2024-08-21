package io.github.bitfist.particle.spring;

import io.github.bitfist.particle.ParticleWindow;
import io.github.bitfist.particle.spring.window.ParticleWindowURLProvider;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.springframework.boot.SpringApplication;

import javax.swing.SwingUtilities;
import java.lang.reflect.InvocationTargetException;

public class ParticleApplication {

    public static void run(Class<?> applicationClass, String[] args) throws InterruptedException, InvocationTargetException {
        SwingUtilities.invokeAndWait(() -> {
            System.setProperty("java.awt.headless", "false");
            var applicationContext = SpringApplication.run(applicationClass, args);

            var display = applicationContext.getBean(Display.class);
            var particleWindow = applicationContext.getBean(ParticleWindow.class);
            var urlProvider = applicationContext.getBean(ParticleWindowURLProvider.class);
            var shell = applicationContext.getBean(Shell.class);

            particleWindow.open(urlProvider.getURL());
            startEventLoop(display, shell);
        });
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
