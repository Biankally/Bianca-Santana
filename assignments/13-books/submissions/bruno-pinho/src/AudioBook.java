/**
 * A classe AudioBook herda de Book e representa um audiolivro,
 * adicionando informações sobre tamanho, duração e narrador.
 */
public class AudioBook extends Book {
    private double fileSizeInMB;
    private int playLengthInMinutes;
    private String narrator;

    /**
     * Construtor para inicializar um objeto AudioBook.
     *
     * @param title               O título do livro.
     * @param year                O ano de publicação.
     * @param author              O autor do livro.
     * @param fileSizeInMB        O tamanho do arquivo em MB.
     * @param playLengthInMinutes A duração do áudio em minutos.
     * @param narrator            O nome do narrador.
     */
    public AudioBook(String title, int year, String author, double fileSizeInMB, int playLengthInMinutes, String narrator) {
        // Chama o construtor da superclasse (Book)
        super(title, year, author);
        this.fileSizeInMB = fileSizeInMB;
        this.playLengthInMinutes = playLengthInMinutes;
        this.narrator = narrator;
    }

    /**
     * Sobrescreve o método toString() para incluir os detalhes do audiolivro.
     * Reutiliza o método toString() da superclasse.
     *
     * @return Uma String formatada com todos os detalhes do audiolivro.
     */
    @Override
    public String toString() {
        return super.toString() + String.format(", Tamanho: %.1f MB, Duração: %d min, Narrador: %s",
                                                fileSizeInMB, playLengthInMinutes, narrator);
    }
}