package main;

import service.DvdRentalService; 

public class Main {
    public static void main(String[] args) {
        System.out.println(" Filmes ");
        DvdRentalService.inserirFilme("Filme com banco de dados dvd rental");
        System.out.println("---");
        DvdRentalService.buscarFilme(1);
        System.out.println("---");
        DvdRentalService.listarAtoresDoFilme(1);
        System.out.println("---");
        DvdRentalService.excluirAtor(1); 
        DvdRentalService.excluirAtor(999);
        System.out.println(" Fim dos dados ");
    }
}