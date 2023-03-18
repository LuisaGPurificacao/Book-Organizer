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

import br.com.fiap.bookorganizer.models.Usuario;

@RestController
public class UsuarioController {

    Logger log = LoggerFactory.getLogger(UsuarioController.class);

    List<Usuario> usuarios = new ArrayList<>();

    @GetMapping("book-organizer/usuarios")
    public List<Usuario> index() {
        return usuarios;
    }

    @PostMapping("book-organizer/usuarios")
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
        log.info("cadastrando usuário: " + usuario);
        usuario.setId(usuarios.size() + 1);
        usuarios.add(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @GetMapping("book-organizer/usuarios/{id}")
    public ResponseEntity<Usuario> show(@PathVariable Integer id) {
        log.info("buscando usuário com id: " + id);
        var optionalUsuario = usuarios.stream().filter(d -> d.getId().equals(id)).findFirst();

        if (optionalUsuario.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(optionalUsuario.get());
    }

    @DeleteMapping("book-organizer/usuarios/{id}")
    public ResponseEntity<Usuario> delete(@PathVariable Integer id) {
        log.info("apagando usuário com id: " + id);
        var optionalUsuario = usuarios.stream().filter(d -> d.getId().equals(id)).findFirst();

        if (optionalUsuario.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        usuarios.remove(optionalUsuario.get());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("book-organizer/usuarios/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Integer id, @RequestBody Usuario usuario) {
        log.info("atualizando usuário com id: " + id);
        var optionalUsuario = usuarios.stream().filter(d -> d.getId().equals(id)).findFirst();

        if (optionalUsuario.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        usuarios.remove(optionalUsuario.get());
        usuario.setId(id);
        usuarios.add(usuario);

        return ResponseEntity.status(HttpStatus.OK).body(usuario);
    }

}
