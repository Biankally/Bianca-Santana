package br.com.idpflix;

import br.com.idpflix.dao.FilmDAO;
import br.com.idpflix.model.Film;
import br.com.idpflix.util.FilmFileReader;

import java.sql.SQLException;
import java.util.List;

public class Main {

    private static final String FILMS_FILE_PATH = "new_films.txt";

    public static void main(String[] args) {
        FilmDAO filmDAO = new FilmDAO();

        try {
            // 1. Importar nova lista de filmes
            List<Film> newFilms = FilmFileReader.readFilmsFromFile(FILMS_FILE_PATH);
            if (!newFilms.isEmpty()) {
                filmDAO.insertFilms(newFilms);
                System.out.println("Importação de " + newFilms.size() + " filmes concluída.");
            } else {
                System.out.println("Nenhum filme para importar.");
            }

            // 2. Atualizar em 10% o valor de locação
            int updatedCount = filmDAO.updateRentalRate();
            System.out.println("Atualização de valor de locação concluída. Filmes afetados: " + updatedCount);

            // 3. Listar filmes com duração de locação igual a 99
            filmDAO.listFilmsByRentalDuration(99);

        } catch (SQLException e) {
            System.err.println("Erro de SQL: " + e.getMessage());
            e.printStackTrace();
        } catch (RuntimeException e) {
            System.err.println("Erro de Configuração: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
