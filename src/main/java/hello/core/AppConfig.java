package hello.core;

import hello.core.Discount.DiscountPolicy;
import hello.core.Discount.FixDiscountPolicy;
import hello.core.Discount.RateDiscountPolicy;
import hello.core.Member.MemberRepository;
import hello.core.Member.MemberSeriveImpl;
import hello.core.Member.MemberService;
import hello.core.Member.MemoryMemberRepository;
import hello.core.Order.OrderSericeImpl;
import hello.core.Order.OrderSerivce;

// 구성영역은 당연히 변경된다
// APpConfig는 공연의 기획자라고 생각하고
// 공연 기획자는 공연 참여자인 구현 객체들을 모두 알아야한다.


public class AppConfig {
//    환경 설정은 APPConfig에서 다한다.
    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
//    위에 코드만 바꾸면 됨 new MemomryMember => MemoryMysql

    public MemberService memberService() {
        return new MemberSeriveImpl(memberRepository());
    }

    //    이런걸 생성자 주입이라고함
    public OrderSerivce orderSerivce() {
        return new OrderSericeImpl(memberRepository(), new FixDiscountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
