public class Film {
    private int id;
    private String titulo;
    private int idIdioma;
    private int duracaoLocacao;
    private double taxaLocacao;
    private double custoSubstituicao;

    public Film(int id, String titulo, int idIdioma, int duracaoLocacao, double taxaLocacao, double custoSubstituicao) {
        this.id = id;
        this.titulo = titulo;
        this.idIdioma = idIdioma;
        this.duracaoLocacao = duracaoLocacao;
        this.taxaLocacao = taxaLocacao;
        this.custoSubstituicao = custoSubstituicao;
    }

    public Film(String titulo, int idIdioma, int duracaoLocacao, double taxaLocacao, double custoSubstituicao) {
        this.titulo = titulo;
        this.idIdioma = idIdioma;
        this.duracaoLocacao = duracaoLocacao;
        this.taxaLocacao = taxaLocacao;
        this.custoSubstituicao = custoSubstituicao;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public int getIdIdioma() { return idIdioma; }
    public int getDuracaoLocacao() { return duracaoLocacao; }
    public double getTaxaLocacao() { return taxaLocacao; }
    public double getCustoSubstituicao() { return custoSubstituicao; }

    @Override
    public String toString() {
        return "ID: " + id + " | Título: " + titulo + " | Preço: " + taxaLocacao;
    }
}
