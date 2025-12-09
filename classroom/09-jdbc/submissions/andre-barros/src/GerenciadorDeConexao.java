import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class GerenciadorDeConexao {

    private static Properties configuracao;
    private static final String ARQUIVO_CONFIG = "config.properties";

    static {
        configuracao = new Properties();
        // Nota: O getResourceAsStream vai procurar no diretório raiz do classpath (onde os .class estão)
        try (InputStream entrada = GerenciadorDeConexao.class.getClassLoader().getResourceAsStream(ARQUIVO_CONFIG)) {
            if (entrada == null) {
                System.err.println("ERRO: Arquivo '" + ARQUIVO_CONFIG + "' não encontrado.");
                throw new ExceptionInInitializerError("Falha ao carregar configurações.");
            }
            configuracao.load(entrada);
        } catch (Exception e) {
            throw new ExceptionInInitializerError("Falha ao inicializar GerenciadorDeConexao: " + e.getMessage());
        }
    }

    public static Connection getConnection() throws SQLException {
        String url = configuracao.getProperty("db.url");
        String usuario = configuracao.getProperty("db.usuario");
        String senha = configuracao.getProperty("db.senha");
        
        return DriverManager.getConnection(url, usuario, senha);
    }
}