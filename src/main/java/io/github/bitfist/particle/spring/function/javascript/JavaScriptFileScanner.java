package io.github.bitfist.particle.spring.function.javascript;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.util.ClassUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

public class JavaScriptFileScanner {

    private static final Logger log = Logger.getLogger(JavaScriptFileScanner.class.getName());

    private final ListableBeanFactory beanFactory;

    public JavaScriptFileScanner(ListableBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public Set<Class<?>> scanClasspath() {
       try {
           String packageSearchPath = "classpath*:" + resolveBasePackage(getBasePackage()) + "/**/*.class";
           PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
           MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory(resolver);

           Resource[] resources = resolver.getResources(packageSearchPath);
           var classes = new HashSet<Class<?>>();

           for (Resource resource : resources) {
               if (resource.isReadable()) {
                   MetadataReader metadataReader = metadataReaderFactory.getMetadataReader(resource);
                   if (isCandidate(metadataReader)) {
                       classes.add(Class.forName(metadataReader.getClassMetadata().getClassName()));
                   }
               }
           }

           return classes;
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
    }

    private boolean isCandidate(MetadataReader metadataReader) {
        if (!metadataReader.getClassMetadata().isInterface()) {
            return false;
        }

        return metadataReader.getAnnotationMetadata()
                .isAnnotated("io.github.bitfist.particle.function.javascript.JavaScriptFile");
    }

    private static String resolveBasePackage(String basePackage) {
        return ClassUtils.convertClassNameToResourcePath(basePackage);
    }

    private String getBasePackage() {
        var applications = beanFactory.getBeansWithAnnotation(SpringBootApplication.class).values();

        if (applications.isEmpty()) {
            throw new IllegalStateException("No Spring Boot application found");
        }

        Object application = applications.iterator().next();

        if (applications.size() > 1) {
            log.warning("More than 1 bean annotated with @SpringBootApplication found, using " + application.getClass().getName());
        }

        return application.getClass().getPackage().getName();
    }

}
