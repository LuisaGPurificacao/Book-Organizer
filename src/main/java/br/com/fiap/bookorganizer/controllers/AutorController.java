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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.bookorganizer.models.Autor;
import br.com.fiap.bookorganizer.repositories.AutorRepository;

@RestController
@RequestMapping("book-organizer/autores")
public class AutorController {

    Logger log = LoggerFactory.getLogger(LivroController.class);

    @Autowired
    AutorRepository repository;

    @GetMapping
    public List<Autor> index(){
        return repository.findAll();
    }
    
    @PostMapping
    public ResponseEntity<Autor> create(@RequestBody Autor autor){
        log.info("cadastrando autor: " + autor);
        repository.save(autor);
        return ResponseEntity.status(HttpStatus.CREATED).body(autor);
    }

    @GetMapping("{id}")
    public ResponseEntity<Autor> show(@PathVariable Long id){
        log.info("buscando autor com id: " + id);
        Optional<Autor> optionalAutor = repository.findById(id);

        if (optionalAutor.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(optionalAutor.get());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Autor> delete(@PathVariable Long id){
        log.info("apagando autor com id: " + id);

        if (!repository.existsById(id))
            return ResponseEntity.notFound().build();

        repository.deleteById(id);
        
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Autor> update(@PathVariable Long id, @RequestBody Autor autor){
        log.info("atualizando autor com id: " + id);
        var optionalAutor = repository.findById(id);

        if (optionalAutor.isEmpty())
            return ResponseEntity.notFound().build();

        autor.setId(id);
        repository.save(autor);
        
        return ResponseEntity.ok(autor);
    }

}
