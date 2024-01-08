package br.dev.joaoguilherme.basicapi.repository;

import br.dev.joaoguilherme.basicapi.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}