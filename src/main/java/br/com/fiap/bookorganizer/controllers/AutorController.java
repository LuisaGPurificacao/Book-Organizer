package br.com.fiap.bookorganizer.controllers;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.bookorganizer.models.Autor;
import br.com.fiap.bookorganizer.repositories.AutorRepository;

@RestController
public class AutorController {

    Logger log = LoggerFactory.getLogger(LivroController.class);

    @Autowired
    AutorRepository repository;

    @GetMapping("book-organizer/autores")
    public List<Autor> index(){
        return repository.findAll();
    }
    
    @PostMapping("book-organizer/autores")
    public ResponseEntity<Autor> create(@RequestBody Autor autor){
        log.info("cadastrando autor: " + autor);
        repository.save(autor);
        return ResponseEntity.status(HttpStatus.CREATED).body(autor);
    }

    @GetMapping("book-organizer/autores/{id}")
    public ResponseEntity<Autor> show(@PathVariable Integer id){
        log.info("buscando autor com id: " + id);
        Optional<Autor> optionalAutor = repository.findById(id);

        if (optionalAutor.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(optionalAutor.get());
    }

    @DeleteMapping("book-organizer/autores/{id}")
    public ResponseEntity<Autor> delete(@PathVariable Integer id){
        log.info("apagando autor com id: " + id);

        if (!repository.existsById(id))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        repository.deleteById(id);
        
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("book-organizer/autores/{id}")
    public ResponseEntity<Autor> update(@PathVariable Integer id, @RequestBody Autor autor){
        log.info("atualizando autor com id: " + id);
        var optionalAutor = repository.findById(id);

        if (optionalAutor.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        autor.setId(id);
        repository.save(autor);
        
        return ResponseEntity.status(HttpStatus.OK).body(autor);
    }

}
