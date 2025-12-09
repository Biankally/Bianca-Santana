# Solução de Referência

## Estrutura
- `src/Participant.java`: classe base abstrata para participantes.
- `src/StudentParticipant.java`: implementação do participante estudante.
- `src/ProfessionalParticipant.java`: implementação do participante profissional.
- `src/EventApp.java`: classe principal que demonstra o uso das outras classes.

## Como compilar e executar
```bash
cd challenges/08-event
javac -d bin/app $(find submissions/fabricio-santana/src -name "*.java")
java -cp bin/app EventApp
```

## Como executar os testes
```bash
cd challenges/08-event
mkdir -p lib
curl -L -o lib/junit-platform-console-standalone-1.11.4.jar https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.11.4/junit-platform-console-standalone-1.11.4.jar
javac -d bin/app $(find submissions/fabricio-santana/src -name "*.java")
javac -cp "lib/junit-platform-console-standalone-1.11.4.jar:bin/app" -d bin/test $(find test -name "*.java")
java -jar lib/junit-platform-console-standalone-1.11.4.jar -cp bin/app:bin/test --scan-class-path
```
