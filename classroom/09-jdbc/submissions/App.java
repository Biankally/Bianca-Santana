import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.APPEND;

public class App {

    // Caminhos simples (ajuste se quiser)
    private static final Path PROPS = Paths.get("db.properties");
    private static final Path AUDIT = Paths.get("audit.log");

    public static void main(String[] args) {
        try (Connection con = openConnection(PROPS);
             Scanner sc = new Scanner(System.in)) {

            System.out.println("=== DVD Rental CRUD (JDBC puro) ===");
            System.out.println("1) Inserir filme");
            System.out.println("2) Buscar filme por ID");
            System.out.println("3) Atualizar título de filme");
            System.out.println("4) Listar atores de um filme (por film_id)");
            System.out.println("5) Excluir ator por ID");
            System.out.println("0) Sair");

            System.out.print("> ");
            while (sc.hasNextLine()) {
                String op = sc.nextLine().trim();
                try {
                    switch (op) {
                        case "1" -> { // INSERT
                            System.out.print("Título: ");
                            String title = sc.nextLine();
                            System.out.print("Descrição: ");
                            String desc = sc.nextLine();
                            System.out.print("Ano (vazio = null): ");
                            String y = sc.nextLine().trim();
                            Integer year = y.isEmpty() ? null : Integer.parseInt(y);

                            int id = insertFilm(con, title, desc, year);
                            log("INSERT", "film_id=" + id + " title='" + title + "'");
                            System.out.println("Inserido film_id=" + id);
                        }

                        case "2" -> { // SELECT by id
                            System.out.print("film_id: ");
                            int id = Integer.parseInt(sc.nextLine());
                            selectFilm(con, id);
                        }

                        case "3" -> { // UPDATE title
                            System.out.print("film_id: ");
                            int id = Integer.parseInt(sc.nextLine());
                            System.out.print("Novo título: ");
                            String newTitle = sc.nextLine();
                            int rows = updateTitle(con, id, newTitle);
                            if (rows > 0) log("UPDATE", "film_id=" + id + " title='" + newTitle + "'");
                            System.out.println("Atualizados: " + rows);
                        }

                        case "4" -> { // list actors for film
                            System.out.print("film_id: ");
                            int filmId = Integer.parseInt(sc.nextLine());
                            listActors(con, filmId);
                        }

                        case "5" -> { // DELETE actor (com transação)
                            System.out.print("actor_id: ");
                            int actorId = Integer.parseInt(sc.nextLine());
                            int rows = deleteActor(con, actorId);
                            if (rows > 0) log("DELETE", "actor_id=" + actorId);
                            System.out.println("Excluídos: " + rows);
                        }

                        case "0" -> {
                            System.out.println("Saindo.");
                            return;
                        }

                        default -> System.out.println("Opção inválida.");
                    }
                } catch (Exception e) {
                    System.out.println("Erro: " + e.getMessage());
                }
                System.out.print("> ");
            }
        } catch (Exception e) {
            System.out.println("Falha: " + e.getMessage());
        }
    }

    // ---- JDBC/Arquivo (simples) ----

    private static Connection openConnection(Path propsPath) throws IOException, SQLException {
        Properties p = new Properties();
        try (Reader r = Files.newBufferedReader(propsPath, StandardCharsets.UTF_8)) {
            p.load(r);
        }
        String url = p.getProperty("url");
        String user = p.getProperty("user");
        String pass = p.getProperty("password");
        return DriverManager.getConnection(url, user, pass);
    }

    private static void log(String action, String detail) {
        try {
            String line = java.time.LocalDateTime.now() + " | " + action + " | " + detail + System.lineSeparator();
            Files.writeString(AUDIT, line, StandardCharsets.UTF_8, CREATE, APPEND);
        } catch (IOException e) {
            System.err.println("Falha ao escrever audit.log: " + e.getMessage());
        }
    }

    // ---- Operações mínimas ----

    private static int insertFilm(Connection con, String title, String desc, Integer year) throws SQLException {
        String sql = """
            INSERT INTO film (title, description, release_year, language_id, rental_duration, rental_rate, length, replacement_cost, rating)
            VALUES (?, ?, ?, 1, 3, 4.99, 90, 19.99, 'G')
            RETURNING film_id
            """;
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, title);
            ps.setString(2, desc);
            if (year == null) ps.setNull(3, Types.SMALLINT);
            else ps.setInt(3, year);
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                return rs.getInt(1);
            }
        }
    }

    private static void selectFilm(Connection con, int id) throws SQLException {
        String sql = "SELECT film_id, title, description, release_year FROM film WHERE film_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) {
                    System.out.println("Não encontrado.");
                    return;
                }
                Integer filmId = rs.getInt("film_id");
                String title = rs.getString("title");
                String desc = rs.getString("description");
                int y = rs.getInt("release_year");
                String year = rs.wasNull() ? "null" : String.valueOf(y);
                System.out.printf("Film{id=%d, title='%s', year=%s}%n", filmId, title, year);
            }
        }
    }

    private static int updateTitle(Connection con, int filmId, String newTitle) throws SQLException {
        String sql = "UPDATE film SET title = ? WHERE film_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, newTitle);
            ps.setInt(2, filmId);
            return ps.executeUpdate();
        }
    }

    private static void listActors(Connection con, int filmId) throws SQLException {
        String sql = """
            SELECT a.actor_id, a.first_name, a.last_name
            FROM film_actor fa
            JOIN actor a ON a.actor_id = fa.actor_id
            WHERE fa.film_id = ?
            ORDER BY a.last_name, a.first_name
            """;
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, filmId);
            try (ResultSet rs = ps.executeQuery()) {
                boolean empty = true;
                while (rs.next()) {
                    empty = false;
                    int id = rs.getInt("actor_id");
                    String fn = rs.getString("first_name");
                    String ln = rs.getString("last_name");
                    System.out.println(id + " - " + fn + " " + ln);
                }
                if (empty) System.out.println("(sem atores)");
            }
        }
    }

    private static int deleteActor(Connection con, int actorId) throws SQLException {
        boolean auto = con.getAutoCommit();
        try {
            con.setAutoCommit(false);
            try (PreparedStatement ps1 = con.prepareStatement("DELETE FROM film_actor WHERE actor_id = ?")) {
                ps1.setInt(1, actorId);
                ps1.executeUpdate();
            }
            int rows;
            try (PreparedStatement ps2 = con.prepareStatement("DELETE FROM actor WHERE actor_id = ?")) {
                ps2.setInt(1, actorId);
                rows = ps2.executeUpdate();
            }
            con.commit();
            return rows;
        } catch (SQLException e) {
            con.rollback();
            throw e;
        } finally {
            con.setAutoCommit(auto);
        }
    }
}
