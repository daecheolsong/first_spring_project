package Spring_start.hello.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import Spring_start.hello.domain.Member;

public class JpaMemberRepository implements MemberRepository{
	
	private final EntityManager em; // springboot�� �ڵ����� ������� 
	

	public JpaMemberRepository(EntityManager em) { //injection
		this.em=em;
	}

	@Override
	public Member save(Member member) {
		em.persist(member);
		return member;
	}

	@Override
	public Optional<Member> findById(Long id) {
		Member member=em.find(Member.class, id);
		return Optional.ofNullable(member);
	}

	public List<Member> findAll() {
		 return em.createQuery("select m from Member m", Member.class) //jpgl ��ü���� query
		 .getResultList();
		 }
	
	public Optional<Member> findByName(String name) {
		 List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
		 .setParameter("name", name)
		 .getResultList();
		 return result.stream().findAny();
		 }
	

}
