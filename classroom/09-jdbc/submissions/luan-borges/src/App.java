import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class App {

    private static Connection getConexao() throws SQLException, IOException {
        Properties props = new Properties();
        props.load(new FileInputStream("db.properties"));
        return DriverManager.getConnection(
            props.getProperty("url"),
            props.getProperty("user"),
            props.getProperty("password")
        );
    }

    public static void main(String[] args) {
        try {
            System.out.println("=== INICIANDO OPERAÇÕES CRUD ===");

            Film novoFilme = new Film("Java O Filme", 1, 5, 4.99, 19.99);
            int idFilme = inserirFilme(novoFilme);
            System.out.println("1. Filme inserido com ID: " + idFilme);

            atualizarPrecoFilme(idFilme, 9.99);
            System.out.println("2. Preço do filme atualizado.");

            Film filmeBuscado = buscarFilmePorId(idFilme);
            System.out.println("3. Busca por ID realizada: " + filmeBuscado);

            System.out.println("4. Listando atores do filme ID 1 (Academy Dinosaur):");
            List<Actor> atores = listarAtoresPorFilme(1);
            for (Actor a : atores) {
                System.out.println("   -> " + a);
            }

            int idAtorTemp = inserirAtorTemporario("Teste", "Da Silva");
            excluirAtor(idAtorTemp);
            System.out.println("5. Ator temporário (ID " + idAtorTemp + ") criado e excluído com sucesso.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int inserirFilme(Film filme) throws SQLException, IOException {
        String sql = "INSERT INTO film (title, language_id, rental_duration, rental_rate, replacement_cost) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            stmt.setString(1, filme.getTitulo());
            stmt.setInt(2, filme.getIdIdioma());
            stmt.setInt(3, filme.getDuracaoLocacao());
            stmt.setDouble(4, filme.getTaxaLocacao());
            stmt.setDouble(5, filme.getCustoSubstituicao());
            stmt.executeUpdate();

            Audit.registrarLog("INSERT: Filme '" + filme.getTitulo() + "' adicionado.");

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) return rs.getInt(1);
            }
        }
        return -1;
    }

    public static void atualizarPrecoFilme(int id, double novoPreco) throws SQLException, IOException {
        String sql = "UPDATE film SET rental_rate = ? WHERE film_id = ?";
        try (Connection conn = getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setDouble(1, novoPreco);
            stmt.setInt(2, id);
            stmt.executeUpdate();

            Audit.registrarLog("UPDATE: Preço do filme ID " + id + " alterado para " + novoPreco);
        }
    }

    public static Film buscarFilmePorId(int id) throws SQLException, IOException {
        String sql = "SELECT * FROM film WHERE film_id = ?";
        try (Connection conn = getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Film(
                        rs.getInt("film_id"),
                        rs.getString("title"),
                        rs.getInt("language_id"),
                        rs.getInt("rental_duration"),
                        rs.getDouble("rental_rate"),
                        rs.getDouble("replacement_cost")
                    );
                }
            }
        }
        return null;
    }

    public static List<Actor> listarAtoresPorFilme(int idFilme) throws SQLException, IOException {
        List<Actor> lista = new ArrayList<>();
        String sql = "SELECT a.actor_id, a.first_name, a.last_name FROM actor a " +
                     "JOIN film_actor fa ON a.actor_id = fa.actor_id " +
                     "WHERE fa.film_id = ?";
        
        try (Connection conn = getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, idFilme);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    lista.add(new Actor(
                        rs.getInt("actor_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name")
                    ));
                }
            }
        }
        return lista;
    }

    public static int inserirAtorTemporario(String nome, String sobrenome) throws SQLException, IOException {
        String sql = "INSERT INTO actor (first_name, last_name) VALUES (?, ?)";
        try (Connection conn = getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, nome);
            stmt.setString(2, sobrenome);
            stmt.executeUpdate();
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) return rs.getInt(1);
            }
        }
        return -1;
    }

    public static void excluirAtor(int id) throws SQLException, IOException {
        String sql = "DELETE FROM actor WHERE actor_id = ?";
        try (Connection conn = getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            stmt.executeUpdate();

            Audit.registrarLog("DELETE: Ator ID " + id + " removido.");
        }
    }
}
