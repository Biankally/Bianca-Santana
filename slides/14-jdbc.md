---
layout: frontcover
transition: none
title: IDP - POO
id: aula14
lesson: Acesso a banco de dados via JDBC
goals:
  - Revisar conceitos de banco de dados relacionaos e comandos SQL
  - Conhecer a API Java Database Connectivity (JDBC)
  - Compreender as etapas de conexão ao banco de dados via driver JDBC
  - Executar operações SQL via JDBC
  - Processar resultados, extrair metadados e controlar transações
---

---

## Conceitos básicos de banco de dados

- **Banco de Dados (_Database_**)
    - coleção organizada de dados
    - repositório estruturado que armazena dados relacionados
- **_Database Management System (DBMS)_**
    - software que controla armazenamento, segurança, concorrência e exposição dos dados
- Finalidade de bancos relacionais
    - persistir dados
    - permitir recuperação de dados
    - garantir consistência
    - controlar acessos

---

## Conceitos básicos de banco de dados

- Tipos clássicos:
  - **_Relational_**: dados em tabelas com chaves e restrições declarativas
  - **_Hierarchical_**: dados em árvore (parent/child)
  - **_Network_**: dados em grafo, registros conectados em grafo
  - **_Object_**: objetos persistidos com atributos e métodos
  - **_Relational_**: dados em tabelas com chaves e restrições declarativas
- Os **bancos de dados relacionais** prevalecem por combinarem integridade referencial, linguagem padrão (SQL) e feramentas maduras para auditoria e segurança

---

## Conceitos básicos de banco de dados relacionais

