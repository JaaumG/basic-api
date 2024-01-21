package br.dev.joaoguilherme.basicapi.dto.response;

import br.dev.joaoguilherme.basicapi.enums.GeneroEnum;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;


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


    public PessoaResponseDto(Long id, String nome, LocalDate dataNascimento, GeneroEnum genero, String email, String cpf) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.email = email;
        this.cpf = cpf;
    }

    public Long getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }

    public GeneroEnum getGenero() {
        return this.genero;
    }

    public String getEmail() {
        return this.email;
    }

    public String getCpf() {
        return this.cpf;
    }
}