package Spring_start.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import Spring_start.hello.aop.TimeTraceAop;
import Spring_start.hello.repository.MemberRepository;
import Spring_start.hello.service.MemberService;

@Configuration
//Configuration�̶�� �ϸ� ���������� ����� ���� �ֳ����̼� or Bean�� ����ϱ� ���� �ֳ����̼��̴�.
/*@Configuration�� �پ������� ����� ���� CGLIB��°� ������ �����ִ�.
��� �̰��� ���� ���� Ŭ������ �ƴ� ���������� CGLIB��� 
����Ʈ�ڵ� ���� ���̺귯���� ����ؼ� AppConfig�� ��ӹ��� ������ Ŭ������ ����� 
�װ��� ������ ������ ����߱� ������ �̷������ ������ �ȴ�.
�̶� ������ Ŭ������ ���ؼ� �̱����� �Ǵ°��� �������ش�. */
public class SpringConfig {
	/*private DataSource dataSource;
	
	@Autowired
	public SpringConfig(DataSource dataSource) {
		this.dataSource= dataSource;
		
	}
	*/
/*	private EntityManager em;
	private final DataSource dataSource;
	
	@Autowired
	public SpringConfig(EntityManager em,DataSource dataSource) {
		this.em=em;
		this.dataSource=dataSource;
	}
*/
	private final MemberRepository memberRepository;
	
	@Autowired
	public SpringConfig(MemberRepository memberRepository) {
		this.memberRepository=memberRepository;
		
	}

	@Bean // bean �� ����϶�� �� 
	public MemberService memberService() {
		return new MemberService(memberRepository);
	}
	
	
//	@Bean 
//	public MemberRepository memberRepository() {
	//	return new MemoryMemberRepository();
	//	return new JdbcMemberRepository(dataSource);
	//	return new JdbcTemplateMemberRepository(dataSource);	
	//	return new JpaMemberRepository(em);
		
	//	}
}
