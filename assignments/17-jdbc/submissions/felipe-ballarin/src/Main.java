import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Ler o arquivo de texto
        
        String caminhoArquivo = "../../data/new_films.txt"; //volta 2 pastas e entra em data

        FilmReader reader = new FilmReader();
        List<Film> films = reader.readFilms(caminhoArquivo);
        
        if (films.isEmpty()) {
            System.out.println("Nenhum filme lido. Verifique o caminho do arquivo: " + caminhoArquivo);
            return;
        }

        System.out.println("Lidos " + films.size() + " filmes do arquivo.");

        try (Connection conn = Database.getConnection()) {
            
            // PROTECAO: ve se o idioma 3 existe, Se nao existir vai bugar
            String sqlLang = "INSERT INTO language (language_id, name) VALUES (3, 'Portuguese') ON CONFLICT (language_id) DO NOTHING";
            try (Statement st = conn.createStatement()) { st.execute(sqlLang); }
            
            // _______________  INSERT no SUPABASE ___________________
            System.out.println("Importando filmes para o Supabase...");
            String sqlInsert = "INSERT INTO film (title, language_id, rental_duration, rental_rate, replacement_cost) VALUES (?, ?, ?, ?, ?)";
            
            try (PreparedStatement ps = conn.prepareStatement(sqlInsert)) {
                for (Film f : films) {
                    ps.setString(1, f.getTitle());
                    ps.setInt(2, f.getLanguageId());
                    ps.setInt(3, f.getRentalDuration());
                    ps.setDouble(4, f.getRentalRate());
                    ps.setDouble(5, f.getReplacementCost());
                    ps.executeUpdate();
                }
                System.out.println("Filmes importados com sucesso!");
            }

            // ___________________ UPDATE de PRECOS________________
            System.out.println("Atualizando precos em 10%...");
            String sqlUpdate = "UPDATE film SET rental_rate = rental_rate * 1.1";
            try (PreparedStatement ps = conn.prepareStatement(sqlUpdate)) {
                int modificados = ps.executeUpdate();
                System.out.println("Precos atualizados! Filmes afetados: " + modificados);
            }

            // ____________LISTAR FILMES COM DURACAO 99_______________
            System.out.println("\n--- FILMES COM DURACAO DE LOCACAO = 99 ---");

            String sqlSelect = "SELECT title, rental_rate FROM film WHERE rental_duration = 99";
            
            try (PreparedStatement ps = conn.prepareStatement(sqlSelect);
                 ResultSet rs = ps.executeQuery()) {
                
                boolean achou = false;
                while (rs.next()) {
                    System.out.printf("Filme: %-30s | Preco: %.2f%n", rs.getString("title"), rs.getDouble("rental_rate"));
                    achou = true;
                }
                if (!achou) {
                    System.out.println("(Nenhum filme encontrado com rental_duration = 99)");
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro no Banco de Dados:");
            e.printStackTrace();
        }
    }
}