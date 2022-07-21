package hello.hellospring.service;

import hello.hellospring.doamin.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.*;

class MemberServiceTest {


    MemoryMemberRepository memberRepository;
    MemberService memberService;
//    MemoryMemberRepository memberRepository = new MemoryMemberRepository();
//    MemberService memberService = new MemberService(memberRepository);

    // BEFORE EACH 존재 이해 안됨.
    // 내부에서 각 테스트 진행할때마다 새로 repository 인스턴스 생성해서 초기화 해주면
    // afterEach 실행시켜서 repository 초기화 해 줄 필요가 없지 않나?
    // 근데 afterEach 주석처리하면 테스트 간 데이터 누적으로 에러남.

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    void clearRepository(){
        memberRepository.clearStore();
    }

    @Test
    void join() {
        // given
        Member member1 = new Member();
        member1.setName("spring1");

        // when
        Long saveId = memberService.join(member1);

        // then
        Member result = memberService.findOne(member1.getMember_id()).get(); // 근데 findOne 함수 사용하는게 join 함수 테스트 온전히 하는데 당연히 영향을 주지않나.
        assertThat(result).isEqualTo(member1);
    }

    @Test
    void validateDuplicateMember() {
        //given
        Member member1 = new Member();
        Member member2 = new Member();
        member1.setName("spring1");
        member2.setName("spring1");
        memberService.join(member1);

        //when //then
        IllegalStateException e = Assertions.assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

//        try {
//            memberService.join(member2);
//            Assertions.fail();
//        }
//        catch(IllegalStateException e1){
//            assertThat(e1.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}