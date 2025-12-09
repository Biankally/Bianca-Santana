/**
 * A classe PrintBook herda de Book e representa um livro impresso,
 * adicionando informações sobre a editora e o ISBN.
 */
public class PrintBook extends Book {
    private String publisher;
    private String isbn;

    /**
     * Construtor para inicializar um objeto PrintBook.
     *
     * @param title     O título do livro.
     * @param year      O ano de publicação.
     * @param author    O autor do livro.
     * @param publisher A editora do livro.
     * @param isbn      O código ISBN do livro.
     */
    public PrintBook(String title, int year, String author, String publisher, String isbn) {
        // Chama o construtor da superclasse (Book) para inicializar os atributos herdados
        super(title, year, author);
        this.publisher = publisher;
        this.isbn = isbn;
    }

    /**
     * Sobrescreve o método toString() para incluir os detalhes do livro impresso.
     * Reutiliza o método toString() da superclasse.
     *
     * @return Uma String formatada com todos os detalhes do livro impresso.
     */
    @Override
    public String toString() {
        // super.toString() chama o método da classe Book
        return super.toString() + String.format(", Editora: %s, ISBN: %s", publisher, isbn);
    }
}