### Reversão de String  

Referência: [String](https://en.wikipedia.org/wiki/String_(computer_science))

---

#### Especificação
1. O programa deve solicitar ao usuário uma **string de entrada**.
2. O programa deve inverter a string **sem utilizar funções prontas da linguagem**, como [StringBuilder](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/StringBuilder.html).[reverse()](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/StringBuilder.html#reverse()).
3. O programa deve exibir a string original e a string invertida.
4. O programa deve tratar corretamente strings **vazias** e **compostas apenas por espaços**.
5. O programa deve manter maiúsculas, minúsculas e espaços na posição correta, apenas invertendo a sequência de caracteres.
6. Exemplo de entrada e saída:

    ```bash
    Digite uma string: Java
    String invertida: avaJ
    ```

    ```bash
    Digite uma string: OpenAI
    String invertida: IAnepO
    ```

    ```bash
    Digite uma string: 12345
    String invertida: 54321
    ```

    ```bash
    Digite uma string: Hello, World!
    String invertida: !dlroW ,olleH
    ```
---

#### Requisitos de Implementação
1. O programa deve conter uma **classe chamada `StringReverser`**.
2. A classe deve possuir **dois métodos públicos e estáticos**:
   - `reverseString(String s)`: recebe uma string e retorna a string invertida.
   - `main(String[] args)`: método principal para ler a entrada do usuário e exibir a saída.
3. O programa **não pode usar métodos prontos do java**, como `StringBuilder.reverse()` ou `Collections.reverse()`.
4. O programa deve usar um **loop** para percorrer os caracteres da string e inverter a ordem.
5. O programa deve validar a entrada para evitar `NullPointerException` caso o usuário insira uma string nula.