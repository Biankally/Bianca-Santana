package br.edu.idp.cc.poo.dvdrental;

import java.sql.SQLException;
import java.util.List;

import br.edu.idp.cc.poo.dvdrental.dao.ActorDAO;
import br.edu.idp.cc.poo.dvdrental.model.Actor;

public class Main {
   public static void main(String[] args) throws SQLException {
        ActorDAO dao = new ActorDAO();

        System.out.println("Inserindo ator...");
        Actor novo = new Actor("Joao", "Silva");
        dao.insert(novo);

        System.out.println("Listando todos os atores:");
        List<Actor> actorList = dao.findAll();
        for (Actor a : actorList) System.out.println(a.toString());

        System.out.println("Buscando por nome:");
        List<Actor> actorListByName = dao.findByName("Joao");
        for (Actor a : actorListByName) System.out.println(a.toString());

        System.out.println("Atualizando ator:");
        Actor atorAtualizado = dao.findByName("Joao").get(0);
        atorAtualizado.setLastName("Souza");
        dao.update(atorAtualizado);

        System.out.println("Removendo ator:");
        dao.delete(atorAtualizado.getActorId());
    }
}