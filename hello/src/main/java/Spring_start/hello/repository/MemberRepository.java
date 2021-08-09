package Spring_start.hello.repository;

import java.util.List;
import java.util.Optional;

import Spring_start.hello.domain.Member;

public interface MemberRepository {
	
	Member save(Member member);
	Optional<Member> findById(Long id);
	Optional<Member> findByName(String name);
	List<Member> findAll();

	
}
