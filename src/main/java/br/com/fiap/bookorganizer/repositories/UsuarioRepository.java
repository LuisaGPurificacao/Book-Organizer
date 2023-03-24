package br.com.fiap.bookorganizer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.bookorganizer.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
}
