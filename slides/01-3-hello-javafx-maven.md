---
layout: frontcover
transition: none
title: IDP - POO
id: aula013
lesson: JavaFX modularizado com Maven
goals:
  - Empacotar uma aplicação JavaFX usando Maven
  - Entender a configuração modular (`module-info.java`)
  - Navegar entre telas com controladores FXML
---

---
layout: default
lesson: Estrutura modular
---

## Projeto completo

- Local: `lectures/examples/01-3-hello-javafx-maven`
- Estrutura Maven padrão (`src/main/java`, `src/main/resources`)
- `module-info.java` declara dependências e exportações
- Controladores FXML separados por tela (`PrimaryController`, `SecondaryController`)
- `FXMLLoader` carrega descrições de interface declarativas (`*.fxml`)
- `resources` compartilha assets (FXML, imagens, CSS) empacotados no JAR

---

## Configuração do módulo

```java
// module-info.java
module br.edu.idp.cc.poo {
    requires javafx.controls;
    requires javafx.fxml;

    opens br.edu.idp.cc.poo to javafx.fxml;
    exports br.edu.idp.cc.poo;
}
```

- `requires` expõe bibliotecas JavaFX
- `opens` permite injeção do FXMLLoader
- `exports` disponibiliza o pacote para consumo externo
- Módulos Java (JPMS) evitam dependências implícitas entre pacotes
- Necessário usar `--module-path` ao executar projetos modularizados

---

## Controladores FXML

```java
// PrimaryController.java
@FXML
private void switchToSecondary() throws IOException {
    App.setRoot("secondary");
}
```

```java
// SecondaryController.java
@FXML
private void switchToPrimary() throws IOException {
    App.setRoot("primary");
}
```

- Cada botão define o `onAction` no arquivo `.fxml`
- `App.setRoot` troca o layout visível sem recriar o `Stage`
- Controladores são instanciados pelo JavaFX e anotados com `@FXML`
- Separação `MVC`: FXML (view), controller (interação), modelo (estado)

---

## Como executar

- Instale dependências: `mvn clean install`
- Rode a aplicação: `mvn javafx:run`
- Certifique-se de usar o plugin `org.openjfx:javafx-maven-plugin`
- Empacote para distribuição com `mvn package`
- Configure o plugin para adicionar parâmetros de VM se necessário (`jvmArgs`)
- Use profiles para alternar entre ambientes (dev vs prod)

---
layout: backcover
---
