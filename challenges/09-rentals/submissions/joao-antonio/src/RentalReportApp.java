import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class RentalReportApp {

    private static final String DB_PROPERTIES_FILE = "db.properties";
    private static final String CSV_HEADER = "Nome,Sobrenome,Email,Valor Gasto";
    
    // Consulta SQL fornecida com um placeholder '?' para o parâmetro HAVING
    private static final String SQL_QUERY = 
        "SELECT c.first_name as \"Nome\", c.last_name as \"Sobrenome\", c.email as \"Email\", SUM(p.amount) as \"Valor Gasto\" " +
        "FROM rental r JOIN customer c ON c.customer_id = r.customer_id JOIN payment p ON p.customer_id = c.customer_id and p.rental_id = r.rental_id " +
        "GROUP BY c.first_name, c.last_name, c.email " +
        "HAVING SUM(p.amount) > ? " +
        "ORDER BY SUM(p.amount) desc;";

    public static void main(String[] args) {
        // 1. Validar Argumentos de Linha de Comando
        if (args.length == 0) {
            System.err.println("ERRO: O valor mínimo gasto é obrigatório como argumento (ex.: java RentalReportApp 100.00)");
            return;
        }

        double minAmount;
        try {
            minAmount = Double.parseDouble(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("ERRO: O argumento deve ser um número válido para o valor mínimo gasto.");
            return;
        }

        // 2. Carregar o arquivo db.properties e validar chaves
        Properties props = loadProperties(DB_PROPERTIES_FILE);
        if (props == null) return;
        
        String dbUrl = props.getProperty("db.url");
        String dbUser = props.getProperty("db.user");
        String dbPassword = props.getProperty("db.password");
        String csvPath = props.getProperty("csv.path");

        if (dbUrl == null || dbUser == null || dbPassword == null || csvPath == null) {
            System.err.println("ERRO: O arquivo db.properties deve conter as chaves 'db.url', 'db.user', 'db.password' e 'csv.path'.");
            return;
        }

        // 3. Executar a consulta e armazenar em memória
        List<RentalSummary> summaries = executeQuery(dbUrl, dbUser, dbPassword, minAmount);

        if (summaries == null) {
            System.out.println("Não foi possível gerar o relatório devido a um erro na conexão/consulta.");
            return;
        }
        
        if (summaries.isEmpty()) {
            System.out.println("Nenhum cliente encontrado com gasto superior a R$" + String.format("%.2f", minAmount));
            return;
        }
        
        // 4. Gravar o arquivo CSV
        try {
            writeCsvFile(csvPath, summaries);
        } catch (Exception e) {
        }
        
        System.out.println("✅ Relatório de Gastos por Cliente gerado com sucesso em: " + csvPath);
        System.out.println("Total de registros: " + summaries.size());
    }

    /**
     * Carrega o arquivo de propriedades e valida se as chaves existem.
     */
    private static Properties loadProperties(String filename) {
        Properties props = new Properties();
        Path path = Paths.get(filename);
        
        try (InputStream input = Files.newInputStream(path)) {
            props.load(input);
            return props;
        } catch (IOException e) {
            System.err.println("ERRO ao carregar o arquivo de propriedades '" + filename + "'. Verifique se ele está na raiz do projeto.");
            System.err.println("Detalhe: " + e.getMessage());
            return null;
        }
    }

    /**
     * Executa a consulta SQL e mapeia o resultado para a coleção RentalSummary.
     */
    private static List<RentalSummary> executeQuery(String url, String user, String password, double minAmount) {
        List<RentalSummary> results = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(SQL_QUERY)) {

            stmt.setDouble(1, minAmount);
            
            System.out.println("Conectado ao banco de dados. Executando consulta com valor mínimo: R$" + String.format("%.2f", minAmount));

            try (ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    String firstName = rs.getString("Nome");
                    String lastName = rs.getString("Sobrenome");
                    String email = rs.getString("Email");
                    
                    double amount = rs.getDouble("Valor Gasto");

                    results.add(new RentalSummary(firstName, lastName, email, amount));
                }
            }

        } catch (SQLException e) {
            System.err.println("ERRO de banco de dados ao executar a consulta. Verifique os logs do sistema para detalhes.");
            
            e.printStackTrace(System.err);
            
            return null;
        } catch (Exception e) {
            System.err.println("Ocorreu um erro inesperado: " + e.getMessage());
            return null;
        }
        return results;
    }

    /**
     * Grava a lista de objetos RentalSummary no arquivo CSV.
     */
    private static void writeCsvFile(String pathString, List<RentalSummary> summaries) throws IOException {
        Path path = Paths.get(pathString);
        
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {

            writer.write(CSV_HEADER);
            writer.newLine();

            for (RentalSummary summary : summaries) {
                writer.write(summary.toString());
                writer.newLine();
            }
        }
    }
}