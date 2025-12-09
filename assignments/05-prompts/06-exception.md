# Tratamento de Exceções em Java

## Fundamentos e Motivação

* Contextualize o conceito de exceção em Java, mostrando por que o tratamento estruturado evita que o programa termine abruptamente.
* Construa um exemplo simples que cause uma `ArithmeticException` (divisão por zero) sem tratamento e descreva o que aparece no console.
* Liste três situações reais em que exceções podem ocorrer em tempo de execução e explique como o tratamento protege a aplicação.
* Compare os impactos de deixar a exceção interromper o programa versus tratá-la com uma mensagem amigável ao usuário.

---

## Delimitando Código com `try`

* Descreva a finalidade do bloco `try` e como ele delimita um trecho suscetível a falhas.
* Implemente um exemplo que usa `Scanner` para ler dois números, realiza a divisão dentro de `try` e descreva o fluxo linha a linha.
* Mostre o que acontece com o fluxo de execução quando a exceção é disparada dentro do `try` e não existe um tratamento apropriado.

---

## Capturando Erros com `catch`

* Explique por que um bloco `catch` deve declarar explicitamente o tipo de exceção que deseja capturar.
* Escreva um programa que trate `ArithmeticException` (divisão por zero) e `InputMismatchException` na leitura de dados, usando dois blocos `catch` em ordem correta.
* Discuta o que ocorre quando não existe um `catch` compatível e como a ordem dos blocos influencia o tratamento.
* Exemplifique as mensagens exibidas ao usuário em cada cenário tratado.

---

## Lançando Exceções com `throw`

* Defina o que significa lançar uma exceção manualmente com `throw` e diferencie de deixar a JVM lançar automaticamente.
* Implemente um método `validarIdade(int idade)` que lança `IllegalArgumentException` quando recebe valores negativos.
* Demonstre um `main` que chama o método anterior com valores válidos e inválidos, explicando o comportamento observado.
* Esclareça a diferença entre `throw` e `throws` na assinatura de métodos.

---

## Quando Tratar ou Prevenir Erros

* Analise critérios para decidir entre tratar uma exceção ou prevenir o erro por validação antecipada.
* Apresente um cenário inevitável (como leitura de dados fornecidos pelo usuário) em que tratar a exceção é a melhor estratégia.
* Mostre um caso em que uma validação simples evita a necessidade de tratamento de exceção (por exemplo, verificar divisor zero antes da operação).
* Diferencie controle de fluxo (decisões previstas) de tratamento de falhas inesperadas.

---

## Hierarquia de Exceções

* Explique a hierarquia principal de exceções em Java, destacando `Throwable`, `Exception`, `RuntimeException` e `Error`.
* Construa um diagrama textual simples dessa hierarquia e associe exemplos a cada nível (ex.: `IOException`, `NullPointerException`, `OutOfMemoryError`).
* Diferencie exceções checadas das não checadas e argumente por que essa distinção influencia a assinatura dos métodos.

---

## Garantindo Limpeza com `finally`

* Descreva o objetivo do bloco `finally` e quando ele é executado.
* Implemente um exemplo que use `Scanner` para ler dados, feche o recurso dentro do `finally` e comente o comportamento quando ocorre ou não uma exceção.
* Explique situações práticas em que liberar recursos no `finally` é essencial, mesmo com retornos antecipados dentro do `try` ou `catch`.

---

## Encadeamento de Exceções

* Defina encadeamento de exceções e explique por que preservar a causa original ajuda na depuração.
* Crie um método que ao converter texto em número capture `NumberFormatException` e lance `IllegalArgumentException`, anexando a causa original.
* Demonstre como imprimir o stack trace completo, destacando a cadeia de causas.

---

## Exceções Personalizadas

* Justifique quando faz sentido criar uma exceção específica em vez de reutilizar uma existente.
* Desenvolva a classe `SaldoInsuficienteException` (checada ou não checada) e explique a decisão.
* Implemente um método `sacar(double valor)` que lança a nova exceção quando o saldo é insuficiente e mostre o tratamento em outro ponto do código.
* Discuta boas práticas para mensagens de erro que auxiliem o usuário e o desenvolvedor durante a correção.

---

## Uso de `try-with-resources`

* Explique o recurso `try-with-resources`, destacando a necessidade de implementar `AutoCloseable`.
* Escreva um exemplo com `Scanner` (ou outro recurso simples) que mostre a sintaxe do `try-with-resources` e comente cada linha.
* Compare a abordagem com o uso de `try` + `finally`, ressaltando vantagens e limitações.

---
