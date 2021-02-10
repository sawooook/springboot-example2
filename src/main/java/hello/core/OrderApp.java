package hello.core;

import hello.core.Member.Grade;
import hello.core.Member.Member;
import hello.core.Member.MemberSeriveImpl;
import hello.core.Member.MemberService;
import hello.core.Order.Order;
import hello.core.Order.OrderSericeImpl;
import hello.core.Order.OrderSerivce;

public class OrderApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();
        OrderSerivce orderSerivce = appConfig.orderSerivce();

        Long memberId = 1L;
        Member member = new Member(memberId, "MEMBERA", Grade.Vip);
        memberService.join(member);

        Order order = orderSerivce.createOrder(memberId, "ITEMA", 10000);

        System.out.println("order = "+ order);
        System.out.println("order Caclcutale = "+ order.calculatePrice());
    }
}
