# Elementos Básicos da Linguagem Java

## Literais e Identificadores

* Explique o que são literais em Java (numéricos, caracteres, booleanos, strings e null) e forneça exemplos de utilização em programas reais.
* Diferencie literais numéricos inteiros e de ponto flutuante, mostrando quando usar sufixos (`L`, `F`, `D`) e como os separadores `_` ajudam na legibilidade.
* Descreva as regras para formar identificadores válidos e identifique erros comuns ao nomear classes, métodos e variáveis em Java.
* Destaque todos os literais e identificadores incorretos em trechos de código e proponha correções.
* Simule um processo de refatoração que renomeie identificadores ambíguos seguindo convenções como `camelCase` e `PascalCase`, justificando cada mudança.
* Discuta de que maneira a escolha adequada de literais e identificadores aumenta a legibilidade e reduz ambiguidade em bases de código Java colaborativas?

---

## Separadores e Palavras-chave

* Liste os principais separadores de Java (`{}`, `[]`, `()`, `;`, `,`, `@`) e explique sua função em diferentes estruturas da linguagem.
* Diferencie palavras-chave reservadas, palavras reservadas restritas (`var`, `yield`) e literais especiais (`true`, `false`, `null`), mostrando exemplos de uso.
* Analise trechos de código com separadores ausentes ou em excesso, identifique os erros de compilação resultantes e proponha correções.
* Monte um quadro comparativo categorizando palavras-chave de controle de fluxo, definição de tipos, tratamento de exceções e modularização.
* Simule um cenário em que o uso de `var` gera ambiguidade de tipo e mostre como esclarecer o código com declarações explícitas.
* Quais palavras-chave ou separadores costumam gerar mais confusão para iniciantes e como evitá-la?

---

## Operadores

* Classifique os operadores de Java (atribuição, aritméticos, relacionais, lógicos, bitwise, ternário) e descreva sua função.
* Demonstre a precedência e a associatividade dos operadores construindo uma tabela e aplicando-a na avaliação passo a passo de expressões complexas.
* Forneça exemplos em que operadores lógicos de curto-circuito (`&&`, `||`) evitam exceções, comparando com seus equivalentes bitwise (`&`, `|`).
* Demostre exemplos de expressões com operadores compostos (`+=`, `-=`, etc.) para evitar efeitos colaterais inesperados.
* Apresente um estudo de caso em que um cálculo financeiro sofre erro por causa de divisão entre inteiros e mostre a correção com casts apropriados.
* Como o entendimento da ordem de avaliação e dos operadores de incremento influencia o comportamento de laços e condições?

---

## Tipos Primitivos e Referência

* Explique as características de cada tipo primitivo (faixa de valores, tamanho e uso típico) e compare com tipos de referência.
* Mostre como funcionam conversões implícitas, casts explícitos e autoboxing/unboxing, destacando riscos de perda de dados.
* Demostre um exemplo e explique como funciona o tipo inferido com `var` e verifique a compatibilidade de atribuições entre tipos primitivos e wrappers.
* Simule um algoritmo que escolha o tipo mais adequado para representar contagem, valores monetários e medições científicas, justificando cada decisão.
* Solicite exemplos de uso das classes utilitárias `Integer`, `Double`, `Boolean` para manipular strings de entrada e validar dados.
* Por que compreender a diferença entre tipos primitivos, wrappers e referências é essencial para evitar `NullPointerException` e problemas de desempenho?

---

## Strings e Manipulação de Texto

* Explique as características principais de `String` em Java, incluindo imutabilidade, pool de strings e o impacto disso em memória e desempenho.

---

## Declaração de Variáveis, Expressions e Statements

* Descreva a sintaxe para declarar variáveis, constantes (`final`) e variáveis locais com `var`, enfatizando onde cada forma é apropriada.
* Explique a diferença entre expressions e statements em Java, utilizando exemplos que mostrem como uma expressão pode produzir valor para um statement.
* Demonstre a reorganização de um trecho de código misturando declarações, inicializações e expressões para melhorar clareza e evitar variáveis não inicializadas.
* Proponha a criação de um programa curto que combine expressões aritméticas e lógicas, e peça para rastrear como cada statement altera o estado do programa.
* Simule uma sessão de depuração em que um statement mal posicionado causa comportamento inesperado e mostre como identificar o problema com uma IDE ou `jshell`.
* Quais hábitos garantem declarações claras e evitam efeitos colaterais ocultos em blocos de código Java?
