---
layout: frontcover
transition: none
title: IDP - POO
id: aula11
lesson: Tratamento de exceções
goals:
  - Detectar e tratar situações excepcionais com *try-catch*
  - Criar exceções personalizadas para regras de negócio
  - Utilizar *finally* e boas práticas de tratamento
---

---

## Exceção

- Exceção (__Exception__): indica um problema durante a execução de um programa
- Tratamento de exceção (__Exception handling__): permite a aplicação resolver (tratar) exceções
- Viabiliza o desenvolvimento de softwares mais robustos e tolerantes a falha   

---

## Exceção

-  

---

## Hierarquia essencial

- *Throwable* divide-se em *Error* (falhas graves da JVM) e *Exception*
- *Exception* agrupa erros recuperáveis; *RuntimeException* e subclasses são não checadas
- Exceções checadas comuns: *IOException*, *SQLException*, *ClassNotFoundException*
- Pacotes especializados: *java.io* (I/O), *java.sql* (banco), *java.time* (data/hora)

---

## Hierarquia essencial

<FigureWithCaption
  src="images/exceptions.png"
  alt="Tratamento de exceções"
  link="https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Exception.html​"
/>

---

## Exceções checadas x não checadas

- **Checadas** (*Exception* fora de *RuntimeException*): compilador exige *try-catch* ou *throws*
- **Não checadas** (*RuntimeException*, *Error*): indicam bugs/condições inesperadas
- Trate checadas próximas à fronteira externa (UI, APIs, persistência)
- Envolva não checadas apenas para enriquecer contexto; evite ocultá-las
- Propague mantendo causa (*throw new MinhaExcecao("falha", e);*)

---

## Pilha de chamadas e propagação

- Cada thread mantém uma pilha de ativações (frames) para métodos ativos
- Ao lançar (*throw*), a JVM desempilha métodos até encontrar um *catch* compatível
- Ausência de manipulador encerra a thread, e o runtime imprime o *stack trace*
- O *stack trace* revela a sequência de chamadas que levou à falha
- Referência detalhada em *lectures/examples/11-exception/exception.md*

---

## Divisão segura

```java
// DivideByZeroWithExceptionHandling.java
try {
    int result = 10 / 0;
}
catch (ArithmeticException e) {
    System.err.println("Zero is an invalid denominator. Please try again.");
}
```
---

## Exceção personalizada

```java
// MyException.java
public class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}
```

---

## Exceção personalizada

- Permite sinalizar regras de negócio
- Sempre propague (*throws*) ou trate a exceção customizada
- Exceções checadas (*Exception*) exigem tratamento explícito
- Mantenha mensagens claras para facilitar troubleshooting

---

## Declaração e propagação

```java
// FileLoader.java
public String load(String path) throws IOException {
    try (BufferedReader reader = Files.newBufferedReader(Path.of(path))) {
        return reader.readLine();
    }
}
```

---

## Declaração e propagação

- *throws* documenta exceções checadas propagadas pela API
- Métodos podem capturar e traduzir (*throw new BusinessException("...", e);*)
- Reavalie contratos após adicionar novas exceções; atualize documentação
- Use exceções específicas para sinalizar causa semântica ao consumidor

---

## Fluxo do *try-catch-finally*

- *try* delimita código suscetível a falhas numa única região protegida
- *catch* mais específico intercepta primeiro; demais são ignorados
- *finally* executa após *try*/*catch*, mesmo quando há retorno ou exceção
- Cada exceção segue um caminho: sucesso, captura local ou propagação

---

## Fluxo com *finally*

```java
// UsingExceptions.java
public static void throwException() throws Exception {
    try {
        System.out.println("Method throwException");
        throw new Exception();
    }
    catch (Exception exception) {
        System.err.println("Exception handled in method throwException");
        throw exception;
    }
    finally {
        System.err.println("Finally executed in throwException");
    }
}
```

---

## Fluxo com *finally*

- *throwException* trata, relança e ainda executa o *finally*
- *finally* roda independentemente de sucesso, retorno ou erro
- *doesNotThrowException* também executa seu *finally* mesmo sem falhas
- Utilize *finally* (ou try-with-resources) para liberar arquivos, conexões, locks
- Propagação constrói *stack trace* revelando a cadeia de chamadas

---

## Try-with-resources

```java
// TryWithResourcesDemo.java
try (var reader = Files.newBufferedReader(path);
     var writer = Files.newBufferedWriter(out)) {
    writer.write(reader.readLine());
}
```

---

## Try-with-resources

- Fecha recursos automaticamente ao sair do bloco
- Cada recurso deve implementar *AutoCloseable*
- Recursos são fechados em ordem inversa à declaração
- Captura *IOException* sem vazamento de descritores
- Blocos *catch* e *finally* ainda podem ser adicionados se necessário

---

## Multi-catch e rethrow

```java
try {
    process(request);
}
catch (IOException | SQLException e) {
    throw new ServiceException("Falha de infraestrutura", e);
}
```

---

## Multi-catch e rethrow

- Multi-catch evita duplicação de tratamento para exceções relacionadas
- Variável *e* é efetivamente final dentro do bloco
- Use *throw* simples para repropagar mantendo o *stack trace*
- Ao criar nova exceção, passe a causa original (*new ...(..., e)*)
- Adicione contexto (ex.: parâmetros relevantes) antes de repropagar

---

## Encadeamento e suprimidas

```java
try {
    runTask();
}
catch (OperationException e) {
    e.getSuppressed(); // exceções fechadas em try-with-resources
    throw e.initCause(new IllegalStateException("scheduler"));
}
```

---

## Encadeamento e suprimidas

- *initCause* ou construtores permitem encadear causas
- *getSuppressed()* captura exceções ocultadas por *try-with-resources*
- Faça log das suprimidas para diagnosticar desalocações falhas
- Exceções encadeadas facilitam rastrear origem real do erro
- Evite sobrescrever causa original sem necessidade

---

## Boas práticas

- Trate apenas exceções recuperáveis; deixe falhas graves subirem
- Registre (*logger.error*) detalhes antes de repropagar
- Não silencie exceções vazias (*catch (Exception e) {}*)
- Utilize mensagens claras para ajudar no diagnóstico
- Prefira exceções específicas (*IllegalArgumentException*, *IllegalStateException*)
- Evite usar exceções para controle de fluxo normal

---
layout: backcover
---
