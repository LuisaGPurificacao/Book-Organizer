package br.com.fiap.bookorganizer.models;

public class Livro {
    
    private Integer id;
    private String titulo;
    private int quantidadePaginas;
    private int avaliacao;
    private double status;
    private int paginaAtual;
    private Categoria categoria;
    private Autor autor;

    public Livro(Integer id, String titulo, int quantidadePaginas, int avaliacao, int paginaAtual, Categoria categoria, Autor autor) {
        this.id = id;
        this.titulo = titulo;
        this.quantidadePaginas = quantidadePaginas;
        this.avaliacao = avaliacao;
        this.paginaAtual = paginaAtual;
        this.categoria = categoria;
        this.autor = autor;
        setStatus(quantidadePaginas, paginaAtual);
    }

    @Override
    public String toString() {
        return "Livro [id=" + id + ", titulo=" + titulo + ", quantidadePaginas=" + quantidadePaginas + ", avaliacao="
                + avaliacao + ", status=" + status + ", paginaAtual=" + paginaAtual + ", categoria=" + categoria
                + ", autor=" + autor + "]";
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
    public void setStatus(int quantidadePaginas, int paginaAtual) {
        this.status = ((double)paginaAtual *100) / (double)quantidadePaginas;
    }
    public int getPaginaAtual() {
        return paginaAtual;
    }
    public void setPaginaAtual(int paginaAtual) {
        this.paginaAtual = paginaAtual;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    
}
