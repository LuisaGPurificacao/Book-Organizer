package br.com.fiap.bookorganizer.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.bookorganizer.models.Autor;
import br.com.fiap.bookorganizer.models.Livro;

@RestController
public class AutorController {
    
    @GetMapping("book-organizer/autores")
    public Autor show(){
        List<Livro> livros = new ArrayList<>();
        livros.add(new Livro(1, "Java", 200, 5, 100));
        livros.add(new Livro(2, "Spring", 250, 5, 25));
        return new Autor(1, "João Carlos", livros);
    }

}
