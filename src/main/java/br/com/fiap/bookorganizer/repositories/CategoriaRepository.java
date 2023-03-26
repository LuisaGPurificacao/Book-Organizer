package br.com.fiap.bookorganizer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.bookorganizer.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
}
