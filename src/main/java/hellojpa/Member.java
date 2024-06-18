package hellojpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity // 필수
//@Table(name = "USER") // 테이블 이름 지정
public class Member {

	@Id
	private Long id;

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
