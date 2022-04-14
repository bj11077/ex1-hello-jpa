package hellojpa;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        //Collections 라고 이해하면됨 객체 대신저장해줌  사용하고버려라 쓰레드간 공유하지마
        EntityManager em = emf.createEntityManager();

//------------------------------ 한사이클
        // 트랜잭션을 얻어야 동작가능
        EntityTransaction tx = em.getTransaction();
        //이제 시작함
        tx.begin();
        try {
            // insert
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("HelloB");
//            em.persist(member);

            // update    select로 가져온걸 물고있어서 따로 update하지않아도 업데이트가된다
//            Member findMmeber = em.find(Member.class,1L);
//            findMmeber.setName("HelloJPA");

            // JPQL   대상이 테이블이 아닌 객체로 따짐    엔티티를 지정
            // jpql은 엔티티 객체 대상으로함
            // sql은 테이블을 대상으로함
//            List<Member> result = em.createQuery("select m from Member as m",Member.class)
//                    .setFirstResult(5)  // 페이징도 간단하게가능
//                    .setMaxResults(8)
//                    .getResultList();
//            for(Member member :result){
//                System.out.println("member.name = "+ member.getName());
//            }

//            //비영속
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPAA");
//
//            //영속
//            System.out.println("=== BEFORE ===");
//            em.persist(member);
//            System.out.println("=== AFTER ===");

            // 같은값인지 확인
//            Member findMember1 = em.find(Member.class, 101L);
//            Member findMember2= em.find(Member.class, 101L);
//
//
//            System.out.println("member1 = " + findMember1.getName());
//            System.out.println("member2 = " + findMember2.getName());
//            System.out.println("result = " + (findMember1 == findMember2));

//             쿼리 언제날라가는지
//            Member member1 = new Member(150L,"A");
//            Member member2 = new Member(160L,"B");
//
//            em.persist(member1);
//            em.persist(member2);
//
//            System.out.println("===================이거후에 쿼리 날라감");


//            // 수정하기
//            Member member = em.find(Member.class,150L);
//            member.setName("ZZZZZ");
//            // em.persist()를 쓸필요가없음 collection 자체를 만져서 지가 업데이트함
//            System.out.println("===========");


//            // 수정하기
//            Member member = new Member(200L, "member200")
//            em.persist(member);
//
//            //이러면 강제로 날라감
//            System.out.println("===========");

//            // 수정하기
//            Member member = em.find(Member.class, 150L);
//            member.setName("AAAAA");
//
//            // detach쓰면 관리하지말라고해서 inert일단안함 , 특정 엔티티만 준영속만듬
//            em.detach(member);
//
//            // 영속성 컨텍스트 완전지워버림
//            em.clear();
//
//            //영속성 컨텍스트 종료
//            em.close();
//
//            //이러면 강제로 날라감
//            System.out.println("===========");

//            Member member = new Member();
//            member.setUsername("C");
//            em.persist(member);


            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.setTeam(team);
            em.persist(member);


            Member findMember = em.find(Member.class, member.getId());

            Team findTeam = findMember.getTeam();
            System.out.println("findTeam = "+ findTeam.getName());

            //커밋함   이때 날라감
            tx.commit();
       }catch (Exception e){
            tx.rollback();
        }finally {
            //code
            em.close();
        }
//---------------------------------------
        emf.close();
    }
}
