---
layout: frontcover
transition: none
title: IDP - POO
id: aula014
lesson: API REST com Spring Boot
goals:
  - Inicializar uma aplicação Spring Boot
  - Expor endpoints HTTP com `@RestController`
  - Testar rotas usando parâmetros de requisição
---

---
layout: default
lesson: Estrutura Spring Boot
---

## Projeto gerado

- Caminho: `lectures/examples/01-4-hello-spingboot`
- Arquivo principal: `HelloSpingbootApplication.java`
- `pom.xml` traz dependências básicas do Spring Boot
- `application.properties` configurado com valores padrão
- `SpringApplication.run` inicializa o contexto IoC e embute o servidor Tomcat
- Starter `spring-boot-starter-web` inclui MVC, JSON (Jackson) e validação básica

---

## Classe principal e endpoints

```java
// lectures/examples/01-4-hello-spingboot/.../HelloSpingbootApplication.java
@SpringBootApplication
@RestController
public class HelloSpingbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloSpingbootApplication.class, args);
    }

    @GetMapping("/")
    public String home() {
        return "Spring Boot is up and runnig!";
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
}
```

- `@SpringBootApplication`: marca ponto de entrada
- `@RestController`: registra endpoints REST
- `@RequestParam`: injeta parâmetro da query string
- Endpoints REST retornam diretamente representações (por padrão JSON ou String)
- `@SpringBootApplication` combina `@Configuration`, `@EnableAutoConfiguration` e `@ComponentScan`

---

## Executando e testando

- Rodar aplicação: `./mvnw spring-boot:run`
- Testar endpoints:
  - `curl http://localhost:8080/`
  - `curl "http://localhost:8080/hello?name=POO"`
- Teste automatizado em `HelloSpingbootApplicationTests.java`
- Exploradores HTTP (Insomnia, Postman) ajudam a validar respostas
- Use `spring-boot-devtools` para recarregar a aplicação durante o desenvolvimento
- Conceitos REST: recursos identificados por URI, verbos HTTP (`GET`, `POST`, ...), status codes

---
layout: backcover
---
