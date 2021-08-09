package Spring_start.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import Spring_start.hello.aop.TimeTraceAop;
import Spring_start.hello.repository.MemberRepository;
import Spring_start.hello.service.MemberService;

@Configuration
//Configuration이라고 하면 설정파일을 만들기 위한 애노테이션 or Bean을 등록하기 위한 애노테이션이다.
/*@Configuration이 붙었을때의 결과를 보면 CGLIB라는게 붙은걸 볼수있다.
사실 이것은 내가 만든 클래스가 아닌 스프링에서 CGLIB라는 
바이트코드 조작 라이브러리를 사용해서 AppConfig를 상속받은 임의의 클래스를 만들고 
그것을 스프링 빈으로 등록했기 때문에 이런결과가 나오게 된다.
이때 임의의 클래스를 통해서 싱글톤이 되는것을 유지해준다. */
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

	@Bean // bean 에 등록하라는 뜻 
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
