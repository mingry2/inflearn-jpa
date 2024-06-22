//package hellojpa;
//
//import jakarta.persistence.*;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.Date;
//
//@Entity // 필수
////@Table(name = "USER") // 테이블 이름 지정
//public class MemberV1 {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//
//	@Column(name = "name", nullable = false, length = 10)
//	private String username;
//
//	private Integer age11;
//
//	@Enumerated(EnumType.STRING) // db에는 enum 타입이 없음 이 때, @Enumerated 애노테이션 사용
//	private RoleType roleType;
//
//	@Temporal(TemporalType.TIMESTAMP) // DATE-날짜, TIME-시간, TIMESTAMP-날짜&시간
//	private Date createdDate;
//
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date lastModifiedDate;
//
//	// java8 부터 LocalDate, LocalDateTime 사용 시 @Temporal 생략가능
//	private LocalDate testLocalDate;
//	private LocalDateTime testLocalDateTime;
//
//	@Lob // 큰 데이터를 사용할 때
//	private String description;
//
//	@Transient // DB에서 사용안하고 싶을 경우
//	private int temp;
//
//	public MemberV1() {
//	}
//}
