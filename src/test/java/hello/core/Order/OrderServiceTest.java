package hello.core.Order;

import hello.core.AppConfig;
import hello.core.Discount.DiscountPolicy;
import hello.core.Discount.FixDiscountPolicy;
import hello.core.Member.Grade;
import hello.core.Member.Member;
import hello.core.Member.MemberSeriveImpl;
import hello.core.Member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;

public class OrderServiceTest {
    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();
    OrderSerivce orderSerivce = appConfig.orderSerivce();
    DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Test
    void orderTest(){
        Long memberId = 1L;
        Member member = new Member(memberId, "Saouk", Grade.Vip);
        memberService.join(member);
        Order order = orderSerivce.createOrder(memberId, "bag", 10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }

    @Test
    void serviceTest(){
        Member member = new Member(1L, "saouk", Grade.Vip);
        memberService.join(member);

        Order order = orderSerivce.createOrder(1L, "bag", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);


    }


}
