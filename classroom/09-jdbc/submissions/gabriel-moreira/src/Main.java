public class Main {

    public static void main(String[] args) {

        LoggerService.log("Iniciando aplicação...");

        FilmDAO dao = new FilmDAO();
        dao.listarFilmes();

        LoggerService.log("Finalizado.");
    }
}
