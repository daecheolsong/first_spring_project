package Spring_start.hello.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import Spring_start.hello.domain.Member;
import Spring_start.hello.repository.MemberRepository;

@SpringBootTest
@Transactional // rollback test �ϳ��ϳ� ���� test case������ ����
public class MemberServiceIntegrationTest {

	@Autowired MemberService memberService;
	@Autowired MemberRepository memberRepository;
	
	
	
	
	@Test
	public void ȸ������() throws Exception {
		
		//Given
		Member member = new Member();
		member.setName("spring");
		
		//When
		Long saveId = memberService.join(member);
		
		//Then
		Member findMember = memberRepository.findById(saveId).get();
		assertEquals(member.getName(), findMember.getName());
	}
	@Test
	 public void �ߺ�_ȸ��_����() throws Exception {
		//Given
		
		Member member1 = new Member();
		member1.setName("spring");
		
		Member member2 = new Member();
		member2.setName("spring");
		
		//when
		
		memberService.join(member1);
		IllegalStateException e = assertThrows(IllegalStateException.class,
				() -> memberService.join(member2));
	
		assertThat(e.getMessage()).isEqualTo("�̹� �����ϴ� ȸ���Դϴ�.");
	}
	
}
