
- Acessar https://start.spring.io/ e gerar projeto com as seguintes parâmetros:
    * Project: Maven
    * Language: Java
    * Spring Boot: 3.5
    * Project Metadata:
        * Group: br.edu.idp.cc.poo
        * Name: dvdrentalapi
        * Description: Api para o dvd rental
        * Package Name: br.edu.idp.cc.poo.dvdrentalapi
    * Packaging: Jar
    * Java: 21
    * Dependências:
        * Rest Repositories
        * Spring Data JPA
        * PostgreSQL Driver

- Baixar e extrair o arquivo zip com a estrutura do projeto e compilar

```bash
mvn clean compile
```

- Iniciar aplicação

```bash
mvn spring-boot:run
```

- Testar api

```bash
curl http://localhost:8080
```

```bash
curl http://localhost:8080/actor
```

```bash
curl http://localhost:8080/actor/5
```

```bash
curl http://localhost:8080/actor/search
```

```bash
curl http://localhost:8080/actor/search/findByLastName?name=Santana
```

```bash
curl -i -H "Content-Type:application/json" -d '{"firstName": "Curl Fabricio", "lastName": "Curl Santana"}' http://localhost:8080/actor
```

```bash
curl -X PUT -H "Content-Type:application/json" -d '{"firstName": "Fabricio", "lastName": "Atualizado via PUT"}' http://localhost:8080/actor/5
```

```bash
curl -X PATCH -H "Content-Type:application/json" -d '{"firstName": "Fabricio Atualizado via PATCH"}' http://localhost:8080/actor/5
```

```bash
curl -X DELETE http://localhost:8080/actor/269
```