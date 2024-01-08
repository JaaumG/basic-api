package br.dev.joaoguilherme.basicapi.controller;

import br.dev.joaoguilherme.basicapi.dto.PessoaCreateDto;
import br.dev.joaoguilherme.basicapi.dto.PessoaResponseDto;
import br.dev.joaoguilherme.basicapi.dto.PessoaUpdateDto;
import br.dev.joaoguilherme.basicapi.entity.Pessoa;
import br.dev.joaoguilherme.basicapi.services.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/pessoa")
@Tag(name = "Pessoa", description = "Controller para operações relacionadas a pessoas")
public class PessoaController {

    private final PessoaService pessoaService;

    @GetMapping("/{id}")
    @Operation(summary = "Busca uma pessoa pelo id")
    public ResponseEntity<PessoaResponseDto> getPessoa(@Parameter(description = "Id da pessoa") @PathVariable Long id){
        log.info("Buscando pessoa com id {}", id);
        return pessoaService.getPessoa(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }

    @GetMapping("/")
    @Operation(summary = "Lista todas as pessoas")
    public ResponseEntity<Page<PessoaResponseDto>> listPessoas(@ParameterObject Pageable pageable){
        log.info("Listando pessoas");
        return ResponseEntity.ok(pessoaService.listPessoas(pageable));
    }

    @PostMapping("/")
    @Operation(summary = "Cria uma pessoa")
    public ResponseEntity<String> createPessoa(@RequestBody @Valid PessoaCreateDto pessoaCreateDto){
        log.info("Criando {}", pessoaCreateDto.getNome());
        Pessoa pessoaCriada = pessoaService.createPessoa(pessoaCreateDto);
        URI location = linkTo(methodOn(PessoaController.class).getPessoa(pessoaCriada.getId())).toUri();
        return ResponseEntity.created(location).body("Pessoa criada com sucesso");
    }


    @PutMapping("/{id}")
    @Operation(summary = "Atualiza uma pessoa")
    public ResponseEntity<Void> updatePessoa(@Parameter(description = "Id da pessoa") @PathVariable Long id, @RequestBody @Valid PessoaUpdateDto pessoaUpdateDto){
        log.info("Atualizando pessoa com id {}", id);
        pessoaService.updatePessoa(id, pessoaUpdateDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta uma pessoa")
    public ResponseEntity<Void> deletePessoa(@Parameter(description = "Id da pessoa") @PathVariable Long id){
        log.info("Deletando pessoa com id {}", id);
        pessoaService.deletePessoa(id);
        return ResponseEntity.noContent().build();
    }

}
