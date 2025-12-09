package main;

import model.Film;
import service.DvdRentalService;
import util.FilmFileReader;
import java.sql.SQLException;
import java.util.List;

public class Main {
    
    private static final String FILM_FILE_PATH = "./data/new_films.txt";

    public static void main(String[] args) {
        
        System.out.println("🎬 IDPFlix - Iniciando operações de banco de dados...");
        
        List<Film> filmsToImport = FilmFileReader.readFilmsFromFile(FILM_FILE_PATH);

        if (filmsToImport.isEmpty()) {
            System.err.println("⚠️ Nenhuma lista de filmes para importar. Verifique o arquivo.");
            return;
        }

        DvdRentalService service = new DvdRentalService();
        
        try {
            service.importFilms(filmsToImport);
            service.updateRentalRates();
            service.listFilmsWithDuration99();
            
            System.out.println("\n✅ Programa concluído com sucesso.");
            
        } catch (SQLException e) {
            System.err.println("\n ERRO FATAL de Banco de Dados. Verifique a conexão e as credenciais.");
            System.err.println("Detalhe do Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }
}