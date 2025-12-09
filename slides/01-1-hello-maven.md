---
layout: frontcover
transition: none
title: IDP - POO
id: aula011
lesson: Gerenciando um projeto Java com Maven
goals:
  - Reconhecer a estrutura `src/main/java` e `src/test/java`
  - Configurar o `pom.xml` para compilar com Java 21
  - Executar ciclo completo `mvn clean package`
---

---
layout: default
lesson: Estrutura Maven
---

## Como o Maven organiza o projeto?

- `lectures/examples/01-1-hello-maven`
- Diretórios padrão:
  - `src/main/java`: código de produção
  - `src/test/java`: testes
  - `pom.xml`: metadados do projeto e dependências
- Build padrão gera `target/hello-maven-1.0-SNAPSHOT.jar`
- Coordenadas Maven (`groupId:artifactId:version`) identificam o artefato
- Ciclo de vida padrão: `validate -> compile -> test -> package -> verify -> install -> deploy`

---

## Código principal

```java
// lectures/examples/01-1-hello-maven/src/main/java/br/edu/idp/cc/poo/App.java
package br.edu.idp.cc.poo;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
```

- Empacotado dentro de um pacote (`package br.edu.idp.cc.poo`)
- Classe `App` definida como entry point (`main`)

---

## Configurações essenciais do `pom.xml`

```xml
<properties>
  <maven.compiler.source>21</maven.compiler.source>
  <maven.compiler.release>21</maven.compiler.release>
</properties>

<dependencies>
  <dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.11</version>
    <scope>test</scope>
  </dependency>
</dependencies>
```

- Propriedades garantem compilação com Java 21
- Dependência `junit` disponível apenas na fase de teste
- Plugins seguem o mesmo esquema de coordenadas
- `maven-compiler-plugin` ajusta versão do bytecode emitido

---

## Executando o projeto

- Compilar: `mvn compile`
- Rodar testes: `mvn test`
- Criar JAR: `mvn package`
- Executar entry point pelo plugin:
  - `mvn exec:java -Dexec.mainClass=br.edu.idp.cc.poo.App`
- Goals podem ser encadeados (`mvn clean package`)
- Profiles permitem variar dependências/configurações por ambiente

---

## Conceitos fundamentais

- **Model POM**: arquivo XML que descreve dependências, build e metadata
- **Repositório local** (`~/.m2/repository`): cacheia artefatos baixados
- **Scopes** (`compile`, `test`, `runtime`) controlam visibilidade das dependências
- **Plugins** estendem o Maven executando tarefas durante os ciclos de vida

---
layout: backcover
---
