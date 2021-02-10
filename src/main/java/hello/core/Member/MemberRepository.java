package hello.core.Member;

public interface MemberRepository {

    void save(Member member);
    Member findByid(Long memberId);
}
