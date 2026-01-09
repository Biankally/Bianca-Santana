package br.edu.idp.cc.poo.dvdrental;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;

@ApplicationScoped
public class AppInitializer {

    @Inject
    JpaActorRepository repo;

    public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {
        ActorEntity actor = new ActorEntity();
        actor.setFristName("Fabricio");
        actor.setLastName("Santana");
        repo.save(actor);
        System.out.println("Actor persisted by AppInitializer at startup");
        System.out.println("Saved actor id=" + actor.getActorId());
    }
}