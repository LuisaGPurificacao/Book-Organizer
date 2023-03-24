package br.com.fiap.bookorganizer.models;

import java.util.Arrays;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String senha;
    private byte[] fotoPerfil;
    private int quantidadeLivrosLidos;
    private int meta;
    //private List<Livro> livros;

    protected Usuario() {
    }

    public Usuario(Integer id, String nome, String email, String senha,
            int meta) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.meta = meta;
    }

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", fotoPerfil="
                + Arrays.toString(fotoPerfil) + ", quantidadeLivrosLidos=" + quantidadeLivrosLidos + ", meta=" + meta
                + ", livros="; 
                //livros + "]";
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public byte[] getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(byte[] fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public int getQuantidadeLivrosLidos() {
        return quantidadeLivrosLidos;
    }

    public void setQuantidadeLivrosLidos(int quantidadeLivrosLidos) {
        this.quantidadeLivrosLidos = quantidadeLivrosLidos;
    }

    public int getMeta() {
        return meta;
    }

    public void setMeta(int meta) {
        this.meta = meta;
    }
/**
    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }
**/
}
