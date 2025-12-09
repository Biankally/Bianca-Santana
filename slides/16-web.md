---
layout: frontcover
transition: none
title: IDP - POO
id: aula16
lesson: API REST com Spring Boot e JPA
goals:
  - Expor endpoints REST usando `@RestController`
  - Utilizar Spring Data JPA para acesso a dados
  - Configurar a aplicação via `application.properties`
---

---
layout: default
lesson: Estrutura do projeto
---

## Componentes principais

- Diretório: `lectures/examples/16-web/dvdrentalapi`
- Classes principais:
- `DvdrentalapiApplication`: ponto de entrada Spring Boot
- `Actor` (entidade JPA)
- `ActorRepository`: interface `JpaRepository`
- `ActorController`: expõe endpoint `/actors`
- `application.properties.sample` configura datasource PostgreSQL
- Arquitetura comum: Controller -> Service -> Repository -> Banco
- API REST segue princípios de recursos, verbos HTTP e representações padronizadas

---

## Controlador REST

```java
// ActorController.java
@RestController
public class ActorController {

    private final ActorRepository actorRepository;

    ActorController(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @GetMapping("/actors")
    public List<Actor> all() {
        return this.actorRepository.findAll();
    }
}
```

- Injeção de dependências via construtor
- `@GetMapping` mapeia requisições GET
- Retorna lista serializada em JSON automaticamente
- Spring usa Jackson para serializar/deserializar objetos Java ↔ JSON
- Controle de erros pode ser feito com `@ControllerAdvice` e `ResponseEntity`

---

## Spring Data JPA

```java
// ActorRepository.java
@RepositoryRestResource(collectionResourceRel = "actor", path = "actor")
public interface ActorRepository extends JpaRepository<Actor, Integer> {
    List<Actor> findByLastName(@Param("name") String name);
}
```

- `JpaRepository` fornece CRUD básico
- Consulta derivada (`findByLastName`) gera SQL automaticamente
- `@RepositoryRestResource` ainda expõe endpoints HAL prontos
- Métodos derivados entendem sufixos como `Containing`, `OrderBy`, `Top`
- Repositórios Spring Data são *interfaces*; implementação gerada em tempo de execução

---

## Executando

- Copie `application.properties.sample` para `application.properties`
- Ajuste `spring.datasource.*` apontando para o banco (`docker-compose` do JDBC ajuda)
- Rodar aplicação: `./mvnw spring-boot:run`
- Testar endpoint: `curl http://localhost:8080/actors`
- Explore `RepositoryRestResource` em `http://localhost:8080/actor`
- Utilize `Spring Boot Devtools` ou `spring-boot:run -Dspring-boot.run.profiles=dev`
- Documente a API com OpenAPI/Swagger para facilitar consumo

---
layout: backcover
---
