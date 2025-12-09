---
layout: frontcover
transition: none
title: IDP - POO
id: aula07b
lesson: Trabalhando com `ArrayList`
goals:
  - Compreender operações básicas de listas dinâmicas
  - Aplicar algoritmos utilitários de `java.util.Collections`
  - Converter entre arrays e listas
---

---
layout: default
lesson: Operações essenciais
---

## Adicionando e removendo elementos

```java
// ArrayListAddRemoveDemo.java
ArrayList<String> al = new ArrayList<>();
al.add("C");
al.addFirst("A0");
al.addLast("Z");
System.out.println("Size: " + al.size());

al.remove("F");
al.removeFirst();
al.removeLast();
```

- Métodos `addFirst`/`addLast` exigem Java 21 (`ArrayList` implementação atual)
- `size()` retorna quantidade de elementos válidos
- Remova por índice (`remove(2)`) ou por objeto (`remove("F")`)
- `ArrayList` implementa `List` usando um array redimensionável internamente
- Crescimento automático duplica a capacidade quando necessário

---

## Buscas e ordenação

```java
// CollectionsMethods.java
Collections.sort(cidades);
int index = Collections.binarySearch(cidades, "Brasília");
Collections.reverse(cidades);
Collections.addAll(cidades, "Florianópolis", "Porto Alegre");
```

- Ordenar antes de executar `binarySearch`
- `reverse` modifica a lista in place
- `addAll` adiciona múltiplos elementos de uma vez
- Métodos utilitários da classe `Collections` aplicam algoritmos genéricos
- Comparadores customizados (`Comparator`) controlam ordem de ordenação

---

## Conversões

```java
// ArrayToList.java
Integer[] numbers = {1, 2, 3, 4};
List<Integer> list = Arrays.asList(numbers);
```

- `Arrays.asList` cria lista de tamanho fixo (espelho do array)
- Utilize `new ArrayList<>(Arrays.asList(numbers))` para lista mutável
- `ArrayListToArray` mostra caminho inverso (`toArray(new Integer[0])`)
- Conversões preservam a ordem de inserção
- Ao trabalhar com tipos primitivos, use wrappers (`Integer`, `Double`)

---

## Boas práticas

- Prefira interface `List` em assinaturas de método
- Observe custo de remoções no meio da lista (realocação)
- Use `contains` para verificar existência antes de remover
- Documente ordem dos elementos quando representar filas ou pilhas
- Custo amortizado: `add` ao final é `O(1)`, `add` em posições intermediárias é `O(n)`
- Iteradores (`listIterator`) permitem percorrer e modificar com segurança

---
layout: backcover
---
