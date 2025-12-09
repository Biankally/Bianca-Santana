import java.util.List;

public class Main {
    public static void main(String[] args) {
        DvdDAO dao = new DvdDAO();

        // 1. Inserir
        System.out.println("_____INSERINDO FILME_____");
        Film newFilm = new Film("O Codigo Da Vinci 2", "Suspense em Java", 1);
        newFilm = dao.insertFilm(newFilm);
        System.out.println("Inserido: " + newFilm);

        // 2. Buscar
        System.out.println("\n_____BUSCANDO FILME POR ID_____");
        if (newFilm != null) {
            Film found = dao.findFilmById(newFilm.getFilmId());
            System.out.println("Encontrado: " + found);
        }

        // 3. Listar Atores 
        System.out.println("\n_____ATORES DO FILME ID 1_____");
        List<Actor> actors = dao.getActorsByFilm(1);
        actors.forEach(System.out::println);

        // 4. Excluir Ator
        System.out.println("\n_____EXCLUINDO ATOR_____");
        dao.deleteActor(9999); 
    }
}