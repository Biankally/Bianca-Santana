import java.util.Objects; 

public class Filme {
    private int id;
    private String titulo;
    private String descricao;
    private int anoLancamento;

    public Filme(int id, String titulo, String descricao, int anoLancamento) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.anoLancamento = anoLancamento;
    }

    public Filme(String titulo, String descricao, int anoLancamento) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.anoLancamento = anoLancamento;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public int getAnoLancamento() { return anoLancamento; }
    public void setAnoLancamento(int anoLancamento) { this.anoLancamento = anoLancamento; }

    @Override
    public String toString() {
        return "Filme [ID=" + id + ", Título=" + titulo + ", Ano=" + anoLancamento + "]";
    }
}