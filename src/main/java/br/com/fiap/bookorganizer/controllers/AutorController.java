package br.com.fiap.bookorganizer.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.bookorganizer.exception.RestNotFoundException;
import br.com.fiap.bookorganizer.models.Autor;
import br.com.fiap.bookorganizer.repositories.AutorRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("book-organizer/autores")
public class AutorController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    AutorRepository repository;

    @GetMapping
    public List<Autor> index(){
        return repository.findAll();
    }
    
    @PostMapping
    public ResponseEntity<Autor> create(@RequestBody @Valid Autor autor){
        log.info("cadastrando autor: " + autor);
        repository.save(autor);
        return ResponseEntity.status(HttpStatus.CREATED).body(autor);
    }

    @GetMapping("{id}")
    public ResponseEntity<Autor> show(@PathVariable Long id){
        log.info("buscando autor com id: " + id);
        return ResponseEntity.ok(getAutor(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Autor> delete(@PathVariable Long id){
        log.info("apagando autor com id: " + id);
        repository.delete(getAutor(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Autor> update(@PathVariable Long id, @RequestBody @Valid Autor autor){
        log.info("atualizando autor com id: " + id);
        getAutor(id);
        autor.setId(id);
        repository.save(autor);
        return ResponseEntity.ok(autor);
    }

    private Autor getAutor(Long id){
        return repository.findById(id).orElseThrow(() -> new RestNotFoundException("Autor não encontrado"));
    }

}
