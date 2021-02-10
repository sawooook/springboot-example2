package hello.core.Discount;

import hello.core.Member.Grade;
import hello.core.Member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private final int discountPercent = 10;
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.Vip) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
