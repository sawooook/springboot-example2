package hello.core.Order;

import hello.core.Discount.DiscountPolicy;
import hello.core.Discount.FixDiscountPolicy;
import hello.core.Discount.RateDiscountPolicy;
import hello.core.Member.Member;
import hello.core.Member.MemberRepository;
import hello.core.Member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderSericeImpl implements OrderSerivce {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy ;
//
//    @Autowired
//    public void setMemberRepository(DiscountPolicy discountPolicy) {
//        this.discountPolicy = discountPolicy;
//    }
//
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        this.discountPolicy = discountPolicy;
//    }

//    @Autowired
//    public OrderSericeImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

    //    final은 무조건 값이 할당해 있어야함

    /*
    문제점 발견
    OCP와 DIP를 지키지 못함
    추상 인터페이스 뿐만 아니라 구현 클레스에도 의존하고 있음
    fixDiscountPolicy도 의존하고 있음
    # DIP를 위반했기 때문에
    orderServiceImpl도 변경해야함 그러면 OCP도 위반함
    역할과 구현을 분리하면
    나는 운전면허만 있으면 할 수 있는데
     이건 내가 전기차로바꿨다는 이유로 라이센스를 바꿔야함

    이런 문제는 어떻게 해결할까?

*/

    @Override
    public Order createOrder(Long MemberId, String itemName, int itemPice) {
        Member member = memberRepository.findByid(MemberId);
        int resultPrice = discountPolicy.discount(member, itemPice);
        Order order = new Order(MemberId, itemName, itemPice, resultPrice);

        return order;
    }
}


