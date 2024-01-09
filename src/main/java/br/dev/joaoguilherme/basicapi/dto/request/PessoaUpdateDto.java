package br.dev.joaoguilherme.basicapi.dto.request;

import br.dev.joaoguilherme.basicapi.enums.GeneroEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@RequiredArgsConstructor
@Schema(name = "Objeto de atualização de pessoa")
public class PessoaUpdateDto {

    @Schema(description = "Nome da pessoa", example = "João Guilherme")
    private final String nome;

    @Schema(description = "O gênero da pessoa", example = "MASCULINO")
    private final GeneroEnum genero;

    @Email(message = "O e-mail é inválido")
    @Schema(description = "E-mail da pessoa", example = "mail@joaoguilherme.dev")
    private final String email;

}