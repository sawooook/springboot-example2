package hello.core.NewDiscount;

import hello.core.Member.Grade;
import hello.core.Member.Member;


public class NewFixDiscount implements NewDiscount {

    private final int discountCharge = 1000;

    @Override
    public int discount(Member member) {
        if (member.getGrade() == Grade.Vip) {
            return discountCharge;
        } else {
            return 0;
        }
    }
}
