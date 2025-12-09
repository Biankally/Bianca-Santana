---
layout: frontcover
transition: none
title: IDP - POO
id: aula06
lesson: Métodos, escopo e sobrecarga
goals:
  - Definir e invocar métodos estáticos reutilizáveis
  - Controlar escopo de variáveis dentro e fora de métodos
  - Aplicar sobrecarga para variações de assinatura
---

---
layout: default
lesson: Por que criar métodos?
---

## Reaproveitamento e organização

- Exemplos em `lectures/examples/06-methods`
- `MaximumFinder`: encapsula comparação em método separado
- `RollDie`, `RandomIntegers`: simulam aleatoriedade com `java.security.SecureRandom`
- `Craps`: combina vários métodos para estruturar um jogo completo
- Métodos promovem reutilização, legibilidade e isolamento de responsabilidades
- Parâmetros permitem generalizar comportamentos variando entradas

---

## Funções utilitárias

```java
// MaximumFinder.java
public static double maximum(double x, double y, double z) {
    double maximumValue = x;
    if (y > maximumValue) {
        maximumValue = y;
    }
    if (z > maximumValue) {
        maximumValue = z;
    }
    return maximumValue;
}
```

- Método estático reaproveitável em vários contextos
- Considere uma versão alternativa usando `Math.max`
- Em Java, parâmetros são passados por valor (referências copiam o ponteiro)
- Retornar valores evita depender de variáveis globais mutuáveis

---

## Sobrecarga

```java
// MethodOverload.java
public static int square(int intValue) {
    return intValue * intValue;
}

public static double square(double doubleValue) {
    return doubleValue * doubleValue;
}
```

- Mesmo nome, assinaturas diferentes (`int` x `double`)
- JVM escolhe a versão adequada em tempo de compilação
- Evite sobrecargas que causem ambiguidade (`square(long)`?)
- Assinatura = nome + lista ordenada de tipos dos parâmetros
- Use JavaDoc para explicar diferenças semânticas entre sobrecargas

---

## Escopo e variáveis locais

- `Scope.java`: demonstra como variáveis locais ocultam variáveis de classe
- `Scope` também evidencia tempo de vida limitado ao bloco atual
- Boas práticas:
  - Use nomes distintos para evitar shadowing
  - Prefira variáveis locais sempre que possível
  - Inicialize variáveis próximo ao uso
- Variáveis `static` pertencem à classe; locais existem apenas dentro do método
- Documente efeitos colaterais e pré-condições para facilitar manutenção

---
layout: backcover
---
