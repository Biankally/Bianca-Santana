---
layout: frontcover
transition: none
title: IDP - POO
id: aula02a
lesson: Exploração interativa de tipos primitivos com JShell
goals:
  - Utilizar o JShell como REPL para Java
  - Experimentar literais e variáveis primitivas
  - Dominar comandos básicos do JShell
---

---
layout: default
lesson: JShell na prática
---

## Por que usar o JShell?

- Permite testar código Java sem criar arquivos `.java`
- Feedback imediato para aprender sintaxe e semântica
- Ideal para explorar tipos primitivos e operadores
- Comandos úteis descritos em `README.md`
- REPL segue ciclo *Read → Evaluate → Print → Loop*
- Ambiente mantém estado entre comandos (variáveis, métodos e classes)

---

## Literais e declarações

```text
// lectures/examples/02a-elements-primitives-jshell/01-literal.txt
jshell> int a = 0b10
jshell> System.out.println(a)
2

jshell> char letra = '\u0061'
jshell> System.out.println(letra)
a
```

- Suporte a bases decimal, octal, hexadecimal e binária
- Literais de `char` podem usar códigos Unicode
- JShell aceita `_` como separador legível em literais numéricos (`1_000_000`)

---

## Variáveis e blocos

```text
// 02-variables.txt e 03-block.txt
jshell> double altura = 1.82
jshell> { int x = 10; System.out.println(x); }
```

- Blocos delimitados por `{}` permitem testar escopo
- `/vars` lista declarações existentes; `/drop x` remove variáveis
- `/reset` limpa completamente o estado da sessão
- `jshell> /help` lista instruções rápidas de navegação

---

## Tipos primitivos

- Arquivos `Primitive*.txt` mostram exemplos de cada tipo
  - `PrimitiveInt.txt`, `PrimitiveDouble.txt`, `PrimitiveBoolean.txt`...
- Explore promoção numérica e limites (`PrimitiveWrapper.txt`)
- Combine com `/save` para registrar comandos favoritos
- Tipos primitivos ocupam tamanhos fixos em bytes (int 32-bits, double 64-bits)
- *Wrapper types* (`Integer`, `Double`) fornecem métodos utilitários e permitem uso em coleções

---
layout: backcover
---
