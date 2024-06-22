package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.lang.reflect.Member;
import java.util.List;

public class JpaMainV2 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            //저장
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            MemberV2 member = new MemberV2();
            member.setName("member1");
//            member.setTeam(team);//추가 - 순수 객체 상태를 고려하여 양쪽에 값을 추가하자.
            member.changeTeam(team); // 연관관계 편의 메소드를 사용하여 실수하지 않게 setter에 값을 넣어주는 코드를 구현
            em.persist(member);

            team.getMembers().add(member); //추가 - 순수 객체 상태를 고려하여 양쪽에 값을 추가하자.

            em.flush();
            em.clear();

//            MemberV2 findMember = em.find(MemberV2.class, member.getId());
//
//            //양방향 매핑
//            List<MemberV2> members = findMember.getTeam().getMembers();
//            for (MemberV2 m : members) {
//                System.out.println("m = " + m.getName());
//            }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
