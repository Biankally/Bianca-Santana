# Arrays e ArrayList em Java

## Arrays unidimensionais

* Explique como declarar, instanciar e inicializar arrays unidimensionais em Java, incluindo os valores padrão atribuídos pela JVM.
* Mostre como acessar elementos, percorrer com laços `for` e `enhanced for`, e evitar erros como `ArrayIndexOutOfBoundsException`.
* Demostre alguns exemplos de maniputação de arrays manipule arrays (inversão, busca, contagem de ocorrências) usando apenas recursos básicos da linguagem.
* Apresente a classa `java.lang.Arrays` e explique como o resultado dos exemplos anterioes podem ser alcançados.
* Descreva um processo de depuração em que um array não é inicializado corretamente e comente como corrigir passo a passo.
* Implemente um algoritmo simples (ex.: cálculo de média) e discuta como tratar arrays vazios ou nulos.
* Por que arrays continuam úteis em Java mesmo com a disponibilidade de coleções mais flexíveis?

---

## Arrays multidimensionais e utilitários

* Descreva a sintaxe de arrays multidimensionais (`int[][]`) e diferencie arrays retangulares de arrays irregulares.
* Demosntre exemplos que preencham e percorram matrizes, mapeando índices para posições lógicas (linhas, colunas).
* Demonstre o uso da classe `java.util.Arrays` (`sort`, `fill`, `copyOf`, `binarySearch`, `toString`) aplicando cada método em arrays reais.
* Demostre como transformar uma matriz em lista de valores e vice-versa, discutindo usos em algoritmos.
* Simule um caso de uso que calcule tabelas (ex.: notas de alunos) explorando métodos utilitários para análise.
* Quais armadilhas surgem ao trabalhar com arrays multidimensionais e como evitá-las em projetos maiores?

---

## ArrayList e Coleções Dinâmicas

* Explique o que é a classe `ArrayList`, como declará-la com generics e como ela armazena elementos internamente.
* Demonstre operações básicas (`add`, `get`, `set`, `remove`, `size`, `isEmpty`) e iteração usando laços e `Iterator`.
* Apresente o uso de listas dinâmicas (ex.: carrinho de compras) enfatizando validação de entradas.
* Mostre como lidar com `ArrayList` de objetos personalizados, incluindo sobrescrita de `equals` e `hashCode` quando relevante.
* Apresente uma visão geral o framework Collections, que será estudado de forma aprodundada mais adianta, destacando como o `ArrayList` se integra ao restante do framework Collections em Java?

---

## Comparando Arrays e ArrayList

* Elabore uma tabela comparativa entre arrays e `ArrayList`, destacando diferenças de tamanho, tipos suportados, desempenho e flexibilidade.
* Demonstre como converter de array para `ArrayList` e vice-versa usando `Arrays.asList`, `List.of`, `toArray` e construtores apropriados.
* Apresente exemplos onde a escolha da estrutura adequada para diferentes requisitos (memória fixa, inserções frequentes, acesso randomico) faz diferença.
* Analise casos em que arrays primitivos são preferíveis por desempenho e situações em que a flexibilidade do `ArrayList` compensa.
* Simule uma refatoração que substitui arrays por `ArrayList` e discuta impactos em APIs públicas e compatibilidade.
* Quais critérios guiam a decisão entre arrays e listas no design de uma aplicação Java?
