package hello.core.BeanFind;

import hello.core.Discount.DiscountPolicy;
import hello.core.Discount.FixDiscountPolicy;
import hello.core.Discount.RateDiscountPolicy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

public class ApplicationContextDiscount {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    @DisplayName("부모로 타입으로 조회시, 자식이 둘이상이면 에러가 발생한다")
    void findBeayByName() {
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class,
                ()-> applicationContext.getBean(DiscountPolicy.class));
    }

    @Test
    @DisplayName("이름으로 조회를 하면 상관이 없다")
    void findByName1() {
        DiscountPolicy rateDiscountPolicy = applicationContext.getBean("rateDiscountPolicy", DiscountPolicy.class);
        org.assertj.core.api.Assertions.assertThat(rateDiscountPolicy).isInstanceOf(DiscountPolicy.class);
    }

    @Test
    @DisplayName("부모 타입으로 모두 조회")
    void findByAllParent() {
        Map<String, DiscountPolicy> beansOfType = applicationContext.getBeansOfType(DiscountPolicy.class);
        org.assertj.core.api.Assertions.assertThat(beansOfType).isEqualTo(2);
    }



    @Test
    @DisplayName("특정 하위 타입으로 조회")
    void findByBeanSub() {
        RateDiscountPolicy rateDiscountPolicy = applicationContext.getBean("rateDiscountPolicy", RateDiscountPolicy.class);
        org.assertj.core.api.Assertions.assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy.class);
    }

    @Configuration
    static class TestConfig {

        @Bean
        public DiscountPolicy rateDiscountPolicy() {
            return new RateDiscountPolicy();
        }

        @Bean
        public DiscountPolicy FixDiscountPolicy() {
            return new FixDiscountPolicy();
        }

    }

}
