package br.com.fiap.bookorganizer.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    // private List<Livro> livros;

    protected Autor() {
    }

    public Autor(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Autor [id=" + id + ", nome=" + nome + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    /*
     * public List<Livro> getLivros() {
     * return livros;
     * }
     * 
     * public void setLivros(List<Livro> livros) {
     * this.livros = livros;
     * }
     */

}
