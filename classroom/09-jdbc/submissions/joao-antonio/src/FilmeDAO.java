import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmeDAO {

    private static final String INSERIR = 
        "INSERT INTO film (title, description, release_year, language_id, rental_duration, rental_rate, replacement_cost) " +
        "VALUES (?, ?, ?, 1, 3, 4.99, 20.99)";
    private static final String BUSCAR_POR_ID = 
        "SELECT film_id, title, description, release_year FROM film WHERE film_id = ?";
    private static final String BUSCAR_ATORES =
        "SELECT a.actor_id, a.first_name, a.last_name FROM actor a JOIN film_actor fa ON a.actor_id = fa.actor_id WHERE fa.film_id = ?";
    private static final String ATUALIZAR = 
        "UPDATE film SET title = ?, description = ?, release_year = ? WHERE film_id = ?";
    private static final String DELETAR = 
        "DELETE FROM film WHERE film_id = ?";


    public Film inserir(Film filme) throws SQLException {
        try (Connection conn = GerenciadorDeConexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERIR, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, filme.getTitulo());
            stmt.setString(2, filme.getDescricao());
            stmt.setInt(3, filme.getAnoLancamento());

            if (stmt.executeUpdate() > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        filme.setId(rs.getInt(1));
                        GerenciadorDeLog.registrar("INSERCAO", "Filme '" + filme.getTitulo() + "' inserido com ID: " + filme.getId());
                        return filme;
                    }
                }
            }
            throw new SQLException("Falha ao inserir filme.");
        }
    }

    public Film buscarPorId(int id) throws SQLException {
        try (Connection conn = GerenciadorDeConexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(BUSCAR_POR_ID)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Film(rs.getInt("film_id"), rs.getString("title"), rs.getString("description"), rs.getInt("release_year"));
                }
            }
        }
        return null;
    }

    public List<Ator> listarAtoresPorFilme(int idFilme) throws SQLException {
        List<Ator> atores = new ArrayList<>();
        try (Connection conn = GerenciadorDeConexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(BUSCAR_ATORES)) {
            stmt.setInt(1, idFilme);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    atores.add(new Ator(rs.getInt("actor_id"), rs.getString("first_name"), rs.getString("last_name")));
                }
            }
        }
        return atores;
    }

    public boolean atualizar(Film filme) throws SQLException {
        try (Connection conn = GerenciadorDeConexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(ATUALIZAR)) {

            stmt.setString(1, filme.getTitulo());
            stmt.setString(2, filme.getDescricao());
            stmt.setInt(3, filme.getAnoLancamento());
            stmt.setInt(4, filme.getId());

            if (stmt.executeUpdate() > 0) {
                GerenciadorDeLog.registrar("ATUALIZACAO", "Filme '" + filme.getTitulo() + "' (ID: " + filme.getId() + ") atualizado.");
                return true;
            }
            return false;
        }
    }

    public boolean deletar(int idFilme) throws SQLException {
        try (Connection conn = GerenciadorDeConexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(DELETAR)) {

            stmt.setInt(1, idFilme);

            if (stmt.executeUpdate() > 0) {
                GerenciadorDeLog.registrar("REMOCAO", "Filme com ID: " + idFilme + " removido.");
                return true;
            }
            return false;
        }
    }
}