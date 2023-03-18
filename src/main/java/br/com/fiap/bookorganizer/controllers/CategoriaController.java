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

import br.com.fiap.bookorganizer.models.Categoria;

@RestController
public class CategoriaController {

    Logger log = LoggerFactory.getLogger(CategoriaController.class);

    List<Categoria> categorias = new ArrayList<>();
    
    @GetMapping("book-organizer/categorias")
    public List<Categoria> index(){
        return categorias;
    }

    @PostMapping("book-organizer/categorias")
    public ResponseEntity<Categoria> create(@RequestBody Categoria categoria){
        log.info("cadastrando categoria: " + categoria);
        categoria.setId(categorias.size() + 1);
        categorias.add(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoria);
    }

    @GetMapping("book-organizer/categorias/{id}")
    public ResponseEntity<Categoria> show(@PathVariable Integer id){
        log.info("buscando categoria com id: " + id);
        var optionalCategoria = categorias.stream().filter(d -> d.getId().equals(id)).findFirst();

        if (optionalCategoria.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(optionalCategoria.get());
    }

    @DeleteMapping("book-organizer/categorias/{id}")
    public ResponseEntity<Categoria> delete(@PathVariable Integer id){
        log.info("apagando categoria com id: " + id);
        var optionalCategoria = categorias.stream().filter(d -> d.getId().equals(id)).findFirst();

        if (optionalCategoria.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

            categorias.remove(optionalCategoria.get());
        
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("book-organizer/categorias/{id}")
    public ResponseEntity<Categoria> update(@PathVariable Integer id, @RequestBody Categoria categoria){
        log.info("atualizando categoria com id: " + id);
        var optionalCategoria = categorias.stream().filter(d -> d.getId().equals(id)).findFirst();

        if (optionalCategoria.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        categorias.remove(optionalCategoria.get());
        categoria.setId(id);
        categorias.add(categoria);
        
        return ResponseEntity.status(HttpStatus.OK).body(categoria);
    }
}
