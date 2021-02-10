package hello.core.Member;

public class MemberSeriveImpl implements MemberService {

// 관심사의 분리 -> 역할과 실행하는 역할이 명확히 분리되었다.
    private final MemberRepository memberRepository;

    public MemberSeriveImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findByid(memberId);
    }
}
