---
layout: frontcover
transition: none
title: IDP - POO
id: aula010
lesson: Projeto Java simples com classe `App`
goals:
  - Revisar a estrutura mínima de um projeto Java sem build tool
  - Compilar e executar o programa `App`
  - Introduzir boas práticas de organização de código-fonte
---

---
layout: default
lesson: Estrutura do projeto
---

## Organização dos arquivos

- Exemplo disponível em `lectures/examples/01-0-hello-java`
- Pasta `src` contém o arquivo `App.java`
- Projeto sem Maven/Gradle: compilação direta com `javac`
- Ótimo ponto de partida para entender o ciclo compilar-executar
- Convenções: pacotes opcionais aqui, mas recomendável usar `package` para modularização

---

## Código principal

```java
// lectures/examples/01-0-hello-java/src/App.java
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
```

- Compilar: `javac -d out src/App.java`
- Executar: `java -cp out App`
- Use `-d` para gerar a pasta com bytecode organizado por pacote
- `throws Exception` na assinatura sinaliza que exceções não tratadas serão propagadas
- JVM busca a classe inicial dentro do classpath e invoca `main`

---

## Boas práticas iniciais

- Nome do arquivo deve coincidir com a classe pública
- Organize o bytecode em uma pasta separada (`out`, `build`, etc.)
- Configure variáveis de ambiente `JAVA_HOME` e `PATH`
- Documente comandos no README do projeto para facilitar a reprodução
- Utilize pacotes (`package br.edu...`) para evitar colisão de nomes à medida que o projeto cresce
- Convenções de nomenclatura: classes em PascalCase, métodos/variáveis em camelCase

---
layout: backcover
---
