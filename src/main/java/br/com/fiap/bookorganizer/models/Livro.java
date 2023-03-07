package br.com.fiap.bookorganizer.models;

public class Livro {
    
    private String titulo;

    private int quantidadePaginas;

    private int avaliacao;

    private double status;

    private int paginaAtual;

    public Livro(String titulo, int quantidadePaginas, int avaliacao, double status, int paginaAtual) {
        this.titulo = titulo;
        this.quantidadePaginas = quantidadePaginas;
        this.avaliacao = avaliacao;
        this.status = status;
        this.paginaAtual = paginaAtual;
    }

    @Override
    public String toString() {
        return "Livro [titulo=" + titulo + ", quantidadePaginas=" + quantidadePaginas + ", avaliacao=" + avaliacao
                + ", status=" + status + ", paginaAtual=" + paginaAtual + "]";
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
