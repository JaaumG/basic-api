package br.dev.joaoguilherme.basicapi.dto.response;

import br.dev.joaoguilherme.basicapi.enums.GeneroEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@RequiredArgsConstructor
@Schema(name = "Objeto de resposta de pessoa")
public class PessoaResponseDto {

    @Schema(description = "ID da pessoa", example = "1")
    private final Long id;

    @Schema(description = "Nome da pessoa", example = "João Guilherme")
    private final String nome;

    @Schema(description = "Data de nascimento da pessoa", example = "2001-10-22")
    private final LocalDate dataNascimento;

    @Schema(description = "O gênero da pessoa", example = "MASCULINO")
    private final GeneroEnum genero;

    @Schema(description = "E-mail da pessoa", example = "mail@joaoguilherme.dev")
    private final String email;

    @Schema(description = "CPF da pessoa", example = "123.456.789-10")
    private final String cpf;

}