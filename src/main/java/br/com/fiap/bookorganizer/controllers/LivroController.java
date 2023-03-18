package br.com.fiap.bookorganizer.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.bookorganizer.models.Livro;

@RestController
public class LivroController {

    Logger log = LoggerFactory.getLogger(LivroController.class);

    List<Livro> livros = new ArrayList<>();
    
    @GetMapping("book-organizer/livros")
    public List<Livro> index(){
        return livros;
    }

    @PostMapping("book-organizer/livros")
    public ResponseEntity<Livro> create(@RequestBody Livro livro){
        log.info("cadastrando livro: " + livro);
        livro.setId(livros.size() + 1);
        livros.add(livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(livro);
    }

    @GetMapping("book-organizer/livros/{id}")
    public ResponseEntity<Livro> show(@PathVariable Integer id){
        log.info("buscando livro com id: " + id);
        var optionalLivro = livros.stream().filter(d -> d.getId().equals(id)).findFirst();

        if (optionalLivro.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(optionalLivro.get());
    }

    @DeleteMapping("book-organizer/livros/{id}")
    public ResponseEntity<Livro> delete(@PathVariable Integer id){
        log.info("apagando livro com id: " + id);
        var optionalLivro = livros.stream().filter(d -> d.getId().equals(id)).findFirst();

        if (optionalLivro.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        livros.remove(optionalLivro.get());
        
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("book-organizer/livros/{id}")
    public ResponseEntity<Livro> update(@PathVariable Integer id, @RequestBody Livro livro){
        log.info("atualizando livro com id: " + id);
        var optionalLivro = livros.stream().filter(d -> d.getId().equals(id)).findFirst();

        if (optionalLivro.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        livros.remove(optionalLivro.get());
        livro.setId(id);
        livros.add(livro);
        
        return ResponseEntity.status(HttpStatus.OK).body(livro);
    }
}
