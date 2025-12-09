import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.List;

public class FlixApp {

    // Ajuste se necessário (ou leia de variáveis de ambiente)
    private static final String URL  = "jdbc:postgresql://localhost:5432/dvdrental";
    private static final String USER = "postgres";
    private static final String PASS = "postgres";

    public static void main(String[] args) {
        // Caminho do arquivo (Paths.get("caminho_do_arquivo") como pedido)
        Path file = (args.length > 0)
                ? Paths.get(args[0])
                : Paths.get("new_films.txt"); // padrão na pasta onde você roda

        try {
            // 1) Ler filmes do TXT
            List<Film> filmes = FilmFileReader.read(file);
            System.out.println("Lidos do arquivo: " + filmes.size() + " filmes.");

            // 2) Conectar via JDBC puro
            try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {

                // 2.1) Importar (INSERT) com PreparedStatement e batch
                String insertSql = """
                    INSERT INTO film (title, language_id, rental_duration, rental_rate, replacement_cost,
                                      rating, rental_rate_last_update)
                    VALUES (?, ?, ?, ?, ?, 'G', now())
                    """;
                // a coluna rental_rate_last_update é opcional; pode remover se não existir no seu schema

                try (PreparedStatement ps = con.prepareStatement(insertSql)) {
                    for (Film f : filmes) {
                        ps.setString(1, f.getTitle());
                        ps.setInt(2, f.getLanguageId());
                        ps.setInt(3, f.getRentalDuration());
                        ps.setDouble(4, f.getRentalRate());
                        ps.setDouble(5, f.getReplacementCost());
                        ps.addBatch();
                    }
                    int[] counts = ps.executeBatch();
                    System.out.println("Inseridos: " + counts.length + " filmes.");
                }

                // 2.2) Atualizar rental_rate em +10%
                String updateSql = "UPDATE film SET rental_rate = rental_rate * 1.10";
                try (PreparedStatement ps = con.prepareStatement(updateSql)) {
                    int updated = ps.executeUpdate();
                    System.out.println("Atualizados (rental_rate +10%): " + updated + " registros.");
                }

                // 2.3) Listar title e rental_rate onde rental_duration = 99
                String selectSql = "SELECT title, rental_rate FROM film WHERE rental_duration = 99 ORDER BY title";
                try (PreparedStatement ps = con.prepareStatement(selectSql);
                     ResultSet rs = ps.executeQuery()) {
                    System.out.println("\nFilmes com rental_duration = 99:");
                    int n = 0;
                    while (rs.next()) {
                        String title = rs.getString("title");
                        double rate = rs.getDouble("rental_rate");
                        System.out.printf("%s | R$ %.2f%n", title, rate);
                        n++;
                    }
                    if (n == 0) System.out.println("(nenhum encontrado)");
                }
            }
        } catch (Exception e) {
            System.out.println("Falha: " + e.getMessage());
        }
    }
}
