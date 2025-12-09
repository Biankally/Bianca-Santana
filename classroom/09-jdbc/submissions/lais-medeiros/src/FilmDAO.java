import java.sql.*;

public class FilmDAO {

    public void inserirFilme(String titulo, String descricao) {
        String sql = "INSERT INTO film (title, description, language_id) VALUES (?, ?, 1)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, titulo);
            ps.setString(2, descricao);
            ps.executeUpdate();

            AuditLogger.log("Filme inserido: " + titulo);

        } catch (Exception e) {
            System.out.println("Erro ao inserir filme: " + e.getMessage());
        }
    }

    public void buscarFilmePorId(int id) {
        String sql = "SELECT film_id, title, description FROM film WHERE film_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("ID: " + rs.getInt("film_id"));
                System.out.println("Título: " + rs.getString("title"));
                System.out.println("Descrição: " + rs.getString("description"));
            } else {
                System.out.println("Filme não encontrado.");
            }

        } catch (Exception e) {
            System.out.println("Erro na busca: " + e.getMessage());
        }
    }

    public void listarAtoresPorFilme(int filmId) {
        String sql = """
            SELECT a.actor_id, a.first_name, a.last_name
            FROM actor a
            JOIN film_actor fa ON a.actor_id = fa.actor_id
            WHERE fa.film_id = ?
        """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, filmId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                    rs.getInt("actor_id") + " - " +
                    rs.getString("first_name") + " " +
                    rs.getString("last_name")
                );
            }

        } catch (Exception e) {
            System.out.println("Erro ao listar atores: " + e.getMessage());
        }
    }

    public void atualizarFilme(int id, String novoTitulo) {
        String sql = "UPDATE film SET title = ? WHERE film_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, novoTitulo);
            ps.setInt(2, id);
            ps.executeUpdate();

            AuditLogger.log("Filme atualizado ID: " + id);

        } catch (Exception e) {
            System.out.println("Erro ao atualizar filme: " + e.getMessage());
        }
    }

    public void excluirFilme(int id) {
        String sql = "DELETE FROM film WHERE film_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

            AuditLogger.log("Filme excluído ID: " + id);

        } catch (Exception e) {
            System.out.println("Erro ao excluir filme: " + e.getMessage());
        }
    }

    public void excluirAtor(int id) {
        String sql = "DELETE FROM actor WHERE actor_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

            AuditLogger.log("Ator excluído ID: " + id);

        } catch (Exception e) {
            System.out.println("Erro ao excluir ator: " + e.getMessage());
        }
    }
}
