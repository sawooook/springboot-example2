package hello.core.NewOrder;

import hello.core.Member.Member;
import hello.core.Member.MemberRepository;
import hello.core.Member.MemoryMemberRepository;
import hello.core.NewDiscount.NewDiscount;
import hello.core.NewDiscount.NewFixDiscount;

public class NewOrderServiceImpl implements NewOrderService {
    MemberRepository memberRepository = new MemoryMemberRepository();
    NewDiscount newDiscount = new NewFixDiscount();


    @Override
    public NewOrder createdOrder(Long memberId, String orderName, int price) {
        Member member = memberRepository.findByid(memberId);
        int discountCharge = newDiscount.discount(member);

        NewOrder newOrder = new NewOrder(orderName, price - discountCharge, memberId);
        return newOrder;

    }
}
