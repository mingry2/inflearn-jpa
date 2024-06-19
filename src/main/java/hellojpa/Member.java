package hellojpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity // 필수
//@Table(name = "USER") // 테이블 이름 지정
public class Member {

	@Id
	private Long id;

	// JPA는 기본생성자가 필요함 -> 동적으로 객체를 생성해야되기 때문(리플렉션)
	public Member() {
	}

	public Member(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	//	@Column(name = "username") // DB 컬럼 네임 지정
	private String name;

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
