package hello.core.Member;

import hello.core.AppConfig;

public class MemberApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
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
