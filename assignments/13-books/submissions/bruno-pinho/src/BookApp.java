/**
 * Classe principal para instanciar e exibir informações de diferentes tipos de livros.
 */
public class BookApp {

    public static void main(String[] args) {
        // 1. Instancia um objeto da classe base Book
        Book genericBook = new Book("O Guia do Mochileiro das Galáxias", 1979, "Douglas Adams");

        // 2. Instancia um objeto da subclasse PrintBook
        PrintBook printedBook = new PrintBook("Duna", 1965, "Frank Herbert", "Editora Aleph", "978-8576572719");

        // 3. Instancia um objeto da subclasse AudioBook
        AudioBook audioBook = new AudioBook("O Senhor dos Anéis", 1954, "J.R.R. Tolkien", 550.5, 1200, "Mauro Ramos");

        // Imprime as informações de cada livro.
        // O método println chama automaticamente o método toString() de cada objeto.
        System.out.println("--- Livro Genérico ---");
        System.out.println(genericBook);

        System.out.println("\n--- Livro Impresso ---");
        System.out.println(printedBook);

        System.out.println("\n--- Audiolivro ---");
        System.out.println(audioBook);
    }
}