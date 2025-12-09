package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBConfig {

    private static final Properties PROPERTIES = new Properties();
    private static final String PROPERTIES_FILE = "db.properties";

    static {
        try (InputStream input = DBConfig.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            if (input == null) {
                System.err.println("Erro: Arquivo '" + PROPERTIES_FILE + "' não encontrado no classpath!");
            } else {
                PROPERTIES.load(input);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo de propriedades: " + e.getMessage());
        }
    }

    public static String getDbUrl() {
        return PROPERTIES.getProperty("db.url");
    }

    public static String getDbUser() {
        return PROPERTIES.getProperty("db.user");
    }

    public static String getDbPassword() {
        return PROPERTIES.getProperty("db.password");
    }
}