package br.dev.joaoguilherme.basicapi.services;

import br.dev.joaoguilherme.basicapi.controller.PessoaController;
import br.dev.joaoguilherme.basicapi.dto.PessoaCreateDto;
import br.dev.joaoguilherme.basicapi.dto.PessoaResponseDto;
import br.dev.joaoguilherme.basicapi.entity.Pessoa;
import br.dev.joaoguilherme.basicapi.dto.PessoaUpdateDto;
import br.dev.joaoguilherme.basicapi.mappings.PessoaMapper;
import br.dev.joaoguilherme.basicapi.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
@Validated
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository repository;
    private final PessoaMapper mapper;


    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<String> createPessoa(PessoaCreateDto pessoaCreateDto){
        Pessoa pessoa = mapper.toEntity(pessoaCreateDto);
        pessoa = repository.saveAndFlush(pessoa);
        return ResponseEntity.created(linkTo(methodOn(PessoaController.class).getPessoa(pessoa.getId())).toUri()).body("Pessoa criada com sucesso");
    }

    @Transactional(readOnly = true)
    public ResponseEntity<PessoaResponseDto> getPessoa(Long id){
        Pessoa pessoa = repository.findById(id).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
        PessoaResponseDto pessoaResponseDto = mapper.toDto(pessoa);
        return ResponseEntity.ok(pessoaResponseDto);
    }

    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<String> updatePessoa(Long id, PessoaUpdateDto pessoaUpdateDto){
        Pessoa pessoa = repository.findById(id).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
        pessoa = mapper.partialUpdate(pessoaUpdateDto, pessoa);
        repository.saveAndFlush(pessoa);
        return ResponseEntity.ok("Pessoa atualizada com sucesso");
    }

    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<String> deletePessoa(Long id){
        repository.deleteById(id);
        return ResponseEntity.ok("Pessoa deletada com sucesso");
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Page<PessoaResponseDto>> listPessoas(Pageable pageable) {
        Page<PessoaResponseDto> pessoaResponseDtos = repository.findAll(pageable).map(mapper::toDto);
        return ResponseEntity.ok(pessoaResponseDtos);
    }
}
