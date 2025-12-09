import java.util.Date;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.BasicFileAttributes;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileReader;

import java.io.FileWriter;

import java.io.IOException;
import java.io.FileNotFoundException;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static java.lang.System.out;


public class FileApp {
    
  public static void main(String[] args){

    out.println("________________________________________________");
    out.println("1. List Files in Directory: ");

    File file = new File("../../data");
    for(String nomes:file.list()){
        out.println(nomes);
    }


    out.println("________________________________________________");
    out.println("2. Check Path Exists: ");

    out.println("testando com um diretorio nada a ver '/home/students/xyz.txt' ");
    File my_file_dir = new File("/home/students/xyz.txt");
      if (my_file_dir.exists()) 
        {
        out.println("O diretorio ou arquivo existe.\n");
        } 
      else
      {
        out.println("O diretorio ou arquivo nao existe.\n");
      }

    out.println("testando com clients.txt");
    File clients_dir = new File("../../data/clients.txt");
      if (clients_dir.exists()) 
        {
        out.println("O arquivo existe.");
        } 
      else
      {
        out.println("O arquivo nao existe.");
      }


    out.println("________________________________________________");
    out.println("3. Read File Line by Line: ");

    BufferedReader br = null;
    String strLine = "";
    try {
        br = new BufferedReader( new FileReader("../../data/clients.txt"));
        while( (strLine = br.readLine()) != null){
            out.println(strLine);
        }
        br.close();
    } catch (FileNotFoundException e) {
        System.err.println("File not found");
    } catch (IOException e) {
        System.err.println("Unable to read the file.");
    }


    out.println("________________________________________________");
    out.println("4. Append Text to File: ");

    StringBuilder sb = new StringBuilder();
    
    try{
      String filename= "/home/students/myfile.txt";
      FileWriter fw = new FileWriter(filename,false); 
      //appends the string to the file
      fw.write("Python Exercises\n");
      fw.close();

      br = new BufferedReader(new FileReader("/home/students/myfile.txt"));

      strLine = br.readLine(); 

      //read the file content
      while (strLine != null){
        sb.append(strLine);
        sb.append(System.lineSeparator());
        strLine = br.readLine();
        System.out.println(strLine);
      }
      br.close();   

    }catch(IOException ioe){
      System.err.println("IOException: " + ioe.getMessage());
    }


    out.println("________________________________________________");
    out.println("5. Write Text File: ");

    try {
      Path newClientPath = Paths.get("../../data/clients_new.txt");
      List<String> lines = Arrays.asList(
        "ID: 1, Nome: Novo Cliente 1, Email: cliente1@email.com",
        "ID: 2, Nome: Novo Cliente 2, Email: cliente2@email.com"
      );

      Files.write(newClientPath, lines, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
      out.println("Arquivo 'clients_new.txt' gravado com sucesso.");

      out.println("Lendo o arquivo 'clients_new.txt':");
      List<String> allLines = Files.readAllLines(newClientPath);
      for (String line : allLines) {
        out.println(line);
      }

    } catch (IOException e) {
      System.err.println("Erro de E/S ao escrever/ler o arquivo: " + e.getMessage());
    }


    out.println("________________________________________________");
    out.println("6. Copy File: ");

    try {
      Path sourceFile = Paths.get("../../data/clients.txt");
      Path targetFile = Paths.get("../../data/backup/clients_backup.txt");
      
      Files.createDirectories(targetFile.getParent()); 

      Files.copy(sourceFile, targetFile, StandardCopyOption.REPLACE_EXISTING);
      out.println("Arquivo 'clients.txt' copiado para 'backup/clients_backup.txt' com sucesso.");

    } catch (IOException e) {
      System.err.println("Erro de E/S ao copiar o arquivo: " + e.getMessage());
    }


    out.println("________________________________________________");
    out.println("7. Delete: ");

    try {
      Path oldFile = Paths.get("../../data/backup/old-clients.txt");
      Files.delete(oldFile);
      out.println("Arquivo 'old-clients.txt' deletado com sucesso.");

    } catch (NoSuchFileException e) {
      System.err.println("Falha ao deletar: Arquivo 'old-clients.txt' nao encontrado.");
    } catch (IOException e) {
      System.err.println("Falha de permissao ou outro erro de E/S ao deletar: " + e.getMessage());
    }


    out.println("________________________________________________");
    out.println("8. Directory Tree Walk: ");

    try {
      Path dataDir = Paths.get("../../data");
      Instant twentyFourHoursAgo = Instant.now().minus(24, ChronoUnit.HOURS);
      out.println("Arquivos modificados nas ultimas 24h no diretorio 'data' (e subdiretorios):");

      try (Stream<Path> stream = Files.walk(dataDir)) {
        stream.filter(Files::isRegularFile) // Apenas arquivos
          .filter(path -> {
            try {
              // Filtra por data de modificação
              return Files.getLastModifiedTime(path).toInstant().isAfter(twentyFourHoursAgo);
            } catch (IOException e) {
              System.err.println("Nao foi possivel ler atributos de: " + path);
              return false;
            }
          })
          .forEach(path -> {
            try {
                // Imprime nome e tamanho
                out.println(dataDir.relativize(path) + " (Tamanho: " + Files.size(path) + " bytes)");
            } catch (IOException e) {
                System.err.println("Nao foi possivel ler o tamanho de: " + path);
            }
          });
      }

    } catch (IOException e) {
      System.err.println("Erro ao percorrer o diretorio 'data': " + e.getMessage());
    }


    out.println("________________________________________________");
    out.println("9. File Attributes and Metadata: ");

    try {
      Path clientFile = Paths.get("../../data/clients.txt");
      BasicFileAttributes attrs = Files.readAttributes(clientFile, BasicFileAttributes.class);

      out.println("Atributos do arquivo 'clients.txt':");
      out.println("Tamanho: " + attrs.size() + " bytes");
      out.println("Data de Criacao: " + attrs.creationTime());
      out.println("Ultima Modificacao: " + attrs.lastModifiedTime());
      out.println("Ultimo Acesso: " + attrs.lastAccessTime());
      out.println("E um diretorio? " + attrs.isDirectory());
      out.println("E um arquivo regular? " + attrs.isRegularFile());

    } catch (IOException e) {
      System.err.println("Nao foi possivel ler os atributos do arquivo 'clients.txt': " + e.getMessage());
    }


  }
}
