package com.jdbc09;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBConfig {
    
    // Nome do arquivo de configuração, que está na pasta 'resources'
    private static final String CONFIG_FILE = "db.properties";
    private static Properties properties = new Properties();

    // Bloco estático é executado apenas uma vez quando a classe é carregada
    static {
        // Usa o ClassLoader para encontrar o arquivo no 'classpath' (dentro de target/classes)
        try (InputStream is = DBConfig.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            
            if (is == null) {
                // Se o arquivo não for encontrado (is é null), imprime uma mensagem de erro
                System.err.println("Erro FATAL: Arquivo db.properties NÃO ENCONTRADO no classpath (target/classes).");
            } else {
                // Se o InputStream for válido, carrega as propriedades
                properties.load(is);
                System.out.println("DEBUG: Arquivo db.properties lido com sucesso.");
            }
        } catch (IOException e) {
            // Captura erros de I/O (leitura)
            System.err.println("Erro ao carregar o arquivo de configuração: " + e.getMessage());
        }
    }

    // Métodos estáticos para acesso seguro às propriedades lidas
    
    public static String getUrl() { 
        String url = properties.getProperty("db.url");
        if (url == null) {
            // Se a chave não existir, o valor é null, o que causaria o SQLException
            System.err.println("Erro: A chave 'db.url' não foi encontrada no db.properties.");
        }
        return url; 
    }

    public static String getUser() { 
        return properties.getProperty("db.user"); 
    }

    public static String getPassword() { 
        return properties.getProperty("db.password"); 
    }
}