package hello.core.Discount;

import hello.core.Member.Grade;
import hello.core.Member.Member;

public class FixDiscountPolicy implements DiscountPolicy {
    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.Vip) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
