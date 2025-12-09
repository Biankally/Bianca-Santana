import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class IdpFlixApp {

    public static void main(String[] args) {
        System.out.println("=== INICIANDO SISTEMA IDPFLIX ===");

        System.out.println("Passo 1: Lendo arquivo 'new_films.txt'...");
        FilmReader leitor = new FilmReader();
        List<Film> filmes = leitor.readFilms("new_films.txt");
        System.out.println("-> " + filmes.size() + " filmes encontrados no arquivo.");

        Properties props = new Properties();
        try {
            props.load(new FileInputStream("db.properties"));
        } catch (IOException e) {
            System.err.println("Erro crítico: Arquivo db.properties não encontrado!");
            return;
        }

        String url = props.getProperty("url");
        String usuario = props.getProperty("user");
        String senha = props.getProperty("password");

        System.out.println("Passo 2: Conectando ao Banco de Dados...");
        
        try (Connection conexao = DriverManager.getConnection(url, usuario, senha)) {
            System.out.println("-> Conexão estabelecida com sucesso!");

            System.out.println("Passo 3: Inserindo filmes no banco...");
            String sqlInserir = "INSERT INTO film (title, language_id, rental_duration, rental_rate, replacement_cost) VALUES (?, ?, ?, ?, ?)";
            
            try (PreparedStatement stmt = conexao.prepareStatement(sqlInserir)) {
                int contador = 0;
                for (Film f : filmes) {
                    stmt.setString(1, f.getTitle());
                    stmt.setInt(2, f.getLanguageId());
                    stmt.setInt(3, f.getRentalDuration());
                    stmt.setDouble(4, f.getRentalRate());
                    stmt.setDouble(5, f.getReplacementCost());
                    stmt.executeUpdate();
                    contador++;
                }
                System.out.println("-> Sucesso! " + contador + " novos filmes cadastrados.");
            }

            System.out.println("Passo 4: Aplicando aumento de 10% nos preços...");
            String sqlAtualizar = "UPDATE film SET rental_rate = rental_rate * 1.1";
            try (PreparedStatement stmt = conexao.prepareStatement(sqlAtualizar)) {
                int atualizados = stmt.executeUpdate();
                System.out.println("-> Atualização concluída. Preços reajustados em " + atualizados + " filmes.");
            }

            System.out.println("\n=== RELATÓRIO: Filmes com Duração de 99 dias ===");
            String sqlSelecionar = "SELECT title, rental_rate FROM film WHERE rental_duration = ?";
            
            try (PreparedStatement stmt = conexao.prepareStatement(sqlSelecionar)) {
                stmt.setInt(1, 99);
                
                try (ResultSet rs = stmt.executeQuery()) {
                    boolean encontrouAlgum = false;
                    while (rs.next()) {
                        System.out.printf("Filme: %-30s | Preço: %.2f%n", 
                            rs.getString("title"), 
                            rs.getDouble("rental_rate"));
                        encontrouAlgum = true;
                    }
                    
                    if (!encontrouAlgum) {
                        System.out.println("-> Nenhum filme encontrado com duração exata de 99 dias.");
                    }
                }
            }
            System.out.println("\n=== FIM DO PROGRAMA ===");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
