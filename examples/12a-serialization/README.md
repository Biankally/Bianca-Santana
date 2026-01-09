```bash
curl -L -o lib/jackson-annotations-2.20.jar https://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-annotations/2.20/jackson-annotations-2.20.jar
```

```bash
curl -L -o lib/jackson-core-2.20.1.jar https://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-core/2.20.1/jackson-core-2.20.1.jar
```

```bash
curl -L -o lib/jackson-databind-2.20.1.jar https://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-databind/2.20.1/jackson-databind-2.20.1.jar
```

```bash
javac -d bin -cp "lib/*" src/*.java
```

```bash
java -cp bin:lib/* EmployeeBinaryDeserializationApp 
```