package br.com.fiap.bookorganizer.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.bookorganizer.models.Categoria;

@RestController
public class CategoriaController {
    
    @GetMapping("book-organizer/categorias")
    public Categoria show(){
        return new Categoria(2, "Tecnologia");
    }
}
