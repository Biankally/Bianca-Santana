import java.util.List;
import java.util.Scanner;

public class FilmApp {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FilmDAO filmDAO = new FilmDAO();
        
        while (true) {
            System.out.println("\n=== Sistema de Gerenciamento de Filmes ===");
            System.out.println("1. Inserir novo filme");
            System.out.println("2. Buscar filme por ID");
            System.out.println("3. Listar atores de um filme");
            System.out.println("4. Atualizar filme");
            System.out.println("5. Excluir filme por ID");
            System.out.println("6. Excluir ator por ID");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine();
            
            if (opcao == 0) {
                System.out.println("Saindo...");
                break;
            }
            
            if (opcao == 1) {
                System.out.print("Título: ");
                String title = scanner.nextLine();
                System.out.print("ID do idioma: ");
                int languageId = scanner.nextInt();
                System.out.print("Duração de locação: ");
                int rentalDuration = scanner.nextInt();
                System.out.print("Taxa de locação: ");
                double rentalRate = scanner.nextDouble();
                System.out.print("Custo de substituição: ");
                double replacementCost = scanner.nextDouble();
                
                Film film = new Film(title, languageId, rentalDuration, rentalRate, replacementCost);
                filmDAO.insert(film);
                System.out.println("Filme inserido com sucesso! ID: " + film.getFilmId());
            }
            
            if (opcao == 2) {
                System.out.print("ID do filme: ");
                int filmId = scanner.nextInt();
                Film film = filmDAO.findById(filmId);
                
                if (film != null) {
                    System.out.println("Filme encontrado: " + film);
                } else {
                    System.out.println("Filme não encontrado!");
                }
            }
            
            if (opcao == 3) {
                System.out.print("ID do filme: ");
                int filmId = scanner.nextInt();
                List<String> actors = filmDAO.listActorsByFilmId(filmId);
                
                if (actors.isEmpty()) {
                    System.out.println("Nenhum ator encontrado para este filme!");
                } else {
                    System.out.println("Atores do filme:");
                    for (String actor : actors) {
                        System.out.println("  - " + actor);
                    }
                }
            }
            
            if (opcao == 4) {
                System.out.print("ID do filme: ");
                int filmId = scanner.nextInt();
                Film film = filmDAO.findById(filmId);
                
                if (film == null) {
                    System.out.println("Filme não encontrado!");
                    continue;
                }
                
                System.out.println("Filme atual: " + film);
                System.out.print("Novo título (Enter para manter): ");
                String title = scanner.nextLine();
                if (!title.isEmpty()) {
                    film.setTitle(title);
                }
                System.out.print("Novo ID do idioma (0 para manter): ");
                int languageId = scanner.nextInt();
                if (languageId > 0) {
                    film.setLanguageId(languageId);
                }
                System.out.print("Nova duração de locação (0 para manter): ");
                int rentalDuration = scanner.nextInt();
                if (rentalDuration > 0) {
                    film.setRentalDuration(rentalDuration);
                }
                System.out.print("Nova taxa de locação (0 para manter): ");
                double rentalRate = scanner.nextDouble();
                if (rentalRate > 0) {
                    film.setRentalRate(rentalRate);
                }
                System.out.print("Novo custo de substituição (0 para manter): ");
                double replacementCost = scanner.nextDouble();
                if (replacementCost > 0) {
                    film.setReplacementCost(replacementCost);
                }
                
                filmDAO.update(film);
                System.out.println("Filme atualizado com sucesso!");
            }
            
            if (opcao == 5) {
                System.out.print("ID do filme a excluir: ");
                int filmId = scanner.nextInt();
                filmDAO.delete(filmId);
                System.out.println("Filme excluído com sucesso!");
            }
            
            if (opcao == 6) {
                System.out.print("ID do ator a excluir: ");
                int actorId = scanner.nextInt();
                
                String sql = "DELETE FROM actor WHERE actor_id = ?";
                try (java.sql.Connection conn = ConnectionFactory.getConnection();
                     java.sql.PreparedStatement ps = conn.prepareStatement(sql)) {
                    
                    ps.setInt(1, actorId);
                    int rowsAffected = ps.executeUpdate();
                    
                    if (rowsAffected > 0) {
                        AuditLogger.log("DELETE", "Ator excluído (ID: " + actorId + ")");
                        System.out.println("Ator excluído com sucesso!");
                    } else {
                        System.out.println("Ator não encontrado!");
                    }
                } catch (java.sql.SQLException e) {
                    System.err.println("Erro ao excluir ator: " + e.getMessage());
                }
            }
        }
        
        scanner.close();
    }
}

