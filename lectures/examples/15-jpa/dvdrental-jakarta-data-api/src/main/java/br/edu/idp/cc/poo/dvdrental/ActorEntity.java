package br.edu.idp.cc.poo.dvdrental;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ActorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id")
    private Long actorId;

    @Column(name = "frist_name")
    private String fristName;

    @Column(name = "last_name")
    private String lastName;
    
    public void setActorId(long actorId) {
        this.actorId = actorId;
    }
    public void setFristName(String fristName) {
        this.fristName = fristName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Long getActorId() {
        return actorId;
    }
    public String getFristName() {
        return fristName;
    }
    public String getLastName() {
        return lastName;
    }
    
}
