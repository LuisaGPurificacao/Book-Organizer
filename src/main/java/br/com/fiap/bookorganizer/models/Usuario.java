package br.com.fiap.bookorganizer.models;

import java.util.List;

import org.springframework.hateoas.EntityModel;

import com.fasterxml.jackson.annotation.JsonAlias;

import br.com.fiap.bookorganizer.controllers.UsuarioController;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuario extends EntityModel<Usuario> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 5, max = 100, message = "O nome tem que ter no mínimo 5 caracteres e no máximo 100")
    private String nome;

    @NotBlank(message = "O e-mail é obrigatório")
    @Email(message = "Insira um e-mail válido")
    private String email;

    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 8, max = 100, message = "A senha precisa ter no mínimo 8 caracteres e no máximo 100")
    private String senha;

    @JsonAlias("foto_perfil")
    private String fotoPerfil;

    @Positive(message = "A meta precisa ser um número positivo")
    private int meta;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Livro> livros;

    public EntityModel<Usuario> toEntityModel(){
        return EntityModel.of(this, 
        linkTo(methodOn(UsuarioController.class).show(id)).withSelfRel(),
        linkTo(methodOn(UsuarioController.class).delete(id)).withRel("delete"),
        linkTo(methodOn(UsuarioController.class).index()).withRel("all")
        );
    }

}
