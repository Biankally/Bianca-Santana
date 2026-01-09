package br.edu.idp.cc.poo.dvdrental;

import java.util.List;

import br.edu.idp.cc.poo.dvdrental.dao.ActorDAO;
import br.edu.idp.cc.poo.dvdrental.model.Actor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dvdrentalPU");
        EntityManager em = emf.createEntityManager();

        ActorDAO dao = new ActorDAO(em);

        Actor novo = new Actor("Joao", "Silva");
        dao.insert(novo);

        List<Actor> allActors = dao.findAll();

        for (Actor a : allActors){
            System.out.println(a);
        }

        System.out.println("Buscando por nome:");
        var encontrados = dao.findByName("Joao");
        
        for (Actor a : encontrados){
            System.out.println(a);
        }

        System.out.println("Atualizando...");
        Actor ator = encontrados.get(0);
        ator.setLastName("Souza");
        dao.update(ator);

        System.out.println("Removendo...");
        dao.delete(ator.getActorId());

        em.close();
        emf.close();
    }
}
