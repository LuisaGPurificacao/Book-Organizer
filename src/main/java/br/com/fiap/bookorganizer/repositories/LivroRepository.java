package br.com.fiap.bookorganizer.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.bookorganizer.models.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

    Page<Livro> findByCategoriaNomeContainingAndAutorNomeContaining(String categoria, String autor, Pageable pageable);

    Page<Livro> findByAutorNomeContaining(String autor, Pageable pageable);

    Page<Livro> findByCategoriaNomeContaining(String categoria, Pageable pageable);
}
