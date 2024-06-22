//package hellojpa;
//
//import jakarta.persistence.*;
//
//public class JpaMainV1 {
//
//    public static void main(String[] args) {
//
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
//        EntityManager em = emf.createEntityManager();
//
//        // 트랜잭션 시작
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
//
//        try {
//            /*
//            // 비영속
//            Member member = new Member();
//            member.setId(3L);
//            member.setName("HelloB");
//
//            // 영속
//            em.persist(member);
//
//            // 영속성 컨텍스트 1차 캐시에 보관
//            Member findMember = em.find(Member.class, 3L);
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getName());
//            */
//
//            /*
//            // 동일성 보장 - 1차 캐시 덕분
//            Member findMember1 = em.find(Member.class, 3L);
//            Member findMember2 = em.find(Member.class, 3L);
//            System.out.println("result = " + (findMember1 == findMember2));
//            */
//
//            /*
//            // 트랜잭션을 지원하는 쓰기 지연
//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");
//            // 쓰기 지연 SQL 저장소에 쌓임
//            em.persist(member1);
//            em.persist(member2);
//            System.out.println("=== 쓰기 지연 SQL 저장소");
//            // 쿼리
//            */
//
//            /*
//            // 엔티티 수정
//            Member member = em.find(Member.class, 150L);
//            member.setName("수정수정");
//            System.out.println("=== 엔티티 수정");
//            */
//
//            tx.commit();
//        } catch (Exception e) {
//            tx.rollback();
//        } finally {
//            em.close();
//        }
//
//        emf.close();
//    }
//}
