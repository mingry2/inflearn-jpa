package hellojpa;

import jakarta.persistence.*;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        // 트랜잭션 시작
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            /* 저장
            Member member = new Member();
            member.setId(2L);
            member.setName("HelloB");
            em.persist(member); // 저장
             */
            Member findMember = em.find(Member.class, 1L); // 조회
            System.out.println("findMember.id = " + findMember.getId());
            System.out.println("findMember.name = " + findMember.getName());

            /*
            Member 전체 조회 - JQUERY 사용(객체 지향 쿼리 언어)
            테이블이 아닌 엔티티 객체를 대상으로 쿼리
             */
            List<Member> members = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(1) // offset
                    .setMaxResults(10) // fetch
                    .getResultList();
            for (Member member : members) {
                System.out.println("member.name = " + member.getName());
            }

            /*
            수정
            persist() 하지 않아도 저장됨
            jpa 가 관리해주기 때문에 변경된 부분을 확인해서 update 처리
             */
            findMember.setName("HelloJPA");
            System.out.println("findMember.id = " + findMember.getId());
            System.out.println("findMember.name = " + findMember.getName());

            // em.remove(findMember); // 삭제

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
