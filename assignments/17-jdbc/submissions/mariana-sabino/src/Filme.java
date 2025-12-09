public class Filme {
    private int id;
    private String titulo;
    private int idiomaId;
    private int duracaoLocacao;
    private double taxaLocacao;
    private double custoReposicao;

    public Filme() {}

    public Filme(String titulo, int idiomaId, int duracaoLocacao, double taxaLocacao, double custoReposicao) {
        this.titulo = titulo;
        this.idiomaId = idiomaId;
        this.duracaoLocacao = duracaoLocacao;
        this.taxaLocacao = taxaLocacao;
        this.custoReposicao = custoReposicao;
    }

    public String getTitulo() { return titulo; }
    public int getIdiomaId() { return idiomaId; }
    public int getDuracaoLocacao() { return duracaoLocacao; }
    public double getTaxaLocacao() { return taxaLocacao; }
    public double getCustoReposicao() { return custoReposicao; }
}
