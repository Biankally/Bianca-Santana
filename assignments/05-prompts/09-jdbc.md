# Acesso a banco de dados em Java com JDBC

## Introdução aos Bancos de Dados Relacionais

- Defina banco de dados relacional, explique o modelo de tabelas/linhas/colunas e justifique por que ele permanece dominante em sistemas corporativos.
- Compare entre bancos relacionais e bancos NoSQL (documentos, chave-valor), destacando vantagens e limitações de cada abordagem em cenários distintos.
- Gere um esquema simples (tabelas Livro, Autor, Editora) com chaves primárias/estrangeiras, incluindo um diagrama textual ou descrição formal.
- Identifique entidades, relacionamentos e regras de integridade indispensáveis para o desenvolvimento de uma livraria on-line
- Explique por que integridade referencial evita inconsistências e quais sinais indicam a necessidade de revisar o modelo.

## Introdução ao JDBC

- Explique o papel do JDBC na pilha Java, sua arquitetura de drivers e como ele abstrai BDs distintos.
- Gere um snippet mínimo que carrega o driver e imprime a versão suportada, comentando cada linha.

## Principais classes da JDBC API para acesso a banco de dados
- Descreva os papéis de `DriverManager`, `DataSource`, `Connection`, `Statement`, `PreparedStatement`, `CallableStatement` e `ResultSet`.
- Compare o uso de `DriverManager` vs `DataSource` em termos de pooling e configuração corporativa.
- Crie diagrama textual mostrando o ciclo de vida de uma consulta (obter conexão → criar statement → executar → processar resultado → fechar recursos).
- Implemente uma classe utilitária `JdbcUtils` que centraliza obtenção e fechamento seguro de recursos, detalhando métodos e responsabilidades.

## Como conectar a um banco de dados
- Explique o formato e papel da URL JDBC, propriedades (usuário, senha, timezone) e etapas para abrir conexões.
- Discuta o uso de `DataSource` com pools e implicações de thread-safety.
- Gere um código completo que lê credenciais de um arquivo de propriedades estabelece conexão segura.
- Descreva os passos para configurar conexão local com PostgreSQL, listando comandos e testes de verificação.
- Como uma aplicação que precisa alternar entre ambientes (dev/stage/prod) pode ser parametrizada.
- Descrever como garantir e confirmar que todas as conexões são fechadas mesmo após exceções.

## Como executar comandos SQL (seleção, inserção, atualização e deleção)
- Explique as operações DQL e DML e quando preferir `Statement` ou `PreparedStatement`.
- Compare entre execução síncrona e batch, com impactos em performance e atomicidade.
- Gere código que execute SELECT/INSERT/UPDATE/DELETE em uma mesma classe, com tratamento de erros.
- Implemente batch insert com PreparedStatement, medindo ganho de desempenho e relatando resultados.
- Identifique erros comuns (SQL injection, falta de parâmetros) e explique como evitá-los.

## Como processar os resultados de uma query
- Explique o papel e funcionamento do cursor, posicionamento no `ResultSet` e tipos (`TYPE_FORWARD_ONLY`, etc.).
- Compare entre `ResultSet` conectados e `RowSet` desconectados, com critérios de escolha.
- Gere código que percorre `ResultSet`, converte em objetos de domínio e trata valores nulos.
- Construa um mapper genérico (`ResultSet` → DTO) e demostre como usar em diferentes consultas.
- Que abordagem pode ser adotada para paginação no backend, demonstre uma abordagem com `LIMIT/OFFSET` e `ResultSet` rolável.
- Como evitar `ResultSet` aberto sem fechamento
- Elabore um checklist de boas práticas.

## O que é controle de transação
- Definar o que é controle de  de transação, propriedades ACID e diferencie commits automáticos e manuais.
- Explique sobre níveis de isolamento (READ COMMITTED, REPEATABLE READ, SERIALIZABLE).
- Explique e demostre efeitos de dirty read alterando o isolamento.
- Quais propriedades ACID considera mais desafiadoras de manter e por quê.

## Como implementar controle de transação em Java
- Detalhe o fluxo `setAutoCommit(false)`, `commit()` e `rollback()`, além de blocos try-with-resources.
- Analise quando usar `Savepoint` e como lidar com exceções verificadas/não verificadas dentro da transação.
- Gere um exemplo completo de transferência bancária com rollback em caso de exceção.
