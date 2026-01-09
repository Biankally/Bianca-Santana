package br.edu.idp.cc.poo.dvdrental;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.edu.idp.cc.poo.dvdrental.model.Actor;
import br.edu.idp.cc.poo.dvdrental.repository.ActorRepository;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner init(ActorRepository repository) {
        return args -> {
            Actor actorSaved = repository.save(new Actor("Joao", "Silva"));

            List<Actor> all = repository.findAll();
            
            for (Actor a : all){
                System.out.println(a);
            }

            System.out.println("Buscando por nome:");
            Optional<Actor> actorFound = repository.findById(actorSaved.getActorId());
            //findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase("joao", "Silva");

            if (actorFound.isPresent()) {
                Actor actor = actorFound.get();
                System.out.println(actor);
                actor.setFirstName("Fabricio");
                actor.setLastName("Santana");
                repository.save(actor);
                repository.delete(actor);
            }
        };
    }
}