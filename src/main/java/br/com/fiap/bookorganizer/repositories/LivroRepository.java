package br.com.fiap.bookorganizer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.bookorganizer.models.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer>{
    
}
