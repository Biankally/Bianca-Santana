# Estruturas de Controle em Java

## Decisões com if/else

* Explique a estrutura básica do `if`, `if/else` e `if/else if/else`, destacando a avaliação de expressões booleanas em Java.
* Compare abordagens com `if` aninhado, condicionais compostas e guard clauses, mostrando o impacto na legibilidade do código.
* Gere exercícios para identificar erros comuns, como uso de operadores de atribuição em vez de comparação ou blocos sem chaves.
* Simule um processo de depuração em que condições mal ordenadas provocam lógica incorreta e proponha uma reorganização mais clara.
* Desenvolva um mini fluxo de decisão (ex.: cálculo de desconto progressivo) e peça justificativas para cada condição usada.

---

## Switch Statements e Switch Expressions

* Descreva a sintaxe tradicional do `switch` statement, explicando `case`, `break`, `default` e boas práticas para evitar fall-through acidental.
* Apresente o `switch` com setas introduzido em Java 12+, destacando como ele simplifica blocos de decisão tanto em statements quanto em expressions.
* Diferencie objetivamente `switch statements` (focam em direcionar fluxo, sem produzir valor direto) e `switch expressions` (avaliam e retornam um valor), demonstrando quando preferir cada forma.
* Demonstre uma decisão condicional em `switch` statement e depois em `switch` expression com `yield`.
* Proponha um estudo de caso que refatore uma cadeia de `if/else` para `switch`, avaliando legibilidade, segurança contra fall-through e possibilidades de retorno de valores.
* Quais critérios ajudam a escolher entre `if/else` complexos, `switch statements` e `switch expressions` em projetos modernos?

---

## Laços while e do-while

* Explique o funcionamento dos laços `while` e `do-while`, destacando a diferença de avaliação da condição antes ou depois do corpo do laço.
* Monte exemplos que demonstrem inicialização correta de variáveis de controle e prevenção de loops infinitos.
* Demonstre a conversão de um `while` em `do-while` (e vice-versa) analisando impactos no fluxo.
* Simule a leitura iterativa de dados com validação, mostrando como lidar com entradas inválidas usando cada laço.
* Apresente um estudo de caso em que o laço `do-while` é preferível (ex.: menu interativo) e discuta o motivo.
* Como planejar condições de saída claras reduz problemas de desempenho e travamentos em laços?

---

## Laços for e enhanced for

* Descreva a sintaxe do laço `for` tradicional e explique os três componentes (inicialização, condição, atualização).
* Mostre como o `enhanced for` simplifica a iteração sobre arrays e coleções, comparando com o uso de iteradores explícitos.
* Gere exercícios que peçam a conversão de laços `for` tradicionais em `enhanced for`, discutindo quando isso não é possível (ex.: necessidade de índice).
* Solicite a criação de exemplos que percorrem arrays multidimensionais e coleções genéricas, enfatizando boas práticas de tipagem.
* Simule um cenário em que um `for` mal configurado gera `ArrayIndexOutOfBoundsException` e conduza a correção passo a passo.
* Como escolher entre `for` e `while`?

---

## Controle de fluxo avançado e boas práticas

* Explique o papel de `break`, `continue` e rótulos (`label`) em laços, mostrando quando seu uso é justificável.
* Analise um trecho de código com múltiplas estruturas de controle e proponha simplificações para reduzir complexidade ciclomática.
* Demonstre um exemplo com caminhos inatingíveis em estruturas de controle e como  detectar e eliminar código morto.
* Apresente um mini projeto (ex.: simulador de caixa eletrônico) que combine condicionais e laços e testes de fluxo com casos de erro.
* Discuta estratégias de teste como tabelas de decisão, fluxogramas e cobertura de ramos para validar estruturas de controle.
* Quais métricas ou práticas de revisão ajudam a manter estruturas de controle legíveis e confiáveis?
