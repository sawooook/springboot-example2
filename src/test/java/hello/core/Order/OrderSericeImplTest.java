package hello.core.Order;

import hello.core.Discount.FixDiscountPolicy;
import hello.core.Member.Grade;
import hello.core.Member.Member;
import hello.core.Member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderSericeImplTest {

    @Test
    void createOreder() {
        MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
        memoryMemberRepository.save(new Member(1L,"saouk", Grade.Basic));

        OrderSericeImpl orderSerice = new OrderSericeImpl(memoryMemberRepository, new FixDiscountPolicy());
        Order itema = orderSerice.createOrder(1L, "itema", 10000);

        Assertions.assertThat(itema.getDiscountPrice()).isEqualTo(0);
    }
}