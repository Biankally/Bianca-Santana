package br.edu.idp.cc.poo.dvdrental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.idp.cc.poo.dvdrental.model.Actor;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
    List<Actor> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String firstName, String lastName);

}
