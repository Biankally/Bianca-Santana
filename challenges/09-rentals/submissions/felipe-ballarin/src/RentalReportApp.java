import static java.lang.System.out;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
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

    // Consulta SQL fornecida no README
    private static final String SQL_QUERY = 
        "SELECT c.first_name as \"Nome\", " +
        "       c.last_name as \"Sobrenome\", " +
        "       c.email as \"Email\", " +
        "       SUM(p.amount) as \"Valor Gasto\" " +
        "FROM rental r " +
        "JOIN customer c ON c.customer_id = r.customer_id " +
        "JOIN payment p ON p.customer_id = c.customer_id and p.rental_id = r.rental_id " +
        "GROUP BY c.first_name, c.last_name, c.email " +
        "HAVING SUM(p.amount) > ? " +
        "ORDER BY SUM(p.amount) desc;";

    public static void main(String[] args) {
        //validacao da linha de comando
        if (args.length < 1) { //verifica se fornceu um numero
            out.println("Erro: Por favor, forneça o valor mínimo como argumento");
            return;
        }

        double minAmount;
        try {
            minAmount = Double.parseDouble(args[0]); //transforma a string em double
        } catch (NumberFormatException e) {
            out.println("Erro: O argumento deve ser um número válido.");
            return;
        }

        Properties props = new Properties();
        List<RentalSummary> summaries = new ArrayList<>(); //arraylist p armazenar resultado da consulta

        //carrega  o dbproperties
        try (InputStream input = Files.newInputStream(Paths.get("db.properties"))) {
            
            props.load(input);
            
            //validacao de todas as chaves obrigatorias
            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");
            String csvPath = props.getProperty("csv.path");

            //out.println("___DEBUG___");
            //out.println("Arquivo lido: " + Paths.get("db.properties").toAbsolutePath());
            //out.println("User lido: " + user);

            if (url == null || user == null || password == null || csvPath == null) {
                out.println("Erro: Arquivo db.properties não tem todas as chaves obrigatórias.");
                return;
            }

            out.println("Se meu código está certo até aqui... \nEstamos conectando ao banco de dados...\n...");

            //try-with-resources
            try (Connection conn = DriverManager.getConnection(url, user, password);
                 PreparedStatement pstmt = conn.prepareStatement(SQL_QUERY)) {

                //parametro Having
                pstmt.setDouble(1, minAmount);

                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        String fName = rs.getString("Nome");
                        String lName = rs.getString("Sobrenome");
                        String email = rs.getString("Email");
                        double amount = rs.getDouble("Valor Gasto");

                        //converte p rentalsumary e armazena na coleçao
                        summaries.add(new RentalSummary(fName, lName, email, amount));
                    }
                }
            }

            out.println("Deu certo! \nNúmero de registros encontrados: " + summaries.size());

            //gravacao do CSV
            try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(csvPath))) {
          
                writer.write("Nome,Sobrenome,Email,Valor Gasto");
                writer.newLine();

                for (RentalSummary summary : summaries) {
                    writer.write(summary.toString());
                    writer.newLine();
                }
                out.println("Foi impresso o .csv corretamente com o nome: " + csvPath);
            }

        } catch (IOException e) {
            System.err.println("Erro de Arquivo: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Erro de Banco de Dados: " + e.getMessage());
        }
    }
}