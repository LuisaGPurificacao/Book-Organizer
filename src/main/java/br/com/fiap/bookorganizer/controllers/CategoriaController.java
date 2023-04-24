package br.com.fiap.bookorganizer.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
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
import br.com.fiap.bookorganizer.models.Categoria;
import br.com.fiap.bookorganizer.repositories.CategoriaRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("book-organizer/categorias")
public class CategoriaController {

    Logger log = LoggerFactory.getLogger(getClass());
    
    @Autowired
    CategoriaRepository repository;

    @GetMapping
    public List<EntityModel<Categoria>> index(){
        return repository.findAll().stream().map(Categoria::toEntityModel).toList();
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid Categoria categoria){
        log.info("cadastrando categoria: " + categoria);
        repository.save(categoria);
        return ResponseEntity.created(categoria.toEntityModel().getRequiredLink("self").toUri()).body(categoria.toEntityModel());
    }

    @GetMapping("{id}")
    public EntityModel<Categoria> show(@PathVariable Long id){
        log.info("buscando categoria com id: " + id);
        return getCategoria(id).toEntityModel();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Categoria> delete(@PathVariable Long id){
        log.info("apagando categoria com id: " + id);
        repository.delete(getCategoria(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public EntityModel<Categoria> update(@PathVariable Long id, @RequestBody @Valid Categoria categoria){
        log.info("atualizando categoria com id: " + id);
        getCategoria(id);
        categoria.setId(id);
        repository.save(categoria);
        return categoria.toEntityModel();
    }

    private Categoria getCategoria(Long id){
        return repository.findById(id).orElseThrow(() -> new RestNotFoundException("categoria não encontrada"));
    }
}
