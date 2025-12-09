## Copa IDP

O programa **Copa IDP**  tem como finalidade gerenciar o torneio esportivo entre times formados por alunos, registrando atletas, resultados de partidas e gerando um relatório consolidado.

### Requisitos

1. Cadastro de Times e Atletas
* Cada time possui um nome único.
* Um time pode conter vários atletas, identificados por nome.
* A lista de atletas deve ser exibida em ordem alfabética e sem duplicações.

1. Registro de Partidas
* Cada partida é disputada entre dois times.
* Um dos times deve ser declarado vencedor da partida.
* O time vencedor recebe **3 pontos**.
* O programa registra todas as partidas disputadas.

1. Consolidação dos Resultados
* Para cada time, deve ser possível visualizar:
  * A pontuação acumulada.
  * A lista de atletas.
  * O histórico de partidas (com adversário e resultado: venceu/perdeu).
* O programa deve gerar um relatório contendo:
  * Informações completas de cada time, com as respectivas pontuações, atletas e partidas jogadas, bem como listar todas partidas do campeonato, conforme exemplo abaixo:

### 5. Geração de Relatório

* O relatório deve ser gravado automaticamente no arquivo `relatorio_copa_idp.txt` no mesmo diretório do programa.
* O formato deve possuir o seguinte formato:
```
Relatório da Copa IDP

Time1 - 3 pontos
- Atletas:
  Atleta1
  Atleta2
- Partidas:
 - Time2 - Venceu
 - Time3 - Perdeu

Time2 - 0 pontos
- Atletas:
  Atleta3
  Atleta4
- Partidas:
 - Time1 - Perdeu
 - Time3 - Perdeu

Time3 - 6 pontos
- Atletas:
  Atleta5
  Atleta6
- Partidas:
 - Time2 - Venceu
 - Time1 - Venceu

Todas as Partidas:
Time1 vs Time2 - Vencedor: Time1  
Time2 vs Time3 - Vencedor: Time3  
Time1 vs Time3 - Vencedor: Time3  

```

### Requisitos de implementação

1. O programa deve possuir as seguintes classes `Time`, `Partida`, `CopaIDPApp`
* A classe `Time` deve possuir
    * atributos:
        * `String nome`
        * `int pontuacao`
        * `SortedSet<String> atletas`: armazena a lista ordenada de atletas
    * métodos:
        * `String getNome()`
        * `int getPontuacao()`
        * `void adicionarAtleta(String nomeAtleta)`
        * `Set<String> getAtletas`
        * `void adicionarPontuacao(int pontos)` 
* A classe `Partida` deve possuir
    * atributos:
        * `Time time1`
        * `Time time2`
        * `Time vencedor`
        * `List<Partida> historico`: armazena o histórico de partida
        * `Map<Time, List<String>> resultadosPorTime`: armazena a lista de resultados por time
    * métodos:
        * `void registrarResultado()`
        * `getResultadoPara(Time time)`
        * `List<Partida> getHistorico()`
        * `List<String> getResultadosDoTime(Time time)`
        * `Time getTime1()`
        * `Time getTime2()`
        * `Time getVencedor()`
* A classe coda `CopaIDPApp` deve criar diretamente, sem necessidade de coletar dados no terminal, no mínimo 3 times, com no mínimo 2 atletas cada time, e criar no mínimo 4 partidas e gravar o relatório.
    * Para gravar o relatório utilize as classes `java.nio.file.Files`, `java.nio.file.Path` e `java.nio.file.Paths` em bloco `try-with-resources` para garantir fechamento automático.