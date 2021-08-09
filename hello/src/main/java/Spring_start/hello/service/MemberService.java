package Spring_start.hello.service;

import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;

import Spring_start.hello.domain.Member;
import Spring_start.hello.repository.MemberRepository;

 //@Service // spring�� MemberService�� ������ �����̳ʿ� �������
@Transactional //jpa�� �̿��Ͽ� �����͸� �����ϰų� �����ҋ� �ʿ���
public class MemberService {
	
	private final MemberRepository memberRepository;
	// DI 
//@Autowired // �� ����� �Ǿ�� ��밡�� , main�� ���� ��ü�� �����ص� ����� ���� ����
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository=memberRepository;
	}
	
	/**
	 * ȸ������
	 */
	public Long join (Member member) {
		
		
		validateDuplicateMember(member); //�ߺ� ȸ�� ����
		memberRepository.save(member);
		return member.getId();
		
	}
	
	private void validateDuplicateMember (Member member) {
		memberRepository.findByName(member.getName())
		.ifPresent(m ->{ throw new IllegalStateException("�̹� �����ϴ� ȸ���Դϴ�.");});
	}
	
	/**
	 * ��ü ȸ�� ��ȸ
	 */
	
	public List<Member> findMembers() {
		
		return memberRepository.findAll();
	
		
	}
	
	public Optional <Member> findOne(Long memberId) {
		return memberRepository.findById(memberId);
	}

}
