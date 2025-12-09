## Coleções Genéricas em Java (Java Generic Collections)

### Introdução às Coleções em Java

```
Explique o que são coleções e por que são úteis, respondendo detalhadamente as questões abaixo:

1. O que são coleções em Java? Por que usamos coleções ao invés de arrays tradicionais?
2. Quais são as principais interfaces da hierarquia de coleções em Java (`List`, `Set`, `Map`)?
3. Crie um exemplo simples que use `ArrayList` para armazenar nomes de alunos.
4. Quais são as vantagens e limitações do uso de coleções?
```

### Manipulação de Arrays com a classe `Arrays`

```
Explique como utilizar a classe `java.util.Arrays`, abordando detalhadamente os seguintes pontos:

1. O que é a classe `Arrays` e como ela auxilia na manipulação de arrays?
2. Dê exemplos do uso dos métodos `sort`, `fill`, `copyOf` e `binarySearch`.
3. Qual é a diferença entre `Arrays.equals()` e `==` ao comparar arrays?
```

### Wrapper Classes

```
Apresente as classes wrapper de tipos primitivos, apresentando detalhadamente informações para os seguintes itens:

1. O que são as classes wrapper (`Integer`, `Double`, `Boolean`, etc)? Por que elas são necessárias?
2. Mostre um exemplo de como transformar um valor primitivo em objeto (`int` → `Integer`) e vice-versa.
3. Crie um programa que receba valores como `int` e armazene em uma `ArrayList<Integer>`.
```

### Autoboxing e Unboxing

```
Explique como Java trata automaticamente conversões entre primitivos e objetos wrapper.

1. O que é autoboxing? O que é unboxing? Quando ocorrem?
2. Mostre um exemplo com `List<Double>` onde o compilador faz autoboxing automaticamente.
3. Quais problemas podem ocorrer com unboxing automático? Dê um exemplo.
```

### Uso de Estruturas de Dados Genéricas

```
Explique como Aplicar estruturas do Java Collections Framework com generics.

1. O que são generics em Java? Por que são importantes nas coleções?
2. Crie uma `HashSet<String>` e insira alguns nomes. Por que `Set` não permite elementos duplicados?
3. Compare `ArrayList`, `LinkedList`, `HashSet`, `TreeSet` e `HashMap` com exemplos de uso simples.
```

### Algoritmos da classe `Collections`

```
Explique os principais métodos utilitários da classe `Collections`.

1. O que é a classe `Collections` e qual sua função?
2. Mostre exemplos dos métodos `sort`, `reverse`, `shuffle`, `max` e `min`.
3. Crie um programa que embaralhe uma lista de palavras e as ordene novamente.
```

### Iteradores e Navegação em Coleções

```
Demonstre como utilizar `Iterator` e `ListIterator` para percorrer coleções e apresente detalhadamente informações para os seguintes tópicos:

1. O que é um `Iterator` e por que ele é usado?
2. Crie um programa que percorra uma `List<Integer>` com `Iterator`, imprimindo apenas os valores pares.
3. O que diferencia `ListIterator` de `Iterator`? Mostre um exemplo com `ListIterator`.
```

### Wrappers de Sincronização e Imutabilidade

```
Demonstre como usar coleções seguras e imutáveis.

1. O que é uma coleção sincronizada? Quando e por que usá-la?
2. Mostre como criar uma `List` sincronizada com `Collections.synchronizedList(...)`.
3. O que são coleções imutáveis? Crie exemplos com `Collections.unmodifiableList(...)`.
```

### Fábricas de Coleções Imutáveis no Java 9+

```
Demostre como utilizar os métodos fábrica do Java 9 para criar listas, conjuntos e mapas imutáveis.

1. Quais são os novos métodos `List.of()`, `Set.of()` e `Map.of()` introduzidos no Java 9?
2. Crie exemplos práticos de `List`, `Set` e `Map` usando esses métodos.
3. Compare essas abordagens com `Arrays.asList()` e `Collections.unmodifiableList()`.
```

### Projeto Prático

```
Consolide os conceitos apresentando um projeto real.

1. Desenvolva um programa que armazene notas de alunos em diferentes turmas usando um `Map<String, List<Double>>`.
2. Implemente funcionalidades como:
   * Inserir notas
   * Calcular média por aluno
   * Listar alunos com média maior que 7
   * Ordenar os alunos por média
3. Use iteradores, métodos da classe `Collections`, e boas práticas com generics.
```