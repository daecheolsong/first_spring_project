package Spring_start.hello.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // jpa가 관리 
public class Member {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) // db에 값을 넣으면 id를 자동으로 생성
	Long id;
	//@Column(name="username") // db에 있는 columname과 mapping
	String name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
