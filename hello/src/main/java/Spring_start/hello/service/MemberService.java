package Spring_start.hello.service;

import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;

import Spring_start.hello.domain.Member;
import Spring_start.hello.repository.MemberRepository;

 //@Service // spring이 MemberService를 스프링 컨테이너에 등록해줌
@Transactional //jpa를 이용하에 데이터를 저장하거나 수정할떄 필요함
public class MemberService {
	
	private final MemberRepository memberRepository;
	// DI 
//@Autowired // 빈에 등록이 되어야 사용가능 , main에 직접 객체를 생성해도 등록이 되지 않음
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository=memberRepository;
	}
	
	/**
	 * 회원가입
	 */
	public Long join (Member member) {
		
		
		validateDuplicateMember(member); //중복 회원 검증
		memberRepository.save(member);
		return member.getId();
		
	}
	
	private void validateDuplicateMember (Member member) {
		memberRepository.findByName(member.getName())
		.ifPresent(m ->{ throw new IllegalStateException("이미 존재하는 회원입니다.");});
	}
	
	/**
	 * 전체 회원 조회
	 */
	
	public List<Member> findMembers() {
		
		return memberRepository.findAll();
	
		
	}
	
	public Optional <Member> findOne(Long memberId) {
		return memberRepository.findById(memberId);
	}

}
