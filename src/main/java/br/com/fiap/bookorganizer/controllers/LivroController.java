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

import br.com.fiap.bookorganizer.models.Livro;
import br.com.fiap.bookorganizer.repositories.LivroRepository;

@RestController
@RequestMapping("book-organizer/livros")
public class LivroController {

    Logger log = LoggerFactory.getLogger(LivroController.class);

    @Autowired
    LivroRepository repository;
    
    @GetMapping
    public List<Livro> index(){
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Livro> create(@RequestBody Livro livro){
        log.info("cadastrando livro: " + livro);
        repository.save(livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(livro);
    }

    @GetMapping("{id}")
    public ResponseEntity<Livro> show(@PathVariable Integer id){
        log.info("buscando livro com id: " + id);
        Optional<Livro> optionalLivro = repository.findById(id);

        if (optionalLivro.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(optionalLivro.get());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Livro> delete(@PathVariable Integer id){
        log.info("apagando livro com id: " + id);

        if (!repository.existsById(id))
            return ResponseEntity.notFound().build();

        repository.deleteById(id);
        
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Livro> update(@PathVariable Integer id, @RequestBody Livro livro){
        log.info("atualizando livro com id: " + id);
        var optionalLivro = repository.findById(id);

        if (optionalLivro.isEmpty())
            return ResponseEntity.notFound().build();

        livro.setId(id);
        repository.save(livro);
        
        return ResponseEntity.ok(livro);
    }
}
