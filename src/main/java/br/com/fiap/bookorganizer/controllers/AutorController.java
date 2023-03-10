package br.com.fiap.bookorganizer.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.bookorganizer.models.Autor;

@RestController
public class AutorController {

    @GetMapping("book-organizer/autores")
    public Autor show(){
        return new Autor(1, "João Carlos");
    }

}
