package br.com.fiap.bookorganizer.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank (message = "O nome é obrigatório")
    @Size(min = 5, max = 100, message = "O nome tem que ter no mínimo 5 caracteres e no máximo 100")
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
