package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    //@PersistenceContext //JPA가 제공하는 표준 애노테이션
    private final EntityManager em; //스프링이 EntityManager를 만들어 인젝션 해줌

    public void save(Member member){
        em.persist(member);
    }

    public Member findOne(Long id){
        //Member member = em.find(Member.class,id);
        //위와같다
        return em.find(Member.class,id);
    }
    public List<Member> findAll(){
       return em.createQuery("select m from Member m",Member.class)
            .getResultList();
       //qlString 은 entity 객체 Member에 대해 데이터를 요청, sql은 테이블에 요청
       //Inline 단축키 Ctrl+Alt+N
    }
    public List<Member> findName(String name){
        return em.createQuery("select m from Member m where m.name =:name",Member.class)
                .setParameter("name",name)
                .getResultList();
    }
}
