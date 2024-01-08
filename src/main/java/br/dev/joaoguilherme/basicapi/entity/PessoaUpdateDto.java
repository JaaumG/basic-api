package br.dev.joaoguilherme.basicapi.entity;

import br.dev.joaoguilherme.basicapi.enums.Genero;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;


@Getter
@Setter
@RequiredArgsConstructor
@Schema(name = "Objeto de atualização de pessoa")
public class PessoaUpdateDto {

    @NotBlank(message = "O nome é obrigatório")
    @Schema(description = "Nome da pessoa", example = "João Guilherme")
    private final String nome;

    @NotNull(message = "O sexo é obrigatório")
    @Schema(description = "Data de nascimento da pessoa", example = "2001-10-22")
    private final Genero sexo;

    @Email(message = "O e-mail é inválido")
    @Schema(description = "E-mail da pessoa", example = "mail@joaoguilherme.dev")
    private final String email;

}