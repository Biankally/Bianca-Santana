import static java.lang.IO.println;
import static java.lang.IO.print;

void main () {
    LinkedList<String> list = new LinkedList<>();

    println("Append Element: adicione um elemento ao final da lista encadeada.");
    list.add("Elemento A");
    list.add("Elemento B");
    list.add("Elemento C");
    list.add("Elemento D");
    list.add("Elemento E");

    println("\nIterate LinkedList Elements: percorra todos os elementos da lista.");
    list.forEach(IO::println);

    println("\nIterate from Position: percorra a lista iniciando de uma posição específica.");
    int initialPosition = 2;
    ListIterator<String> iterator = list.listIterator(2);
    System.out.println("Iterando a partir da posição " + initialPosition + " (Elemento '" + list.get(initialPosition) + "'):");

    while (iterator.hasNext()) println(iterator.next());

    println("\nIterate in Reverse Order: percorra a lista na ordem inversa.");
    Iterator<String> iteratorReverse = list.descendingIterator();
    while (iteratorReverse.hasNext()) println(iteratorReverse.next());

    println("\nInsert at Position: insira um elemento na posição informada.");
    list.set(0, "Nova variavel");
    list.forEach(IO::println);

    println("\nInsert First and Last: insira elementos nas extremidades (primeiro e último).");
    list.addFirst("Adicionando no primeiro Elemento");
    list.addLast("Adicionando no ultimo Elemento");
    list.forEach(IO::println);

    println("\nInsert Multiple at Position: insira vários elementos a partir de uma posição específica.\n");
    println("Adicionando Novas variaveis na possição 3: Elemento 1, Elemento 2");
    list.forEach((value) -> print(value + ", "));
    println();
    List<String> newList = Arrays.asList("Elemento 1", "Elemento 2");
    list.addAll(5, newList);
    list.forEach((value) -> print(value + ", "));
    println();

    println("First and Last Occurrence: informe a primeira e a última ocorrência de um elemento específico.");
    list.add("Elemento B");
    println("Porcurando pela primeira aparação de: Elemento B");
    println("Index: " + list.indexOf("Elemento B"));

    println("Porcurando pela ultima aparação de: Elemento B");
    println("Index: " + list.lastIndexOf("Elemento B"));

    println("Print Elements with Positions: exiba cada elemento junto com sua posição (index -> element).");
    for (int index = 0; index < list.size(); index++) {
        println(index + " -> " + list.get(index));
    }

    println("\nRemove Element: remova um elemento específico da lista.");
    list.forEach((value) -> print(value + ", ")); println();
    println("Removendo o elemento com indexe 1");
    list.remove(1);
    list.forEach((value) -> print(value + ", ")); println();


    println("\nRemove First and Last: remova o primeiro e o último elemento da lista.");
    list.forEach((value) -> print(value + ", ")); println();
    list.removeFirst();
    list.removeLast();
    list.forEach((value) -> print(value + ", ")); println();

    println("\nClear LinkedList: remova todos os elementos da lista.");
    list.clear();

    println("\nSwap Elements: troque os elementos de duas posições informadas.");
    list.add("Elemento A");
    list.add("Elemento B");
    list.forEach((value) -> print(value + ", ")); println();
    Collections.swap(list, 0, 1);
    list.forEach((value) -> print(value + ", ")); println();

    println("Shuffle LinkedList: embaralhe os elementos da lista.");
    list.add("Elemento C");
    list.forEach((value) -> print(value + ", ")); println();
    Collections.shuffle(list);
    list.forEach((value) -> print(value + ", ")); println();

    println("\nJoin LinkedLists: una duas listas em uma nova LinkedList.");
    LinkedList<String> list1 = new LinkedList<>(List.of("Elemento D", "Elemento E"));
    list.forEach((value) -> print(value + ", ")); println();
    list.addAll(list1);
    list.forEach((value) -> print(value + ", ")); println();

    println("\nCopy LinkedList: crie uma nova lista cópia da lista original.");
    println("Original:");
    list.forEach((value) -> print(value + ", ")); println();
    println("Cópia:");
    LinkedList<String> clonedList = (LinkedList<String>) list.clone();
    clonedList.forEach((value) -> print(value + ", ")); println();

    println("\nPoll First Element: remova e retorne o primeiro elemento da lista.");
    list.forEach((value) -> print(value + ", ")); println();
    list.pop();
    list.forEach((value) -> print(value + ", ")); println();

    println("\nPeek First Element: recupere, sem remover, o primeiro elemento da lista.");
    println(list.getFirst());

    println("\nPeek Last Element: recupere, sem remover, o último elemento da lista.");
    println(list.getLast());

    println("\nContains Element: verifique se um elemento específico está presente na lista.");
    println("Verificando se \"Elemento B\" existe:");
    println(list.contains("Elemento B"));

    println("Verificando se \"Elemento F\" existe:");
    println(list.contains("Elemento F"));

    println("\nConvert to ArrayList: converta a LinkedList para uma ArrayList.");
    ArrayList<String> array = new ArrayList<>(list);
    array.forEach((value) -> print(value + ", ")); println();

    println("\nCompare LinkedLists: verifique se duas listas possuem os mesmos elementos na mesma ordem.");
    LinkedList<String> listToEquals = new LinkedList<>(list);
    println("Comparando uma lista clonada:");
    println(list.equals(listToEquals));
    println("Comparado listas diferentes:");
    listToEquals.add("teste");
    println(list.equals(listToEquals));

    println("Check if Empty: informe se a lista está vazia.");
    list.forEach((value) -> print(value + ", ")); println();
    println("A lista está vazia?");
    println(list.isEmpty());

    println("Replace Element: substitua o valor de um elemento na posição informada.");
    list.forEach((value) -> print(value + ", ")); println();
    list.set(2, "Replaced");
    list.forEach((value) -> print(value + ", ")); println();
}