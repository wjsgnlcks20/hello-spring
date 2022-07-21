package hello.hellospring.service;

import hello.hellospring.doamin.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

    @Autowired MemberRepository memberRepository;
    @Autowired MemberService memberService;
//    MemoryMemberRepository memberRepository = new MemoryMemberRepository();
//    MemberService memberService = new MemberService(memberRepository);

    @Test
    void join() {
        // given
        Member member1 = new Member();
        member1.setName("spring_test1");

        // when
        Long saveId = memberService.join(member1);

        // then
        Member result = memberService.findOne(member1.getid()).get(); // 근데 findOne 함수 사용하는게 join 함수 테스트 온전히 하는데 당연히 영향을 주지않나.
        assertThat(result.getName()).isEqualTo(member1.getName());
    }

    @Test
    void validateDuplicateMember() {
        //given
        Member member1 = new Member();
        Member member2 = new Member();
        member1.setName("spring_test1");
        member2.setName("spring_test1");
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