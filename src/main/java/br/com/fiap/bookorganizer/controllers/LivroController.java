package br.com.fiap.bookorganizer.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.bookorganizer.exception.RestNotFoundException;
import br.com.fiap.bookorganizer.models.Livro;
import br.com.fiap.bookorganizer.repositories.LivroRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("book-organizer/livros")
public class LivroController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    LivroRepository repository;
    
    @GetMapping
    public Page<Livro> index(@RequestParam(required = false) String categoria, @RequestParam(required = false) String autor, @PageableDefault(size = 5, page = 0, sort = "titulo", direction = Direction.ASC) Pageable pageable) {
        if (categoria == null && autor == null)
            return repository.findAll(pageable);
        if (categoria == null)
            return repository.findByAutorNomeContaining(autor, pageable);
        if (autor == null)
            return repository.findByCategoriaNomeContaining(categoria, pageable);
        return repository.findByCategoriaNomeContainingAndAutorNomeContaining(categoria, autor, pageable);
    }

    @PostMapping
    public ResponseEntity<Livro> create(@RequestBody @Valid Livro livro){
        log.info("cadastrando livro: " + livro);
        repository.save(livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(livro);
    }

    @GetMapping("{id}")
    public ResponseEntity<Livro> show(@PathVariable Long id){
        log.info("buscando livro com id: " + id);
        return ResponseEntity.ok(getLivro(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Livro> delete(@PathVariable Long id){
        log.info("apagando livro com id: " + id);
        repository.delete(getLivro(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Livro> update(@PathVariable Long id, @RequestBody @Valid Livro livro){
        log.info("atualizando livro com id: " + id);
        getLivro(id);
        livro.setId(id);
        repository.save(livro);
        return ResponseEntity.ok(livro);
    }

    private Livro getLivro(Long id){
        return repository.findById(id).orElseThrow(() -> new RestNotFoundException("livro não encontrado"));
    }
}
