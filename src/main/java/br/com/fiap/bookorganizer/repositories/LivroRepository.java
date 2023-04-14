package br.com.fiap.bookorganizer.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.bookorganizer.models.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

    Page<Livro> findByCategoria(String categoria, Pageable pageable);

    Page<Livro> findByAutor(String autor, Pageable pageable);
}
