package hello.core.BeanFind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanFind {

    AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){

        String[] bean = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String be : bean) {
            Object b123 = annotationConfigApplicationContext.getBean(be);
            System.out.println("name="+b123);

        }

    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findAppBean(){

        String[] bean = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String be : bean) {
            BeanDefinition b123 = annotationConfigApplicationContext.getBeanDefinition(be);

            if (b123.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println("print:" + b123);
            }

        }

    }

}
