Problema: Happy Number

Escreva um algoritmo para determinar se um número nn é um número feliz.

Usamos o seguinte processo para verificar se um dado número é um número feliz:

* Começando com o número `n` dado, substitua o número pela soma dos quadrados de seus dígitos.
* Repita o processo até que:
    * O número seja igual a 11, o que indica que o número nn dado é um número feliz.
    * número entre em um ciclo, o que indica que o número nn dado não é um número feliz.
    * Retorne `true` se nn for um número feliz e `false` caso contrário.

Restrições

1 ≤ n ≤ 2^31 − 1