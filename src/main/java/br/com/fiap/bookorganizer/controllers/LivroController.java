package br.com.fiap.bookorganizer.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.bookorganizer.models.Autor;
import br.com.fiap.bookorganizer.models.Categoria;
import br.com.fiap.bookorganizer.models.Livro;

@RestController
public class LivroController {
    
    @GetMapping("book-organizer/livros")
    public Livro show(){
        return new Livro(1, "Clean Code", 500, 5, 100, new Categoria(2, "Tecnologia"), new Autor(1, "João Carlos"));
    }
}