- Tabelas (**_relations_**/**_entities**): representam entidades; colunas (atributos) são tipadas e linhas (tuplas) guardam valores
- Restrições (**PRIMARY KEY**, **FOREIGN KEY**, **UNIQUE**, **CHECK**): preservam a integridade e descrevem relações
- **_Structured Query Language_** (**SQL**): descreve o que precisamos recuperar/modificar
- Operações CRUD em Java refletem comandos **SQL** executados via **JDBC**
    - **_Create_**: INSERT
  	- **_Read_**: SELECT
  	- **_Update_**: UPDATE
  	- **_Delete_**: DELETE

---

## Conceitos básicos de banco de dados relacionais

- **_Data Manipulation Language (DML)_**: 
    - SELECT, INSERT, UPDATE, DELETE
- **_Data Definition Language (DDL)_**: 
    - CREATE TABLE, ALTER TABLE, DROP
- **_Transaction Control Language (TCL)_**: 
    - COMMIT, ROLLBACK, SAVEPOINT

---

## Conceitos básicos de banco de dados relacionais

- ANSI (American National Standards Institute) mantém o SQL standard: maior portabilidade entre fornecedores

```sql
SELECT f.film_id, f.title, c.name AS category
FROM film f
JOIN film_category fc ON fc.film_id = f.film_id
JOIN category c ON c.category_id = fc.category_id
WHERE c.name = 'Comedy'
ORDER BY f.release_year DESC
LIMIT 5;
```

---

## Introdução do JDBC

- **_Java Database Connectivity_** (JDBC) é uma API para acesso a banco de dados relacionais
- Pacote **java.sql** define principais interfaces de acesso a banco de dados
    - [java.sql.DriverManager](https://docs.oracle.com/en/java/javase/21/docs/api/java.sql/java/sql/DriverManager.html)
    - [java.sql.DataSource](https://docs.oracle.com/en/java/javase/21/docs/api/java.sql/javax/sql/DataSource.html)
    - [java.sql.Connection](https://docs.oracle.com/en/java/javase/21/docs/api/java.sql/java/sql/Connection.html)
    - [java.sql.Statement](https://docs.oracle.com/en/java/javase/21/docs/api/java.sql/java/sql/Statement.html): executa SQL estático (sem parâmetros)
    - [java.sql.PreparedStatement](https://docs.oracle.com/en/java/javase/21/docs/api/java.sql/java/sql/PreparedStatement.html): executa comando SQL pré-compilado com placeholders (**?**)
    - [java.sql.CallableStatement](https://docs.oracle.com/en/java/javase/21/docs/api/java.sql/java/sql/CallableStatement.html): chama **stored procedures** ou **functions** com parâmetros de entrada e saída (**IN**/**OUT**)
    - [java.sql.ResultSet](https://docs.oracle.com/en/java/javase/21/docs/api/java.sql/java/sql/ResultSet.html): cursor que permite percorrer dados retornados
    - [java.sql.SQLException](https://docs.oracle.com/en/java/javase/21/docs/api/java.sql/java/sql/SQLException.html)

---

## Principais interfaces e métodos da JDBC API

<FigureWithCaption 
  src="images/jdbc-api.png" 
  alt="Principais interfaces e métodos da JDBC API"
  link=""
/>

---

## Principais interfaces e métodos da JDBC API

- **java.sql.DriverManager**
  - getConnection(String url, String user, String password)
- Formato da URL JDBC
```bash
protocol:provider:driver_type:database_specific_connection_details`
```
- Exemplo:
```
jdbc:postgresql://localhost:5432/dvdrental
```

- **java.sql.Connection**
  - createStatement, prepareStatement, prepareCall, setAutoCommit, commit, rollback, setTransactionIsolation, close
 
- Centralize informações de conexão em arquivo ou variáveis de ambiente

---

## Principais interfaces e métodos da JDBC API

- **java.sql.Statement**
    - **executeQuery**, **executeUpdate**, **execute**, **setFetchSize**
- **java.sql.PreparedStatement**
    - **setString**, **setInt**, **setObject**, **addBatch**, **executeUpdate**
- **java.sql.CallableStatement**
    - **registerOutParameter**, **setObject**, **getObject**, **execute**
- **java.sql.ResultSet**
    - Navegação **next/previous**
    - Leitura **getString/getInt**, **close**
    - Atualização **updateString**, **updateInt**, **updateRow**

---

## Introdução do JDBC

- **JDBC drivers** são bibliotecas que traduzem chamadas JDBC para o protocolo nativo do banco de dados
    - PostgreSQL, Oracle, MySQL
- Passos para conectar:
    - Certifique-se de que o driver JDBC esteja no **classpath**
    - Estabeleça a conexão com o banco de dados via **DriverManager.getConnection** ou **DataSource**
- Após a conexão:
    - Crie instruções SQL: use **Statements**, **PreparedStatements** ou **CallableStatements**
    - Execute instruções SQL
    - Processe os resultados da consulta: **ResultSet**
    - Feche os recursos JDBC: prefira usar bloco **try-with-resources**

---

## Estrutura básica

- Estrutura de um programa java que realiza operações em banco de dados

```java
try {
    /* establish database connection     */
    /* create and execute SQL statements */
    /* process results                   */
} catch (SQLException e) {
    /* handle any errors */
} finally {
    /* close result sets */
    /* close statements  */
    /* close connection  */
}
```

---

## Estutura com try-with-resources

- Use **try-with-resources** desde a abertura da conexão para garatia de fechamento dos recursos
    - dispensa uso de **finally** e previne vazamento (_leaks_)

```java
try (/* establish database connection     */
     /* create and execute SQL statements */) {
    /* process results */
} catch (SQLException e) {
    /* handle any exceptions */
} // implicit finally block closes resources
```

---

## Exemplo com Properties

- Uso da classe [**java.util.Properties**](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Properties.html) evita deixar informações sensíveis no código


```java
// DvdRentalApp.java
Properties props = new Properties();
try (var input = Files.newInputStream(Paths.get("db.properties"))) {
    props.load(input);
}

String url = props.getProperty("url");
String user = props.getProperty("user");
String password = props.getProperty("password");

try (Connection conn = DriverManager.getConnection(url, user, password)) {
    System.out.println("Conectado!");
}
```
---

## Exemplo de tratamento de exceção

- Trate comportamentos inesperados com exceções
- **SQLException** é a superclasse de todas as exceções do JDBC
    - oferece getSQLState, getErrorCode e getNextException para identificar a origem do problema
    
```java
try {
    /* execute JDBC operations */
} catch (SQLException e) {
    String state = e.getSQLState();
    int code = e.getErrorCode();
}
```

---

## Exemplo com Statement

1. **DriverManager.getConnection()** cria a **Connection**
2. **connection.createStatement()** fornece o **Statement**
3. Formule o comando SQL (strings constantes ou construídas dinamicamente)
4. Execute o comando SQL com **executeQuery**, **executeUpdate** ou **execute**

```java
try (Connection connection = DriverManager.getConnection(jdbcURL); // (1)
     Statement statement = connection.createStatement()) {          // (2)
    String sql = "SELECT * FROM film ORDER BY title";               // (3)
    statement.executeQuery(sql);                                    // (4)
} catch (SQLException e) {
    e.printStackTrace();
}
```

---

## Exemplo com PreparedStatament

- Use **PreparedStatement** sempre que houver parâmetros externos
- **Statement** deve ser usado apenas com comandos fixos.
- Parâmetros tipados (setString, setInt, setBigDecimal) protegem contra **_SQL injection_**
- Reduz custo em consultas repetitivas

```java
String sql = "SELECT actor_id, first_name, last_name FROM actor WHERE last_name = ?";

try (PreparedStatement ps = conn.prepareStatement(sql)) {
    ps.setString(1, "Chase");
    try (ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
            System.out.printf("%s %s%n",
                rs.getString("first_name"),
                rs.getString("last_name"));
        }
    }
}
```

--- 

## Exemplo com DataSource

- Em produção, prefira **java.sql.DataSource** para uso de _pool_ de conexão
    - depende de implementação concreta do driver do banco (ex. [PostgreSQL JDBC Driver](https://jdbc.postgresql.org/) )
```java

PGConnectionPoolDataSource dataSource = new PGConnectionPoolDataSource();

try (Connection conn = dataSource.getConnection();
     PreparedStatement ps = conn.prepareStatement(SQL)) {
    // ...
} catch (SQLException ex) {
    log.error("Erro JDBC", ex);
}
```

---

## Processando ResultSet

- **ResultSet** representa o cursor com os dados retornados. Principais métodos:
  - Navegação: **next**, **previous**, **absolute**, **afterLast**, **beforeFirst**
  - Leitura: **getString**, **getInt**, **getBigDecimal**, **getObject**
  - Atualização: **updateString**, **updateInt**, **updateRow**
- Customize o cursor ao criar o statement:
  - **ResultSet.TYPE_SCROLL_INSENSITIVE** para navegar (**previous**, **absolute**)
  - **ResultSet.CONCUR_UPDATABLE** para atualizar linhas diretamente
- Paginação eficiente: **stmt.setFetchSize(50)** + **LIMIT/OFFSET** na consulta

---

## Processando ResultSet

```java
try (PreparedStatement ps = conn.prepareStatement(
        sql,
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY)) {
    ps.setString(1, categoria);
    try (ResultSet rs = ps.executeQuery()) {
        rs.afterLast();
        while (rs.previous()) {
            // leitura invertida
        }
    }
}
```

- [**JdbcRowSet**](https://docs.oracle.com/en/java/javase/21/docs/api/java.sql.rowset/javax/sql/rowset/JdbcRowSet.html) encapsula **ResultSet** desconectado e serializável

---
layout: default
lesson: Metadados e capacidades
---

## Acesso aos Metadados do banco de dados

- **ResultSetMetaData**: nomes, tipos SQL, nulabilidade. Útil para gerar tabelas dinâmicas ou logs
- **DatabaseMetaData**: metadados do driver/SGBD (transações suportadas, palavras reservadas, catálogos)
- **ParameterMetaData**: útil ao construir SQL dinâmico validando tipos antes de setar parâmetros

```java
try (Statement stmt = conn.createStatement();
     ResultSet rs = stmt.executeQuery("SELECT * FROM film LIMIT 1")) {

    ResultSetMetaData meta = rs.getMetaData();
    int columns = meta.getColumnCount();
    for (int i = 1; i <= columns; i++) {
        System.out.printf("%s (%s)%n",
            meta.getColumnName(i),
            meta.getColumnTypeName(i));
    }
}
```

---

## Controle de transações

- Características de transação (AICD):
  - **_Atomicity_**: garantir consistência
  - **_Isolation_**: garantir disponibilidade
  - **_Consistency_**: garantir integridade
  - **_Durability_**: garantir persistência

```java
try (Connection conn = DriverManager.getConnection(url, user, password)) {
    conn.setAutoCommit(false);

    atualizarEstoque(conn);
    registrarHistorico(conn);

    conn.commit();
} catch (SQLException ex) {
    conn.rollback(); // garantir consistência
}
```

---

## Controle de transações

- **autoCommit=true** (padrão) executa cada statement como transação isolada
    - desative quando precisar agrupar
- Sempre realize **commit** explícito ou **rollback** no **catch**/**finally**
- Defina nível de isolamento conforme necessidade (**READ COMMITTED**, **SERIALIZABLE**)
- Log de auditoria ajuda a validar se operações múltiplas foram persistidas corretamente

---

## Atividade em Sala

- Configurar banco de dados conforme instruções no README.md
- Analisar e executar programs em **lectures/examples/14-jdbc/src/**
- Desenvolver programa especificado em **classroom/09-jdbc**

---
layout: backcover
---
