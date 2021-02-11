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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 구성영역은 당연히 변경된다
// APpConfig는 공연의 기획자라고 생각하고
// 공연 기획자는 공연 참여자인 구현 객체들을 모두 알아야한다.


//설정 정보라는 뜻임 구성정보를 담당하는 뜻의 파일 이라는 뜻
//싱글톤을 보장해주기위해 컨피규레이션을 사용함 -> 객체하나만 사용하도록
//cilb를 이용해서 바이트 코드를 조작함
//스프링 컨테이너에서 관리하는게 아님
@Configuration
public class AppConfig {
//    환경 설정은 APPConfig에서 다한다.


//  이렇게 하면 스프링 컨테이너에 등록이 된다.
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
//    위에 코드만 바꾸면 됨 new MemomryMember => MemoryMysql
    @Bean
    public MemberService memberService() {
        return new MemberSeriveImpl(memberRepository());
    }

    //    이런걸 생성자 주입이라고함
    @Bean
    public OrderSerivce orderSerivce() {
        return null;
//        return new OrderSericeImpl(memberRepository(), new FixDiscountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
