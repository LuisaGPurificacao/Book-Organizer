package br.com.fiap.bookorganizer.models;

import java.util.List;

import org.springframework.hateoas.EntityModel;

import br.com.fiap.bookorganizer.controllers.AutorController;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Autor extends EntityModel<Autor> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank (message = "O nome é obrigatório")
    @Size(min = 5, max = 100, message = "O nome tem que ter no mínimo 5 caracteres e no máximo 100")
    private String nome;
    
    @OneToMany(fetch = FetchType.LAZY)
    private List<Livro> livros;

    public EntityModel<Autor> toEntityModel(){
        return EntityModel.of(this, 
        linkTo(methodOn(AutorController.class).show(id)).withSelfRel(),
        linkTo(methodOn(AutorController.class).delete(id)).withRel("delete"),
        linkTo(methodOn(AutorController.class).index()).withRel("all")
        );
    }

}
