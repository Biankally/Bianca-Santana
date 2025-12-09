---
layout: frontcover
transition: none
title: IDP - POO
id: aula07
lesson: Arrays unidimensionais, multidimensionais e varargs
goals:
  - Declarar, inicializar e percorrer arrays
  - Aplicar `enhanced for` e métodos utilitários da API `Arrays`
  - Utilizar varargs para aceitar quantidade variável de argumentos
---

---
layout: default
lesson: Arrays básicos
---

## Inicialização e iteração

```java
// ArrayInit.java
int[] array = {32, 27, 64, 18, 95, 14, 90, 70, 60, 37};
System.out.printf("%s%8s%n", "Index", "Value");
for (int counter = 0; counter < array.length; counter++) {
    System.out.printf("%5d%8d%n", counter, array[counter]);
}
```

- `array.length` retorna o tamanho atual
- Índices zero-based: último elemento está em `length - 1`
- Arrays são estruturas contíguas de tamanho fixo determinado na criação
- Acesso por índice é `O(1)`; redimensionar requer criar novo array

---

## Enhanced for e estatísticas

- `ArrayEnhancedForTest` utiliza `for (int value : array)` para percorrer
- `ArraySumOfElements` soma elementos acumulando em uma variável
- `ArrayBarChart` transforma frequências em barras de texto
- `RollDie` simula dados e registra resultados em um array
- `for-each` é ideal quando não precisamos do índice
- `Arrays.stream(array)` integra arrays com API de streams

---

## Arrays multidimensionais

```java
// ArrayTwoDimensional.java
int[][] array1 = {{1, 2, 3}, {4, 5, 6}};
for (int row = 0; row < array1.length; row++) {
    for (int column = 0; column < array1[row].length; column++) {
        System.out.printf("%d  ", array1[row][column]);
    }
    System.out.println();
}
```

- Cada linha pode ter tamanho distinto (`array2` é irregular)
- Inspecione com cuidado `array[row].length`
- Arrays bidimensionais são arrays de arrays, não matrizes contíguas
- Convenção: primeiro índice = linha, segundo = coluna

---

## Varargs e utilitários

```java
// VarargsTest.java
public static double average(double... numbers) {
    double total = 0.0;
    for (double d : numbers) {
        total += d;
    }
    return total / numbers.length;
}
```

- `double...` permite chamar `average(1, 2, 3)`
- Classe `Arrays` provê `sort`, `fill`, `copyOf`, `compare` (`ArraysSortFill.java`, `ArraysCompareCustomTypes.java`)
- Explore `ArrayAsParameter` para entender passagem por referência
- Varargs converte argumento variável em array automaticamente
- Atenção ao auto-boxing quando usar arrays de wrappers (`Integer[]`)

---
layout: backcover
---
