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

import br.com.fiap.bookorganizer.models.Usuario;
import br.com.fiap.bookorganizer.repositories.UsuarioRepository;

@RestController
@RequestMapping("book-organizer/usuarios")
public class UsuarioController {

    Logger log = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    UsuarioRepository repository;

    @GetMapping
    public List<Usuario> index() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
        log.info("cadastrando usuário: " + usuario);
        repository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @GetMapping("{id}")
    public ResponseEntity<Usuario> show(@PathVariable Long id) {
        log.info("buscando usuário com id: " + id);
        Optional<Usuario> optionalUsuario = repository.findById(id);

        if (optionalUsuario.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(optionalUsuario.get());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Usuario> delete(@PathVariable Long id) {
        log.info("apagando usuário com id: " + id);

        if (!repository.existsById(id))
            return ResponseEntity.notFound().build();

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario usuario) {
        log.info("atualizando usuário com id: " + id);
        Optional<Usuario> optionalUsuario = repository.findById(id);

        if (optionalUsuario.isEmpty())
            return ResponseEntity.notFound().build();

        usuario.setId(id);
        repository.save(usuario);

        return ResponseEntity.ok(usuario);
    }

}
