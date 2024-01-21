package br.dev.joaoguilherme.basicapi.entity;

import br.dev.joaoguilherme.basicapi.enums.GeneroEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "pessoa", indexes = {
        @Index(name = "idx_pessoa_email", columnList = "email")
}, uniqueConstraints = {
        @UniqueConstraint(name = "uk_pessoa_cpf", columnNames = {"cpf"})
})
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
    @NotNull(message = "O gênero é obrigatório")
    @Column(name = "genero", nullable = false)
    private GeneroEnum genero;

    @Column(name = "email")
    @Email(message = "O e-mail é inválido")
    private String email;

    @CPF(message = "O CPF é inválido")
    @Column(name = "cpf", nullable = false)
    @NotBlank(message = "O CPF é obrigatório")
    private String cpf;

    public Pessoa() {
    }

    public Pessoa(Long id, @NotBlank(message = "O nome é obrigatório") String nome, @NotNull(message = "A data de nascimento é obrigatória") LocalDate dataNascimento, @NotNull(message = "O gênero é obrigatório") GeneroEnum genero, @Email(message = "O e-mail é inválido") String email, @CPF(message = "O CPF é inválido") @NotBlank(message = "O CPF é obrigatório") String cpf) {
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

    public @NotBlank(message = "O nome é obrigatório") String getNome() {
        return this.nome;
    }

    public @NotNull(message = "A data de nascimento é obrigatória") LocalDate getDataNascimento() {
        return this.dataNascimento;
    }

    public @NotNull(message = "O gênero é obrigatório") GeneroEnum getGenero() {
        return this.genero;
    }

    public @Email(message = "O e-mail é inválido") String getEmail() {
        return this.email;
    }

    public @CPF(message = "O CPF é inválido") @NotBlank(message = "O CPF é obrigatório") String getCpf() {
        return this.cpf;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(@NotBlank(message = "O nome é obrigatório") String nome) {
        this.nome = nome;
    }

    public void setDataNascimento(@NotNull(message = "A data de nascimento é obrigatória") LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setGenero(@NotNull(message = "O gênero é obrigatório") GeneroEnum genero) {
        this.genero = genero;
    }

    public void setEmail(@Email(message = "O e-mail é inválido") String email) {
        this.email = email;
    }

    public void setCpf(@CPF(message = "O CPF é inválido") @NotBlank(message = "O CPF é obrigatório") String cpf) {
        this.cpf = cpf;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Pessoa pessoa = (Pessoa) o;
        return getId() != null && Objects.equals(getId(), pessoa.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Pessoa(id=" + this.getId() + ", nome=" + this.getNome() + ", dataNascimento=" + this.getDataNascimento() + ", genero=" + this.getGenero() + ", email=" + this.getEmail() + ", cpf=" + this.getCpf() + ")";
    }

}