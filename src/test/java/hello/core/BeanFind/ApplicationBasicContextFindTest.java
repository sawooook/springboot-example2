package hello.core.BeanFind;

import hello.core.AppConfig;
import hello.core.Member.Member;
import hello.core.Member.MemberSeriveImpl;
import hello.core.Member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationBasicContextFindTest {


    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBean() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findType() {
        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName() {
        MemberSeriveImpl memberSerive = ac.getBean("memberService", MemberSeriveImpl.class);
        Assertions.assertThat(memberSerive).isInstanceOf(MemberSeriveImpl.class);
    }

    @Test
    @DisplayName("빈이름 조회 X")
    void fincBeanByNameX() {
        assertThrows(NoSuchBeanDefinitionException.class, () ->
                ac.getBean("xxxx", MemberService.class));

    }

}
