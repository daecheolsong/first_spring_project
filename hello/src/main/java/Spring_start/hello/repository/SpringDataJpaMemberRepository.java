package Spring_start.hello.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Spring_start.hello.domain.Member;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long> , MemberRepository{
	
	// JPQL select m from Member m where m.name = ?
	Optional<Member> findByName(String name);
	

}
