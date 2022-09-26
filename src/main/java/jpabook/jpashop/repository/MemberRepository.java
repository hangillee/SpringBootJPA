package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final EntityManager em;

    public void save(Member member) {
        em.persist(member); //INSERT
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id); //SELECT
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class) //SELECT
                .getResultList();
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class) //SELECT WHERE
                .setParameter("name", name)
                .getResultList();
    }
}
