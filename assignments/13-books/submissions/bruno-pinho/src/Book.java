/**
 * A classe base Book representa um livro genérico com título, autor e ano.
 */
public class Book {
    // Atributos protegidos para serem acessíveis pelas subclasses
    protected String title;
    protected int year;
    protected String author;

    /**
     * Construtor para inicializar um objeto Book.
     *
     * @param title  O título do livro.
     * @param year   O ano de publicação.
     * @param author O autor do livro.
     */
    public Book(String title, int year, String author) {
        this.title = title;
        this.year = year;
        this.author = author;
    }

    /**
     * Sobrescreve o método toString() para fornecer uma representação textual
     * das informações básicas do livro.
     *
     * @return Uma String formatada com os detalhes do livro.
     */
    @Override
    public String toString() {
        return String.format("Título: %s, Autor: %s, Ano: %d", title, author, year);
    }
}