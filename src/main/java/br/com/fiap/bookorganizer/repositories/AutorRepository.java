package br.com.fiap.bookorganizer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.bookorganizer.models.Autor;

public interface AutorRepository extends JpaRepository<Autor, Integer> {
    
}
