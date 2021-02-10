package hello.core;

import hello.core.Member.Grade;
import hello.core.Member.Member;
import hello.core.Member.MemberRepository;
import hello.core.Member.MemoryMemberRepository;
import hello.core.NewOrder.NewOrder;
import hello.core.NewOrder.NewOrderService;
import hello.core.NewOrder.NewOrderServiceImpl;
import hello.core.Order.Order;

public class NewOrderApp {
    public static void main(String[] args) {
        MemberRepository memberRepository = new MemoryMemberRepository();
        NewOrderService newOrderService = new NewOrderServiceImpl();

        Member member = new Member(1L,"saouk", Grade.Vip);
        memberRepository.save(member);

        NewOrder order= newOrderService.createdOrder(1L, "bag", 10000);

        System.out.println("order:"+order);




    }
}
