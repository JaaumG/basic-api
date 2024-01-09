package br.dev.joaoguilherme.basicapi.dto.request;

import br.dev.joaoguilherme.basicapi.enums.GeneroEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
@Schema(name = "Objeto de criação de pessoa")
public class PessoaCreateDto {

    @Schema(description = "Nome da pessoa", example = "João Guilherme")
    @NotBlank(message = "O nome é obrigatório")
    private final String nome;

    @Schema(description = "Data de nascimento da pessoa", example = "2001-10-22")
    @NotNull(message = "A data de nascimento é obrigatória")
    private final LocalDate dataNascimento;

    @NotNull(message = "O gênero é obrigatório")
    @Schema(description = "O gênero da pessoa", example = "MASCULINO")
    private final GeneroEnum genero;

    @Schema(description = "E-mail da pessoa", example = "mail@joaoguilherme.dev")
    @Email(message = "O e-mail é inválido")
    private final String email;

    @CPF(message = "O CPF é inválido")
    @Schema(description = "CPF da pessoa", example = "123.456.789-10")
    @NotBlank(message = "O cpf é obrigatório")
    private final String cpf;

}