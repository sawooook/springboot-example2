package hello.core.StateFul;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.ObjectInputFilter;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {
    @Test
    void StatefulTest() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService bean1 = annotationConfigApplicationContext.getBean(StatefulService.class);
        StatefulService bean2 = annotationConfigApplicationContext.getBean(StatefulService.class);

        int userA = bean1.order("userA", 10000);
        int userB = bean2.order("userB", 20000);

        System.out.println("==========="+userA);
        System.out.println("==========="+userB);

    }

    @Configuration
    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}