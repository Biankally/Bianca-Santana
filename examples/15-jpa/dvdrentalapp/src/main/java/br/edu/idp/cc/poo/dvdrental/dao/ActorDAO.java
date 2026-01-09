package br.edu.idp.cc.poo.dvdrental.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Predicate;
import java.util.List;

import br.edu.idp.cc.poo.dvdrental.util.AuditLogger;
import br.edu.idp.cc.poo.dvdrental.model.Actor;

public class ActorDAO {

    private final EntityManager em;

    public ActorDAO(EntityManager em) {
        this.em = em;
    }

    public void insert(Actor actor) {
        em.getTransaction().begin();
        em.persist(actor);
        em.getTransaction().commit();
        AuditLogger.log("INSERT", "Ator inserido: " + actor);
    }

    public List<Actor> findAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Actor> cq = cb.createQuery(Actor.class);
        Root<Actor> root = cq.from(Actor.class);
        cq.select(root).orderBy(cb.asc(root.get("actorId")));
        return em.createQuery(cq).getResultList();
    }

    public Actor findById(int id) {
        return em.find(Actor.class, id);
    }

    public List<Actor> findByName(String name) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Actor> cq = cb.createQuery(Actor.class);
        Root<Actor> root = cq.from(Actor.class);

        Predicate firstNameLike = cb.like(root.get("firstName"), "%" + name + "%");
        Predicate lastNameLike = cb.like(root.get("lastName"), "%" + name + "%");
        cq.select(root).where(cb.or(firstNameLike, lastNameLike));

        return em.createQuery(cq).getResultList();
    }

    public void update(Actor actor) {
        em.getTransaction().begin();
        em.merge(actor);
        em.getTransaction().commit();
        AuditLogger.log("UPDATE", "Ator atualizado: " + actor);
    }

    public void delete(int id) {
        Actor actor = em.find(Actor.class, id);
        if (actor != null) {
            em.getTransaction().begin();
            em.remove(actor);
            em.getTransaction().commit();
            AuditLogger.log("DELETE", "Ator removido: " + actor);
        }
    }
}
