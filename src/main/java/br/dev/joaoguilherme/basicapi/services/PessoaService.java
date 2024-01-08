package br.dev.joaoguilherme.basicapi.services;

import br.dev.joaoguilherme.basicapi.dto.PessoaCreateDto;
import br.dev.joaoguilherme.basicapi.dto.PessoaResponseDto;
import br.dev.joaoguilherme.basicapi.entity.Pessoa;
import br.dev.joaoguilherme.basicapi.dto.PessoaUpdateDto;
import br.dev.joaoguilherme.basicapi.exception.NotFoundException;
import br.dev.joaoguilherme.basicapi.mappings.PessoaMapper;
import br.dev.joaoguilherme.basicapi.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Service
@Validated
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository repository;
    private final PessoaMapper mapper;

    @Transactional(rollbackFor = Exception.class)
    public Pessoa createPessoa(PessoaCreateDto pessoaCreateDto){
        Pessoa pessoa = mapper.toEntity(pessoaCreateDto);
        return repository.saveAndFlush(pessoa);
    }

    @Transactional(readOnly = true)
    public Optional<PessoaResponseDto> getPessoa(Long id){
        return repository.findById(id).map(mapper::toDto);
    }

    @Transactional(rollbackFor = Exception.class)
    public void updatePessoa(Long id, PessoaUpdateDto pessoaUpdateDto){
        Pessoa pessoa = repository.findById(id).orElseThrow(() -> new NotFoundException("Pessoa", id));
        pessoa = mapper.partialUpdate(pessoaUpdateDto, pessoa);
        repository.saveAndFlush(pessoa);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deletePessoa(Long id){
        repository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Page<PessoaResponseDto> listPessoas(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toDto);
    }

}
