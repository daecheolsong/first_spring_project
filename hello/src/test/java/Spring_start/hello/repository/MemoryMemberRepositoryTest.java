package Spring_start.hello.repository;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import Spring_start.hello.domain.Member;

public class MemoryMemberRepositoryTest {
	
	MemoryMemberRepository repository = new MemoryMemberRepository();
	
	
	@AfterEach // 테스트는 독립적으로 이루어져야 한다.
	public void afterEach () {

		repository.clearStore();
	}
	
	@Test
	public void save() {
		//given
		Member member = new Member();
		member.setName("spring");
		
		//when
		repository.save(member);
		
		
		//then
		Member result= repository.findById(member.getId()).get();
		
		Assertions.assertThat(result).isEqualTo(member);
		
	}
	
	@Test
	public void findByName() {
		//given
		
		Member member1 = new Member();
		member1.setName("a");
		repository.save(member1);
		Member member2 = new Member();
		member2.setName("b");
		repository.save(member2);
		
		//when
		
		Member result= repository.findByName("a").get();
		
		//then
		
		Assertions.assertThat(result).isEqualTo(member1);
	}
	
	@Test
	public void findAll() {
		//given
		
		Member member1 = new Member();
		member1.setName("a");
		repository.save(member1);
		Member member2 = new Member();
		member1.setName("b");
		repository.save(member2);
		
		//when
		List<Member> result = repository.findAll();
		
		Assertions.assertThat(result.size()).isEqualTo(3);
	}

}
