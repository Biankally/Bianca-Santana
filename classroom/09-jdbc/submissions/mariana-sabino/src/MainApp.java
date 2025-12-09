import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        FilmDAO filmDAO = new FilmDAO();
        ActorDAO actorDAO = new ActorDAO();

        int newFilmId = filmDAO.insertFilm(
            "Novo Filme",
            "Descrição teste",
            2025,
            1
        );
        System.out.println("Filme inserido com ID: " + newFilmId);

        FilmDAO.FilmRecord film = filmDAO.getFilmById(newFilmId);
        if (film != null) {
            System.out.println("Encontrado: " + film);
        } else {
            System.out.println("Filme não encontrado (ID " + newFilmId + ")");
        }

        boolean updated = filmDAO.updateFilmTitle(newFilmId, "Título Atualizado");
        System.out.println("Título atualizado? " + updated);

        List<FilmDAO.FilmRecord> allFilms = filmDAO.listAllFilms();
        System.out.println("Lista de filmes:");
        for (FilmDAO.FilmRecord fr : allFilms) {
            System.out.println(fr);
        }

        actorDAO.listActorsByFilmId(newFilmId);

        boolean deleted = filmDAO.deleteFilm(newFilmId);
        System.out.println("Filme excluído? " + deleted);

    }
}
