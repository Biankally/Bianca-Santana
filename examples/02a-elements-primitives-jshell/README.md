### jshell

O [jShell](https://docs.oracle.com/en/java/javase/21/docs/specs/man/jshell.html) é uma ferramenta interativa introduzida no Java 9 que permite executar comandos e testar código Java de forma rápida, sem a necessidade de compilar ou criar um arquivo `.java`. Ele é conhecido como um [REPL (Read-Eval-Print Loop)](https://pt.wikipedia.org/wiki/REPL), ou seja, um ambiente interativo onde você pode ler, executar (evaluate) e imprimir resultados de código Java em tempo real.

Os arquivos deste diretório devem ser executados no `jshell`.

1. Para começar verifique se você possui o `jdk` instalado. O `jshell` foi introduzido na versão 9

    ```bash
    java --version
    ```

2. Execute o comando `jshell`
    ```bash
    jshell
    ```
    O terminal exibirá
    ```bash
    |  Welcome to JShell -- Version 21
    |  For an introduction type: /help intro
    jshell>
    ```

3. Pronto, agora você pode executar código `java` ou comandos `jshell` diretamente no terminal

    Exemplo de código 
    ```java
    jshell> int x = 10;

    jshell> System.out.println("Hello, World!");
    ```

    Exemplo de comando `jshell`
    ```bash
    jshell> /open Literal.txt
    ```

4. Aqui está uma lista com os principais comandos de `jshell` para usar neste exercício

    | Comando               | Descrição |
    |----------------------|-------------|
    | `/list`         | Lista todas as entradas (declarações, métodos, variáveis) na sessão atual. |
    | `/edit [option]` | Abre um editor para modificar declarações da sessão atual. |
    | `/drop {name\|id\|startID-endID}` | Remove uma variável, método ou importação da sessão. |
    | `/save [options] file` | Salva a sessão atual em um arquivo para uso posterior. |
    | `/open file` | Abre e executa comandos de um arquivo salvo anteriormente. |
    | `/reload` | Recarrega a sessão anterior do JShell sem perder definições. |
    | `/reset` | Reinicia a sessão do JShell, apagando todas as definições. |
    | `/history` | Exibe o histórico de comandos executados na sessão atual. |
    | `/types [option]` | Lista os tipos definidos na sessão. |
    | `/vars` | Lista todas as variáveis declaradas na sessão atual. |
    | `/help` | Exibe uma lista de comandos disponíveis e suas descrições. |