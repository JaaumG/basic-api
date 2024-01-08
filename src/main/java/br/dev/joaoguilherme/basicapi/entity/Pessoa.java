package br.dev.joaoguilherme.basicapi.entity;

import br.dev.joaoguilherme.basicapi.enums.GeneroEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    @Column(name = "nome", nullable = false)
    private String nome;

    @NotNull(message = "A data de nascimento é obrigatória")
    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "O sexo é obrigatório")
    @Column(name = "sexo", nullable = false)
    private GeneroEnum sexo;

    @Column(name = "email")
    @Email(message = "O e-mail é inválido")
    private String email;

    @CPF(message = "O CPF é inválido")
    @Column(name = "cpf", nullable = false)
    @NotBlank(message = "O CPF é obrigatório")
    private String cpf;


}