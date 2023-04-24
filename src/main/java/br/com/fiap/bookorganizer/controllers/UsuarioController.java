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
import br.com.fiap.bookorganizer.models.Usuario;
import br.com.fiap.bookorganizer.repositories.UsuarioRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("book-organizer/usuarios")
public class UsuarioController {

    Logger log = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    UsuarioRepository repository;

    @GetMapping
    public List<EntityModel<Usuario>> index() {
        return repository.findAll().stream().map(Usuario::toEntityModel).toList();
    }

    @PostMapping
    public ResponseEntity<EntityModel<Usuario>> create(@RequestBody @Valid Usuario usuario) {
        log.info("cadastrando usuário: " + usuario);
        repository.save(usuario);
        return ResponseEntity.created(usuario.toEntityModel().getRequiredLink("self").toUri()).body(usuario.toEntityModel());
    }

    @GetMapping("{id}")
    public EntityModel<Usuario> show(@PathVariable Long id) {
        log.info("buscando usuário com id: " + id);
        return getUsuario(id).toEntityModel();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Usuario> delete(@PathVariable Long id) {
        log.info("apagando usuário com id: " + id);
        repository.delete(getUsuario(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public EntityModel<Usuario> update(@PathVariable Long id, @RequestBody @Valid Usuario usuario) {
        log.info("atualizando usuário com id: " + id);
        getUsuario(id);
        usuario.setId(id);
        repository.save(usuario);
        return usuario.toEntityModel();
    }

    private Usuario getUsuario(Long id){
        return repository.findById(id).orElseThrow(() -> new RestNotFoundException("Usuário não encontrado"));
    }

}
