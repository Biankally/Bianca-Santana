---
layout: frontcover
transition: none
title: IDP - POO
id: aula04
lesson: Estruturas de seleção (`if` e `switch`)
goals:
  - Escolher a estrutura condicional adequada para cada cenário
  - Aplicar operadores lógicos dentro de cadeias `if-else`
  - Utilizar os diferentes sabores do `switch` no Java moderno
---

---
layout: default
lesson: `if` e operadores lógicos
---

## Cadeias `if-else`

```java
// IfElse.java
if (month == 12 || month == 1 || month == 2)
    season = "Winter";
else if (month == 3 || month == 4 || month == 5)
    season = "Spring";
else
    season = "Bogus Month";
```

- Combine `||` e `&&` para expressar regras complexas
- Sempre trate o caso `else` para valores inesperados
- Considere extrair lógica para métodos auxiliares (`isSpring(month)`)
- Condicionais avaliam expressões booleanas; somente `true` executa o bloco
- Fluxogramas ajudam a visualizar caminhos de decisão e a documentar requisitos

---

## Operador ternário

```java
// IfTernary.java
int i = -10;
int k = i < 0 ? -i : i;
System.out.printf("Absolute value of %d is %d%n", i, k);
```

- Excelente para atribuições curtas
- Evite expressões ternárias muito aninhadas
- Operador ternário substitui `if-else` simples retornando um valor
- Tipo resultante é determinado pela promoção das expressões em cada ramo

---

## `switch` clássico e aprimorado

- `Switch.java`, `SwitchSample.java`: múltiplos `case` com `break`
- `SwitchMissingBreak.java`: demonstra fall-through acidental
- `SwitchMenu.java`: uso comum em menus de console
- `SwitchNew.java`: sintaxe de expressão (Java 14+)

```java
// SwitchNew.java (classe NewSwitch)
switch (i) {
    case 0 -> System.out.println("i is zero.");
    case 1 -> System.out.println("i is one.");
    case 2 -> System.out.println("i is two.");
    case 3 -> System.out.println("i is three.");
    default -> System.out.println("i is greater than 3.");
}
```

- `switch` clássico usa `break` para impedir *fall-through*
- Versão moderna suporta múltiplos rótulos por caso e blocos com `yield`

---

## Boas práticas

- Declare constantes para valores mágicos (`final int APRIL = 4;`)
- Valide entrada do usuário antes de cair na lógica condicional
- Utilize `enum` para mapear grupos de valores (`Season`)
- Teste caminhos felizes e alternativos (`OperatorLogical.java`)
- Avalie complexidade ciclomática para estimar quantidade mínima de testes
- Documente casos-limite e comportamentos esperados para inputs inválidos

---
layout: backcover
---
