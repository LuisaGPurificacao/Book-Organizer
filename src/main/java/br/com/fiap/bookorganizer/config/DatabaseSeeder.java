package br.com.fiap.bookorganizer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.bookorganizer.models.Autor;
import br.com.fiap.bookorganizer.models.Categoria;
import br.com.fiap.bookorganizer.models.Livro;
import br.com.fiap.bookorganizer.models.Usuario;
import br.com.fiap.bookorganizer.repositories.AutorRepository;
import br.com.fiap.bookorganizer.repositories.CategoriaRepository;
import br.com.fiap.bookorganizer.repositories.LivroRepository;
import br.com.fiap.bookorganizer.repositories.UsuarioRepository;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    AutorRepository autorRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    LivroRepository livroRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public void run(String... args) throws Exception {
        usuarioRepository.save(new Usuario(null, "Maria", "maria@email.com", "senha123", "foto", 10, null));
        categoriaRepository.save(new Categoria(null, "Programação"));
        autorRepository.save(new Autor(null, "João Lima", null));
        livroRepository.save(new Livro(null, "Domain Driven Design", 255, 5, calcularStatus(255, 20), 20, categoriaRepository.findById(1L).get(), autorRepository.findById(1L).get()));
    }

    private double calcularStatus(int quantidadePaginas, int paginaAtual) {
        double status = (paginaAtual*100) / quantidadePaginas;
        return status;
    }

}
