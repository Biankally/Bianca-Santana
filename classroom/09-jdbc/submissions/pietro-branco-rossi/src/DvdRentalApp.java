import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.Properties;

public class DvdRentalApp {

    public static void main(String[] args) {
        
        FilmDAO dao = new FilmDAO();

        try {
            // 1. Inserir Filme
            System.out.println("--- 1. Inserindo Filme ---");
            int novoId = dao.insertFilm("O Resgate do Soldado Ryan", "Guerra", 1998);
            System.out.println("Filme inserido com ID: " + novoId);

            // 2. Busca Filme por ID
            System.out.println("\n--- 2. Buscando Filme ---");
            dao.getFilmById(novoId);

            // 3. Lista Atores de um filme 
            System.out.println("\n--- 3. Atores do Filme ID 1 ---");
            dao.listActorsByFilmId(1);

            // 4. Excluir Ator
	    int idParaDeletar = 201; 
            System.out.println("\n--- 4. Tentando Excluir Ator ID " + idParaDeletar + " ---");
            dao.deleteActor(idParaDeletar); 

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// --- Classe para Log de Auditoria ---
class AuditLogger {
    private static final Path LOG_PATH = Paths.get("audit.log");

    public static void log(String acao, String detalhes) {
        String timestamp = LocalDateTime.now().toString();
        String linha = String.format("[%s] ACAO: %s | DETALHES: %s%n", timestamp, acao, detalhes);
        
        try {
            Files.write(LOG_PATH, linha.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Falha ao gravar log: " + e.getMessage());
        }
    }
}

// --- Classe de Conexão ---
class DatabaseConfig {
    public static Connection getConnection() throws SQLException, IOException {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("db.properties")) {
            props.load(fis);
        }
        return DriverManager.getConnection(props.getProperty("url"), props);
    }
}

// --- DAO (Data Access Object) ---
class FilmDAO {

    // 1. Inserir Filme
    public int insertFilm(String title, String description, int releaseYear) {
        String sql = "INSERT INTO film (title, description, release_year, language_id, rental_duration, rental_rate, replacement_cost) " +
                     "VALUES (?, ?, ?, 1, 3, 4.99, 19.99) RETURNING film_id";
        
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, title);
            stmt.setString(2, description);
            stmt.setInt(3, releaseYear);
            
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt(1);
                AuditLogger.log("INSERT", "Filme criado: " + title + " (ID: " + id + ")");
                return id;
            }
        } catch (Exception e) {
            System.err.println("Erro ao inserir: " + e.getMessage());
        }
        return -1;
    }

    // 2. Buscar Filme por ID
    public void getFilmById(int filmId) {
        String sql = "SELECT film_id, title, description, release_year FROM film WHERE film_id = ?";
        
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, filmId);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                System.out.println("Filme Encontrado: " + rs.getString("title") + 
                                   " (" + rs.getInt("release_year") + ")");
            } else {
                System.out.println("Filme não encontrado para o ID: " + filmId);
            }
        } catch (Exception e) {
            System.err.println("Erro ao buscar: " + e.getMessage());
        }
    }

    // 3. Listar Atores de um Filme
    public void listActorsByFilmId(int filmId) {
        String sql = "SELECT a.first_name, a.last_name " +
                     "FROM actor a " +
                     "JOIN film_actor fa ON a.actor_id = fa.actor_id " +
                     "WHERE fa.film_id = ?";
                     
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, filmId);
            ResultSet rs = stmt.executeQuery();
            
            System.out.println("Elenco:");
            boolean encontrou = false;
            while (rs.next()) {
                System.out.println("- " + rs.getString("first_name") + " " + rs.getString("last_name"));
                encontrou = true;
            }
            
            if (!encontrou) System.out.println("(Nenhum ator vinculado ou filme inexistente)");
            
        } catch (Exception e) {
            System.err.println("Erro ao listar atores: " + e.getMessage());
        }
    }

    // 4. Excluir Ator por ID
    public void deleteActor(int actorId) {
        String sql = "DELETE FROM actor WHERE actor_id = ?";
        
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, actorId);
            int rowsAffected = stmt.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Ator removido com sucesso.");
                AuditLogger.log("DELETE", "Ator removido ID: " + actorId);
            } else {
                System.out.println("Nenhum ator encontrado com ID: " + actorId);
            }
            
        } catch (SQLException e) {
            if (e.getSQLState().equals("23503")) {
                System.err.println("ERRO: Não é possível excluir o ator pois ele está vinculado a filmes.");
                AuditLogger.log("ERROR", "Tentativa de exclusão falhou (FK) para Ator ID: " + actorId);
            } else {
                System.err.println("Erro SQL: " + e.getMessage());
            }
        } catch (Exception e) {
            System.err.println("Erro genérico: " + e.getMessage());
        }
    }
}
