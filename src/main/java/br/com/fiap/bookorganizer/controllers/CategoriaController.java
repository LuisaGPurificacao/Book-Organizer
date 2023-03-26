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

import br.com.fiap.bookorganizer.models.Categoria;
import br.com.fiap.bookorganizer.repositories.CategoriaRepository;

@RestController
@RequestMapping("book-organizer/categorias")
public class CategoriaController {

    Logger log = LoggerFactory.getLogger(CategoriaController.class);
    
    @Autowired
    CategoriaRepository repository;

    @GetMapping
    public List<Categoria> index(){
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Categoria> create(@RequestBody Categoria categoria){
        log.info("cadastrando categoria: " + categoria);
        repository.save(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoria);
    }

    @GetMapping("{id}")
    public ResponseEntity<Categoria> show(@PathVariable Long id){
        log.info("buscando categoria com id: " + id);
        Optional<Categoria> optionalCategoria = repository.findById(id);

        if (optionalCategoria.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(optionalCategoria.get());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Categoria> delete(@PathVariable Long id){
        log.info("apagando categoria com id: " + id);

        if (!repository.existsById(id))
            return ResponseEntity.notFound().build();

            repository.deleteById(id);;
        
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Categoria> update(@PathVariable Long id, @RequestBody Categoria categoria){
        log.info("atualizando categoria com id: " + id);
        var optionalCategoria = repository.findById(id);

        if (optionalCategoria.isEmpty())
            return ResponseEntity.notFound().build();

        categoria.setId(id);
        repository.save(categoria);
        
        return ResponseEntity.ok(categoria);
    }
}
