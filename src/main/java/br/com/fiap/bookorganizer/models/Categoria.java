package br.com.fiap.bookorganizer.models;

import org.springframework.hateoas.EntityModel;

import br.com.fiap.bookorganizer.controllers.CategoriaController;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Categoria extends EntityModel<Categoria> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 5, max = 100, message = "O nome tem que ter no mínimo 5 caracteres e no máximo 100")
    private String nome;


    public EntityModel<Categoria> toEntityModel(){
        return EntityModel.of(this, 
        linkTo(methodOn(CategoriaController.class).show(id)).withSelfRel(),
        linkTo(methodOn(CategoriaController.class).delete(id)).withRel("delete"),
        linkTo(methodOn(CategoriaController.class).index()).withRel("all")
        );
    }

}
