package br.com.fiap.bookorganizer.models;

import java.util.Arrays;
import java.util.List;

public class Usuario {

    private Integer id;
    private String nome;
    private String email;
    private String senha;
    private byte[] fotoPerfil;
    private int quantidadeLivrosLidos;
    private int meta;
    private List<Livro> livros;

    public Usuario(Integer id, String nome, String email, String senha, byte[] fotoPerfil, int quantidadeLivrosLidos,
            int meta, List<Livro> livros) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.fotoPerfil = fotoPerfil;
        this.quantidadeLivrosLidos = quantidadeLivrosLidos;
        this.meta = meta;
        this.livros = livros;
    }

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", fotoPerfil="
                + Arrays.toString(fotoPerfil) + ", quantidadeLivrosLidos=" + quantidadeLivrosLidos + ", meta=" + meta
                + ", livros=" + livros + "]";
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

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

}
