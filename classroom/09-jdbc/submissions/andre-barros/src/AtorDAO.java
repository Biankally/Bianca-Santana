import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AtorDAO {

    private static final String DELETAR_FILME_ATOR = 
        "DELETE FROM film_actor WHERE actor_id = ?";
    private static final String DELETAR_ATOR = 
        "DELETE FROM actor WHERE actor_id = ?";

    public void deletarAtor(int idAtor) throws SQLException {
        Connection conn = null;

        try {
            conn = GerenciadorDeConexao.getConnection();
            conn.setAutoCommit(false);

            try (PreparedStatement stmt1 = conn.prepareStatement(DELETAR_FILME_ATOR)) {
                stmt1.setInt(1, idAtor);
                stmt1.executeUpdate();
            }

            try (PreparedStatement stmt2 = conn.prepareStatement(DELETAR_ATOR)) {
                stmt2.setInt(1, idAtor);
                int linhasAfetadas = stmt2.executeUpdate();

                if (linhasAfetadas > 0) {
                    conn.commit();
                    GerenciadorDeLog.registrar("REMOCAO", "Ator com ID: " + idAtor + " e suas referências excluídos.");
                } else {
                    conn.rollback();
                    throw new SQLException("Ator com ID " + idAtor + " não encontrado para exclusão.");
                }
            }

        } catch (SQLException e) {
            if (conn != null) conn.rollback();
            throw e;
        } finally {
            if (conn != null) {
                conn.setAutoCommit(true);
                conn.close();
            }
        }
    }
}