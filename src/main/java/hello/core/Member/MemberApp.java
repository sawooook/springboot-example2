package hello.core.Member;

import hello.core.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();


//      모든 객체들을 관리해줌 -> 스프링 컨테이너
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
//      AppConfig설정 정보를 통해서 스프링이 @bean붙은걸 스프링 @bean 객체 생성해서 관리를 함


        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L,"SAOUK",Grade.Vip);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("member:"+member.getName());
        System.out.println("find:"+ findMember.getName());









        //        MemberService ms = new MemberSeriveImpl();
//        Member member = new Member(1L, "MEMBER1", Grade.Vip);
//        ms.join(member);
//
//        Member findMember = ms.findMember(1L);
//        System.out.println("new Member:"+ member.getName());
//        System.out.println("find Member:"+ findMember.getName());
    }



}
