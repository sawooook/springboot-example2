package hello.core.SingleTon;

import hello.core.AppConfig;
import hello.core.Member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingleTonTest {


    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureConfigure() {
        AppConfig appConfig = new AppConfig();
        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        System.out.println(memberService1);
        System.out.println(memberService2);
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체사용")
    void singleTonService() {
        SingleTonService instance = SingleTonService.getInstance();
        SingleTonService instance1 = SingleTonService.getInstance();
        System.out.println(instance);
        System.out.println(instance1);

        Assertions.assertThat(instance).isSameAs(instance1);

    }

    @Test
    @DisplayName("스프링 컨테이너의 싱글톤 컨테이너")
    void SpringSingletonClass() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = annotationConfigApplicationContext.getBean("memberService", MemberService.class);
        MemberService memberService1 = annotationConfigApplicationContext.getBean("memberService", MemberService.class);

        Assertions.assertThat(memberService).isSameAs(memberService1);
    }
//   스프링 컨테이너를 이용하면 싱글톤으로 작동한다
//   싱글통 방식 말고 요청할 때마다 새로운 객체를 생성하고 반환하응 빈 스코프도 있음
}

/*
* 싱글톤의 주의점
* 객체를 공유하기 때문에 무상태로 설계해야함
* 상태를 유지하도록 해야함
* 값을 변경하는 필드가 있으면 안됨
* 읽기만 가능하게 해야함
* 지역변수, 파라미터, ThreadLocal등을 사용해야함
*
* */
