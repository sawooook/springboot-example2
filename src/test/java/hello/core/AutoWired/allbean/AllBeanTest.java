package hello.core.AutoWired.allbean;

import hello.core.AutoAppConfig;
import hello.core.Discount.DiscountPolicy;
import hello.core.Member.Grade;
import hello.core.Member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

public class AllBeanTest {

    @Test
    void findAllBean() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class );
        DiscountService discountService = ac.getBean(DiscountService.class);
        Member member = new Member(1L, "userA", Grade.Vip);
        discountService.discount(member, 10000, "fixDiscountSerive");
    }

    static class DiscountService {
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policies;

        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
            this.policyMap = policyMap;
            this.policies = policies;
            System.out.println(policyMap);
            System.out.println(policies);
        }

        public int discount(Member member, int i, String fixDiscountSerive) {
            DiscountPolicy discountPolicy = policyMap.get(fixDiscountSerive);
            return discountPolicy.discount(member, i);
        }
    }

}
