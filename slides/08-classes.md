---
layout: frontcover
transition: none
title: IDP - POO
id: aula08
lesson: Construindo classes robustas
goals:
  - Encapsular estado com atributos privados e validação
  - Oferecer múltiplos construtores via sobrecarga
  - Implementar métodos de acesso e representação textual
---

---
layout: default
lesson: Encapsulamento
---

## Exemplo `Time1`

```java
// Time1.java
public void setTime(int hour, int minute, int second) {
    if (hour < 0 || hour >= 24 || minute < 0 || minute >= 60 || second < 0 || second >= 60) {
        throw new IllegalArgumentException("hour, minute and/or second was out of range");
    }
    this.hour = hour;
    this.minute = minute;
    this.second = second;
}
```

- Validação centralizada evita estados inválidos
- `this` diferencia variáveis de instância dos parâmetros
- `toUniversalString` e `toString` oferecem formatações distintas
- Reforce invariantes documentando intervalos válidos (0–23, 0–59)
- Métodos públicos expõem comportamentos; atributos permanecem ocultos

---

## Construtores sobrecarregados (`Time2`)

```java
public Time2() {
    this(0, 0, 0);
}

public Time2(int hour, int minute, int second) {
    // validação...
    this.hour = hour;
    this.minute = minute;
    this.second = second;
}

public Time2(Time2 time) {
    this(time.getHour(), time.getMinute(), time.getSecond());
}
```

- `this(...)` reaproveita lógica entre construtores
- Construtor-cópia garante duplicação segura
- Métodos `setHour`, `setMinute`, `setSecond` mantêm invariantes
- Sobrecarga de construtores facilita criação com diferentes níveis de informação
- `@Override` garante que assinaturas batam com a superclasse/ interface

---

## Testes de uso

- `Time1App` e `Time2App` demonstram instanciamento e formatação
- `Time1MemberAccessTest` enfatiza encapsulamento (acesso via métodos)
- `ThisTest` ilustra uso de `this` para encadear construtores
- Exercício: adicionar incremento de segundo preservando consistência
- Considere implementar interfaces (`Comparable<Time2>`) para ordenação
- Objetos podem ser compostos: `TimeRange` poderia reutilizar instâncias `Time2`

---
layout: backcover
---
