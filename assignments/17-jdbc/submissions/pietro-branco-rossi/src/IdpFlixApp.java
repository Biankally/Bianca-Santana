import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class IdpFlixApp {

    public static void main(String[] args) {
        String arquivoEntrada = "../../../data/new_films.txt";
        FilmReader reader = new FilmReader();
        List<Film> novosFilmes = reader.readFilms(arquivoEntrada);

        System.out.println("Lidos " + novosFilmes.size() + " filmes do arquivo.");

        // Bloco try-with-resources para garantir fechamento da conexão
        try (Connection conn = DatabaseConfig.getConnection()) {
            
            // --- 1. IMPORTAÇÃO (INSERT) ---
            System.out.println("\n--- 1. Importando Filmes ---");
            String sqlInsert = "INSERT INTO film (title, language_id, rental_duration, rental_rate, replacement_cost) VALUES (?, ?, ?, ?, ?)";
            
            try (PreparedStatement stmt = conn.prepareStatement(sqlInsert)) {
                for (Film f : novosFilmes) {
                    stmt.setString(1, f.getTitle());
                    stmt.setInt(2, f.getLanguageId());
                    stmt.setInt(3, f.getRentalDuration());
                    stmt.setDouble(4, f.getRentalRate());
                    stmt.setDouble(5, f.getReplacementCost());
                    stmt.addBatch(); 
                }
                int[] rows = stmt.executeBatch();
                System.out.println("Filmes inseridos com sucesso: " + rows.length);
            }

            // --- 2. ATUALIZAÇÃO (+10%) ---
            System.out.println("\n--- 2. Atualizando Preços (+10%) ---");
            String sqlUpdate = "UPDATE film SET rental_rate = rental_rate * 1.1";
            
            try (PreparedStatement stmt = conn.prepareStatement(sqlUpdate)) {
                int rowsUpdated = stmt.executeUpdate();
                System.out.println("Preços atualizados. Total de filmes afetados: " + rowsUpdated);
            }

            // --- 3. LISTAGEM ---
            System.out.println("\n--- 3. Filmes com Duração de Locação = 99 ---");
            String sqlSelect = "SELECT title, rental_rate FROM film WHERE rental_duration = ?";
            
            try (PreparedStatement stmt = conn.prepareStatement(sqlSelect)) {
                stmt.setInt(1, 99);
                ResultSet rs = stmt.executeQuery();
                
                boolean encontrou = false;
                while (rs.next()){
                    System.out.println("Filme: " + rs.getString("title") + " | Valor: " + rs.getDouble("rental_rate"));
                    encontrou = true;
                }
                if (!encontrou){
                    System.out.println("Nenhum filme encontrado com duração de locação igual a 99.");
                }
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}