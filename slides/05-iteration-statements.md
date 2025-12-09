---
layout: frontcover
transition: none
title: IDP - POO
id: aula05
lesson: Estruturas de repetição e comandos de salto
goals:
  - Controlar repetições com `for`, `while` e `do-while`
  - Escolher entre contadores, sentinelas e aritmética incremental
  - Empregar `break`, `continue` e `return` conscientemente
---

---
layout: default
lesson: Utilizando laços
---

## `for`, `while` e `do-while`

- Arquivos em `lectures/examples/05-iteration-statements`
- Exemplos chave:
  - `ForCounter`, `ForSum`, `ForWithComma`, `ForNested`
  - `WhileCounter`, `WhileClassAverage*`
  - `DoWhile` e `DoWhileTest`
- Compare as condições de parada e o momento em que são avaliadas
- Laços **pré-teste** (`for`, `while`) verificam a condição antes da primeira iteração
- `do-while` garante ao menos uma execução (pós-teste)

---

## Exemplo com `for`

```java
// ForSum.java
int total = 0;
for (int number = 2; number <= 20; number += 2) {
    total += number;
}
System.out.printf("Soma dos pares: %d%n", total);
```

- Laço controlado por contador
- Atualização `number += 2` gera sequência de pares
- Excelente exercício para praticar invariantes
- Invariante de laço: `total` sempre guarda a soma dos pares já visitados
- Condição de término: `number <= 20` limita quantidade de iterações

---

## Média com sentinela

```java
// WhileClasssAverageSentinelControlled.java
while (grade != -1) {
    total += grade;
    gradeCounter++;
    grade = input.nextInt();
}
```

- Usa `-1` como sentinela para encerrar
- Importante validar entrada e evitar `ArithmeticException` na divisão por zero
- *Loop sentinel* depende de um valor especial que sinaliza término
- Diferencie entradas controladas por contador vs por condição externa

---

## Comandos de salto

- `JumpBreakLoop`, `JumpBreakLoop2`, `JumpBreakLoop3`: interrompem loops aninhados
- `JumpContinue` e `JumpContinueTest`: pulam iterações específicas
- `JumpReturn`: encerra o método a partir de um laço
- Utilize com moderação: clareza do fluxo é prioridade
- `break` sai do laço mais interno; `continue` avança para a próxima iteração
- Prefira abstrações (`methods`, `streams`) quando loops ficarem complexos

---
layout: backcover
---
