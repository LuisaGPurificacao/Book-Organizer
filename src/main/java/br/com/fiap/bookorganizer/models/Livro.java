package br.com.fiap.bookorganizer.models;

public class Livro {
    
    private Integer id;
    private String titulo;
    private int quantidadePaginas;
    private int avaliacao;
    private double status;
    private int paginaAtual;

    public Livro(Integer id, String titulo, int quantidadePaginas, int avaliacao, int paginaAtual) {
        this.id = id;
        this.titulo = titulo;
        this.quantidadePaginas = quantidadePaginas;
        this.avaliacao = avaliacao;
        this.paginaAtual = paginaAtual;
    }

    @Override
    public String toString() {
        return "Livro [id=" + id + ", titulo=" + titulo + ", quantidadePaginas=" + quantidadePaginas + ", avaliacao="
                + avaliacao + ", status=" + status + ", paginaAtual=" + paginaAtual + "]";
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public int getQuantidadePaginas() {
        return quantidadePaginas;
    }
    public void setQuantidadePaginas(int quantidadePaginas) {
        this.quantidadePaginas = quantidadePaginas;
    }
    public int getAvaliacao() {
        return avaliacao;
    }
    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }
    public double getStatus() {
        return status;
    }
    public void setStatus(double status) {
        this.status = status;
    }
    public int getPaginaAtual() {
        return paginaAtual;
    }
    public void setPaginaAtual(int paginaAtual) {
        this.paginaAtual = paginaAtual;
    }
}
