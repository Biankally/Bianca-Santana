package br.edu.idp.cc.poo.dvdrental;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class JpaActorRepository {

    @Inject
    private EntityManager em;

    @Transactional
    public ActorEntity save(ActorEntity entity) {
        if (entity.getActorId() == null) {
            em.getTransaction().begin(); // se estiver com PROVIDER JTA e container, não faça begin/commit manual
            em.persist(entity);
            em.getTransaction().commit();
            return entity;
        } else {
            em.getTransaction().begin();
            ActorEntity merged = em.merge(entity);
            em.getTransaction().commit();
            return merged;
        }
    }
}