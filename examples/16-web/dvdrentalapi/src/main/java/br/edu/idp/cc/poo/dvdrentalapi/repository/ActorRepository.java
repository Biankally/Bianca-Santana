package br.edu.idp.cc.poo.dvdrentalapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.edu.idp.cc.poo.dvdrentalapi.model.Actor;

@RepositoryRestResource(collectionResourceRel = "actor", path = "actor")
public interface ActorRepository extends JpaRepository<Actor, Integer> {

    List<Actor> findByLastName(@Param("name") String name);

}
