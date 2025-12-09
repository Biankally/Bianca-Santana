Problema: Stream of Characters

Projete uma estrutura de dados que processe um fluxo de caracteres e, após cada caractere ser recebido, determine se um sufixo desses caracteres corresponde a uma string em um array de strings chamado `words`.

Por exemplo, se `words = ["dog"]` e o fluxo adicionar os caracteres 'd', 'c', 'a', 'd', 'c', 'a' e 't' em sequência, o algoritmo deve detectar que o sufixo "cat" do fluxo "dcat" corresponde à palavra "cat" da lista.

Portanto, para `words`, o objetivo é detectar se alguma dessas palavras aparece como um sufixo do fluxo construído até o momento. Para isso, implemente uma classe `StreamChecker`:

Construtor: Inicializa o objeto com a lista de palavras-alvo.

boolean query(char letter): Adiciona um caractere ao fluxo e retorna `true` se algum sufixo do fluxo corresponder a uma palavra na lista `words`.

Restrições:

* 1 ≤ `words.length` ≤ 1000
* 1 ≤ words[i].length ≤ 200
* `words[i]` consiste em letras minúsculas do alfabeto inglês.
* `letter` é uma letra minúscula do alfabeto inglês.
* No máximo, 4 ∗ 10^2 chamadas serão feitas para a consulta.