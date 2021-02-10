package hello.core;

import hello.core.Member.Grade;
import hello.core.Member.Member;
import hello.core.Member.MemberSeriveImpl;
import hello.core.Member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServieTest {
    AppConfig appConfig = new AppConfig();
    MemberService ms = appConfig.memberService();

    @Test
    void join() {
        // given
        Member member = new Member(1L, "MEMBER1", Grade.Vip);
        // when
        ms.join(member);
        Member findMember = ms.findMember(1L);
        // then
        Assertions.assertThat(member).isEqualTo(findMember);
        
    }
}
