package hello.core.Discount;

import hello.core.AppConfig;
import hello.core.Member.Grade;
import hello.core.Member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10%할인이 적용되어야 한다,")
    void vip_o() {
        Member member1 = new Member(1L, "saouk", Grade.Vip);

        int price = discountPolicy.discount(member1,10000);
        assertThat(price).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야한다")
    void vip_x() {
        Member member = new Member(1L, "saouk", Grade.Basic);
        int price = discountPolicy.discount(member, 10000);
        assertThat(price).isEqualTo(0);
    }
}