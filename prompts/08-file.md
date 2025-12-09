## Manipulação de arquivos e serialização de objetos

### Manipulação Básica de Arquivos (Create, Read, Write, Update)

#### Criação e Escrita em Arquivos de Texto com pacote `java.nio`

```
Explique como realizar a criação e escrita em arquivos de texto com classes e interfaces do pactore `java.nio`, apresentando detalhadamente informações para os itens abaixo

1. O que é o pacote `java.nio` e como ela pode ser usada para criar um arquivo de texto em Java? 
2. O que são as classes `Path` e `Files` no pacote `java.nio.file`? Defina o que é um objeto Path e como ele se relaciona com os métodos da classe Files.
3. Apresente e explique os principais métodos as classes `Path` e `Files` no pacote `java.nio.file`
4. Explique o papel da classe Files no pacote java.nio.file. Quais problemas ela resolve em comparação com as classes tradicionais do pacote java.io?
5. Diferencie o uso de File (do pacote java.io) e Path/Files (do pacote java.nio), destacando vantagens, limitações e casos de uso.
6. Escreva um exemplo que obtenha o nome do arquivo, tamanho e se ele é legível/escrevível.
7. Escreva um programa Java que crie um arquivo chamado `dados.txt` e grave três linhas de texto.
8. O que acontece se você executar o programa duas vezes? O conteúdo será sobrescrito?
9. Descreva a importância da API NIO.2 introduzida no Java 7. Como ela modernizou a manipulação de arquivos e diretórios em Java?
10. Explique a diferença entre operações síncronas e assíncronas na API NIO, destacando exemplos práticos.
11. Gere exemplos de código que demonstrem:
- Criação e deleção de arquivos com Files.createFile() e Files.delete().
- Leitura e escrita de texto com Files.readString(), Files.write(), Files.newBufferedReader(), e Files.newBufferedWriter().
- Criação de diretórios com Files.createDirectory() e Files.createDirectories().
- Mostre um exemplo que escreva texto em um arquivo sem sobrescrever o conteúdo anterior, utilizando StandardOpenOption.APPEND.
- Mostre um exemplo que liste todos os arquivos de um diretório com Files.newDirectoryStream().
- Apresente um código com erro comum (ex: tentativa de ler arquivo inexistente) e demonstre como tratá-lo corretamente usando try-catch e IOException.
```

#### Listagem de diretórios com `DirectoryStream`

```
Explique como realizar a listagem de diretórios com `DirectoryStream`

1. Como listar todos os arquivos de um diretório usando NIO.2?
2. Escreva um código que imprima todos os arquivos `.txt` de um diretório especificado.
```

#### Criação, cópia, movimentação e exclusão com NIO.2

```
Explique como realizar a criação, cópia, movimentação e exclusão com NIO.2

1. Demonstre como criar diretórios e arquivos usando `Files.createFile` e `Files.createDirectory`.
2. Como copiar, mover e excluir arquivos com NIO.2? Mostre exemplos.
```

#### Diferença entre Arquivos Texto e Binários

##### Conceito e diferenças práticas

```
1. Qual a diferença entre arquivos texto e binários?
2. Dê exemplos reais de cada tipo de arquivo.
3. Por que arquivos binários são mais eficientes para dados estruturados?
```

##### Leitura/Escrita de arquivos binários com `DataInputStream` e `DataOutputStream`

```
1. Explique o funcionamento das classes `DataInputStream` e `DataOutputStream`.
2. Implemente um programa que grave uma lista de inteiros em um arquivo binário e outro que leia.
```

#### Uso do `Formatter` e `Scanner` para Entrada e Saída

##### Escrita com `Formatter`

```
1. O que é a classe `Formatter` e quais suas vantagens?
2. Escreva um programa que utilize `Formatter` para gravar um arquivo com dados tabulados (nome, idade, saldo).
```

##### Leitura com `Scanner`

```
1. Demonstre como utilizar `Scanner` para ler o conteúdo desse mesmo arquivo e imprimir os dados no console.
2. Como lidar com erros de leitura e formatação?
```

#### Serialização de Objetos

```
Explique de maneira detalhada o conceito de serialização de objetos e responda as questões:

1. O que é serialização em Java?
2. Quais são os benefícios da serialização?
```