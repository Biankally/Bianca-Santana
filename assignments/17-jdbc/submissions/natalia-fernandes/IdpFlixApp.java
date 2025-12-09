import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class IdpFlixApp {

    public static void main(String[] args) {

        // caminho do arquivo de filmes (ajusta se no seu repo estiver diferente)
        String filePath = "data/new_films.txt";

        // lê os filmes do arquivo
        FilmFileReader reader = new FilmFileReader();
        List<Film> films = reader.readFilmsFromFile(filePath);

        if (films.isEmpty()) {
            System.out.println("Nenhum filme carregado do arquivo. Verifique o arquivo new_films.txt.");
            return;
        }

        // configurações do banco (ajusta usuário e senha para o seu PostgreSQL)
        String url = "jdbc:postgresql://localhost:5432/dvd_rental";
        String user = "postgres";      // coloca o seu usuário
        String password = "postgres";  // coloca a sua senha

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            conn.setAutoCommit(false); // tudo numa transação

            inserirFilmes(conn, films);
            atualizarRentalRate(conn);
            listarFilmesComRentalDuration99(conn);

            conn.commit();

        } catch (SQLException e) {
            System.err.println("Erro ao acessar o banco de dados: " + e.getMessage());
        }
    }

    private static void inserirFilmes(Connection conn, List<Film> films) throws SQLException {
        String sqlInsert = "INSERT INTO film " +
                "(title, language_id, rental_duration, rental_rate, replacement_cost) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sqlInsert)) {
            for (Film film : films) {
                ps.setString(1, film.getTitle());
                ps.setInt(2, film.getLanguageId());
                ps.setInt(3, film.getRentalDuration());
                ps.setDouble(4, film.getRentalRate());
                ps.setDouble(5, film.getReplacementCost());
                ps.addBatch();
            }

            ps.executeBatch();
            System.out.println("Filmes importados com sucesso.");
        }
    }

    private static void atualizarRentalRate(Connection conn) throws SQLException {
        String sqlUpdate = "UPDATE film SET rental_rate = rental_rate * 1.1";

        try (PreparedStatement ps = conn.prepareStatement(sqlUpdate)) {
            int rows = ps.executeUpdate();
            System.out.println("Valor de locação atualizado em 10% para " + rows + " filme(s).");
        }
    }

    private static void listarFilmesComRentalDuration99(Connection conn) throws SQLException {
        // se na sua tabela a coluna for rent_duration, troque aqui
        String sqlSelect = "SELECT title, rental_rate FROM film WHERE rental_duration = 99";

        try (PreparedStatement ps = conn.prepareStatement(sqlSelect);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("Filmes com rental_duration = 99:");
            while (rs.next()) {
                String title = rs.getString("title");
                double rentalRate = rs.getDouble("rental_rate");
                System.out.println(title + " - " + rentalRate);
            }
        }
    }
}
