package br.com.fiap.bookorganizer.models;

import java.util.List;

public class Autor {

    private Integer id;
    private String nome;
    private List<Livro> livros;

    public Autor(Integer id, String nome, List<Livro> livros) {
        this.id = id;
        this.nome = nome;
        this.livros = livros;
    }

    @Override
    public String toString() {
        return "Autor [id=" + id + ", nome=" + nome + ", livros=" + livros + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

}
