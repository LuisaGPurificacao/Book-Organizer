package br.com.fiap.bookorganizer.controllers;

import java.util.ArrayList;
import java.util.HexFormat;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.bookorganizer.models.Autor;
import br.com.fiap.bookorganizer.models.Categoria;
import br.com.fiap.bookorganizer.models.Livro;
import br.com.fiap.bookorganizer.models.Usuario;

@RestController
public class UsuarioController {
    
    @GetMapping("book-organizer/usuarios")
    public Usuario show(){
        Autor autor = new Autor(1, "João Carlos");
        Categoria categoria = new Categoria(1, "Tecnologia");
        byte[] fotoPerfil = HexFormat.of().parseHex("e04fd020ea3a6910a2d808002b30309d");
        List<Livro> livros = new ArrayList<>();
        livros.add(new Livro(1, "Java", 200, 5, 100, categoria, autor));
        livros.add(new Livro(2, "Spring", 250, 5, 25, categoria, autor));
        return new Usuario(1, "Lívia Keller", "kellerlivia@gmail.com", "carvalho123", fotoPerfil, 5, 20, livros);
    }

}
