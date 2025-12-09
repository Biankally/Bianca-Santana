import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class AplicativoIDPFlix {
    public static void main(String[] args) {
        String caminhoArquivo = "data/new_films.txt";
        List<Filme> filmes = FilmeLeitor.carregarFilmes(caminhoArquivo);

        try (Connection conexao = DriverManager.getConnection(
                "jdbc:postgresql://aws-0-us-west-2.pooler.supabase.com:5432/postgres?sslmode=require",
                "postgres.hfhkzbwherlecnycdagi",
                "[SUA-SENHA-AQUI]")) {

            inserirFilmes(conexao, filmes);
            atualizarTaxas(conexao);
            listarPorDuracao(conexao);
            listarPorTaxa(conexao);

        } catch (Exception e) {
            System.err.println("Erro na conexão: " + e.getMessage());
        }
    }

    private static void inserirFilmes(Connection conn, List<Filme> filmes) throws Exception {
        String sql = "INSERT INTO film (title, language_id, rental_duration, rental_rate, replacement_cost) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            for (Filme f : filmes) {
                ps.setString(1, f.getTitulo());
                ps.setInt(2, f.getIdiomaId());
                ps.setInt(3, f.getDuracaoLocacao());
                ps.setDouble(4, f.getTaxaLocacao());
                ps.setDouble(5, f.getCustoReposicao());
                ps.executeUpdate();
            }
            System.out.println("Filmes inseridos.");
        }
    }

    private static void atualizarTaxas(Connection conn) throws Exception {
        String sql = "UPDATE film SET rental_rate = rental_rate * 1.1";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            int atualizados = ps.executeUpdate();
            System.out.println("Taxas atualizadas em " + atualizados + " filmes.");
        }
    }

    private static void listarPorDuracao(Connection conn) throws Exception {
        String sql = "SELECT title, rental_rate FROM film WHERE rental_duration = 99";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            System.out.println("\nFilmes com duração 99:");
            while (rs.next()) {
                System.out.printf("%s: %.2f%n", rs.getString("title"), rs.getDouble("rental_rate"));
            }
        }
    }

    private static void listarPorTaxa(Connection conn) throws Exception {
        String sql = "SELECT title, rental_rate FROM film WHERE rental_rate = 99";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            System.out.println("\nFilmes com taxa 99:");
            while (rs.next()) {
                System.out.printf("%s: %.2f%n", rs.getString("title"), rs.getDouble("rental_rate"));
            }
        }
    }
}
