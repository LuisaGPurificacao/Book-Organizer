package br.com.fiap.bookorganizer.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;

import br.com.fiap.bookorganizer.controllers.LivroController;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Livro extends EntityModel<Livro> {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "O título é obrigatório")
    @Size(min = 5, max = 100, message = "O título tem que ter no mínimo 5 caracteres e no máximo 100")
    private String titulo;
    
    @NotNull(message = "A quantidade de páginas é obrigatória")
    @Positive(message = "A quantidade de páginas precisa ser um número positivo")
    private int quantidadePaginas;
    
    private int avaliacao;
    
    @NotNull(message = "O status é obrigatório")
    private double status;
    
    @NotNull (message = "A página atual é obrigatória")
    @Positive(message = "A página atual precisa ser um número positivo")
    private int paginaAtual;

    @ManyToOne
    private Categoria categoria;
    
    @ManyToOne
    private Autor autor;

    public EntityModel<Livro> toEntityModel(){
        return EntityModel.of(this, 
        linkTo(methodOn(LivroController.class).show(id)).withSelfRel(),
        linkTo(methodOn(LivroController.class).delete(id)).withRel("delete"),
        linkTo(methodOn(LivroController.class).index(null, null, Pageable.unpaged())).withRel("all")
        );
    }

}
