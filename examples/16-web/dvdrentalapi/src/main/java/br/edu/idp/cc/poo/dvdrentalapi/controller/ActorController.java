package br.edu.idp.cc.poo.dvdrentalapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.idp.cc.poo.dvdrentalapi.model.Actor;
import br.edu.idp.cc.poo.dvdrentalapi.repository.ActorRepository;

@RestController
public class ActorController {

    private final ActorRepository actorRepository;

    ActorController(ActorRepository actorRepository){
        this.actorRepository = actorRepository;
    }

    @GetMapping("/actors")
    public List<Actor> all(){
        return this.actorRepository.findAll();
    }
}
