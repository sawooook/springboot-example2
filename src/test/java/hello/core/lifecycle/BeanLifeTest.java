package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeTest {

    @Test
    public void lifeCycle() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetWorkClient client = ac.getBean(NetWorkClient.class);
        ac.close();
    }

    @Configuration
    static class LifeCycleConfig {
        
        @Bean
        public NetWorkClient netWorkClient() {
            NetWorkClient netWorkClient = new NetWorkClient();
            netWorkClient.setUrl("www,naver.com");
            return netWorkClient;
        }
    }
}
