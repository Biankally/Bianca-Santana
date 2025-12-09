---
layout: frontcover
transition: none
title: IDP - POO
id: aula012
lesson: Aplicação desktop com JavaFX
goals:
  - Executar uma aplicação JavaFX simples
  - Identificar o ciclo de vida `Application.start`
  - Manipular `Scene` e `Stage`
---

---
layout: default
lesson: JavaFX básico
---

## Estrutura do exemplo

- Projeto em `lectures/examples/01-2-hello-javafx`
- Classes principais:
  - `HelloStudentUI`: estende `javafx.application.Application`
  - `App`: classe de inicialização
- Exibe uma janela 640x480 com mensagem dinâmica
- JavaFX utiliza um grafo de cena composto por nós (`Scene`, `Parent`, `Node`)
- `Stage` representa a janela nativa gerenciada pelo toolkit

---

## Classe principal

```java
// lectures/examples/01-2-hello-javafx/src/HelloStudentUI.java
public class HelloStudentUI extends Application {

    @Override
    public void start(Stage stage) {
        String javafxVersion = System.getProperty("javafx.version");
        String javaVersion = System.getProperty("java.version");
        Label label = new Label("Hello, JavaFX " + javafxVersion +
            ", running on Java " + javaVersion + ".");
        Scene scene = new Scene(new StackPane(label), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
```

- `launch()` dispara o ciclo de vida JavaFX
- `Stage` é a janela; `Scene` representa o conteúdo
- `StackPane` é um contêiner que empilha filhos centralizados
- `Label` é um controle de exibição somente leitura

---

## Dicas para executar

- Certifique-se de ter as libs JavaFX configuradas (`--module-path` e `--add-modules`)
- Em IDEs, associe o SDK JavaFX nas configurações do projeto
- Logs no console ajudam a depurar (`System.out.println`)
- Para distribuir, empacote com `jlink` ou `jpackage`
- Ciclo de vida: `init()` (opcional) -> `start()` -> interação -> `stop()`
- CSS e FXML podem ser usados para separar estilo e layout

---
layout: backcover
---
