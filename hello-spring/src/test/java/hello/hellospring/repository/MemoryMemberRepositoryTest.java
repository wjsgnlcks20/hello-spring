package hello.hellospring.repository;

import hello.hellospring.doamin.Member;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import hello.hellospring.repository.MemoryMemberRepository;


class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    void afterEach(){
        repository.clearStore();
    }

    @Test
    void save(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member result = repository.findById(member1.getid()).get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        long result = repository.findAll().size();
        assertThat(result).isEqualTo(2);
    }

    @Test
    void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member result = repository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);
    }
}
