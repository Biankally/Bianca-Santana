import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op;

        do {
            System.out.println("\n=== DVD Rental - JDBC ===");
            System.out.println("1 - Inserir novo filme");
            System.out.println("2 - Buscar filme por ID");
            System.out.println("3 - Atualizar filme");
            System.out.println("4 - Deletar filme");
            System.out.println("5 - Listar atores de um filme");
            System.out.println("6 - Excluir ator por ID");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            while (!sc.hasNextInt()) {
                sc.nextLine();
                System.out.print("Opção inválida, tente de novo: ");
            }
            op = sc.nextInt();
            sc.nextLine(); // quebra de linha

            try {
                switch (op) {
                    case 1 -> inserirFilme(sc);
                    case 2 -> buscarFilme(sc);
                    case 3 -> atualizarFilme(sc);
                    case 4 -> deletarFilme(sc);
                    case 5 -> listarAtores(sc);
                    case 6 -> excluirAtor(sc);
                    case 0 -> System.out.println("Saindo...");
                    default -> System.out.println("Opção inválida.");
                }
            } catch (SQLException e) {
                System.err.println("Erro de banco: " + e.getMessage());
            }

        } while (op != 0);

        sc.close();
    }

    // ---------- FILM ----------

    private static void inserirFilme(Scanner sc) throws SQLException {
        System.out.print("Título: ");
        String title = sc.nextLine();
        System.out.print("Descrição: ");
        String desc = sc.nextLine();
        System.out.print("Ano (enter para nulo): ");
        String anoStr = sc.nextLine();
        Integer ano = anoStr.isBlank() ? null : Integer.parseInt(anoStr);

        String sql = """
            INSERT INTO film
            (title, description, release_year,
             language_id, rental_duration, rental_rate, replacement_cost)
            VALUES (?, ?, ?, 1, 3, 4.99, 19.99)
            RETURNING film_id
            """;

        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, title);
            ps.setString(2, desc);
            if (ano != null) {
                ps.setInt(3, ano);
            } else {
                ps.setNull(3, Types.INTEGER);
            }

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("film_id");
                    System.out.println("Filme inserido com ID: " + id);
                    Audit.log("INSERT film id=" + id + " title='" + title + "'");
                }
            }
        }
    }

    private static void buscarFilme(Scanner sc) throws SQLException {
        System.out.print("ID do filme: ");
        int id = sc.nextInt();
        sc.nextLine();

        Film f = buscarFilmePorId(id);
        if (f == null) {
            System.out.println("Filme não encontrado.");
        } else {
            System.out.println("Filme: " + f);
        }
    }

    private static Film buscarFilmePorId(int id) throws SQLException {
        String sql = """
            SELECT film_id, title, description, release_year
            FROM film WHERE film_id = ?
            """;

        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Film(
                            rs.getInt("film_id"),
                            rs.getString("title"),
                            rs.getString("description"),
                            (Integer) rs.getObject("release_year")
                    );
                }
            }
        }
        return null;
    }

    private static void atualizarFilme(Scanner sc) throws SQLException {
        System.out.print("ID do filme: ");
        int id = sc.nextInt();
        sc.nextLine();

        Film f = buscarFilmePorId(id);
        if (f == null) {
            System.out.println("Filme não encontrado.");
            return;
        }

        System.out.println("Atual atual: " + f);

        System.out.print("Novo título (enter p/ manter): ");
        String novoTitulo = sc.nextLine();
        if (!novoTitulo.isBlank()) f.setTitle(novoTitulo);

        System.out.print("Nova descrição (enter p/ manter): ");
        String novaDesc = sc.nextLine();
        if (!novaDesc.isBlank()) f.setDescription(novaDesc);

        System.out.print("Novo ano (enter p/ manter): ");
        String anoStr = sc.nextLine();
        if (!anoStr.isBlank()) f.setReleaseYear(Integer.parseInt(anoStr));

        String sql = """
            UPDATE film
            SET title = ?, description = ?, release_year = ?
            WHERE film_id = ?
            """;

        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, f.getTitle());
            ps.setString(2, f.getDescription());
            if (f.getReleaseYear() != null) {
                ps.setInt(3, f.getReleaseYear());
            } else {
                ps.setNull(3, Types.INTEGER);
            }
            ps.setInt(4, f.getId());

            int linhas = ps.executeUpdate();
            if (linhas > 0) {
                System.out.println("Filme atualizado.");
                Audit.log("UPDATE film id=" + f.getId());
            } else {
                System.out.println("Nada atualizado.");
            }
        }
    }

    private static void deletarFilme(Scanner sc) throws SQLException {
        System.out.print("ID do filme a deletar: ");
        int id = sc.nextInt();
        sc.nextLine();

        String sql = "DELETE FROM film WHERE film_id = ?";

        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            int linhas = ps.executeUpdate();
            if (linhas > 0) {
                System.out.println("Filme deletado.");
                Audit.log("DELETE film id=" + id);
            } else {
                System.out.println("Nenhum filme deletado.");
            }
        }
    }

    // ---------- ACTOR / FILM ACTOR ----------

    private static void listarAtores(Scanner sc) throws SQLException {
        System.out.print("ID do filme: ");
        int filmId = sc.nextInt();
        sc.nextLine();

        String sql = """
            SELECT a.actor_id, a.first_name, a.last_name
            FROM actor a
            JOIN film_actor fa ON a.actor_id = fa.actor_id
            WHERE fa.film_id = ?
            ORDER BY a.last_name, a.first_name
            """;

        List<String> atores = new ArrayList<>();

        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, filmId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("actor_id");
                    String nome = rs.getString("first_name") + " " + rs.getString("last_name");
                    atores.add(id + " - " + nome);
                }
            }
        }

        if (atores.isEmpty()) {
            System.out.println("Nenhum ator encontrado para esse filme.");
        } else {
            System.out.println("Atores do filme " + filmId + ":");
            for (String s : atores) {
                System.out.println("  " + s);
            }
        }
    }

    private static void excluirAtor(Scanner sc) throws SQLException {
        System.out.print("ID do ator a excluir: ");
        int actorId = sc.nextInt();
        sc.nextLine();

        String sql = "DELETE FROM actor WHERE actor_id = ?";

        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, actorId);
            int linhas = ps.executeUpdate();
            if (linhas > 0) {
                System.out.println("Ator excluído.");
                Audit.log("DELETE actor id=" + actorId);
            } else {
                System.out.println("Nenhum ator excluído (ID inexistente ou violação de FK).");
            }
        }
    }
}
