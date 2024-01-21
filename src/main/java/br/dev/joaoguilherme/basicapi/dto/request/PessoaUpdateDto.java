package br.dev.joaoguilherme.basicapi.dto.request;

import br.dev.joaoguilherme.basicapi.enums.GeneroEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;


@Schema(name = "Objeto de atualização de pessoa")
public class PessoaUpdateDto {

    @Schema(description = "Nome da pessoa", example = "João Guilherme")
    private final String nome;

    @Schema(description = "O gênero da pessoa", example = "MASCULINO")
    private final GeneroEnum genero;

    @Email(message = "O e-mail é inválido")
    @Schema(description = "E-mail da pessoa", example = "mail@joaoguilherme.dev")
    private final String email;


    public PessoaUpdateDto(String nome, GeneroEnum genero, @Email(message = "O e-mail é inválido") String email) {
        this.nome = nome;
        this.genero = genero;
        this.email = email;
    }

    public String getNome() {
        return this.nome;
    }

    public GeneroEnum getGenero() {
        return this.genero;
    }

    public @Email(message = "O e-mail é inválido") String getEmail() {
        return this.email;
    }
}