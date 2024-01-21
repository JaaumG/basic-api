package br.dev.joaoguilherme.basicapi.controller;

import br.dev.joaoguilherme.basicapi.dto.request.PessoaCreateDto;
import br.dev.joaoguilherme.basicapi.dto.request.PessoaFilterDto;
import br.dev.joaoguilherme.basicapi.dto.request.PessoaUpdateDto;
import br.dev.joaoguilherme.basicapi.dto.response.PessoaResponseDto;
import br.dev.joaoguilherme.basicapi.services.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Validated
@RestController
@RequestMapping("api/v1/pessoa")
@Tag(name = "Pessoa", description = "Controller para operações relacionadas a pessoas")
public class PessoaController {

    private static final Logger log = LoggerFactory.getLogger(PessoaController.class);
    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca uma pessoa pelo id")
    public ResponseEntity<PessoaResponseDto> getPessoa(@Parameter(description = "Id da pessoa") @PathVariable Long id) {
        log.info("Buscando pessoa com id {}", id);
        return ResponseEntity.ok(pessoaService.getPessoa(id));
    }

    @GetMapping("/")
    @Operation(summary = "Lista todas as pessoas")
    public ResponseEntity<Page<PessoaResponseDto>> listPessoas(@ParameterObject Pageable pageable) {
        log.info("Listando pessoas");
        return ResponseEntity.ok(pessoaService.listPessoas(pageable));
    }

    @GetMapping("/find")
    @Operation(summary = "Busca uma pessoa pelos seus atributos")
    public ResponseEntity<List<PessoaResponseDto>> findPessoa(@ParameterObject PessoaFilterDto pessoaFilter) {
        log.info("Buscando pessoa com os atributos {}", pessoaFilter);
        return ResponseEntity.ok(pessoaService.findPessoas(pessoaFilter));
    }

    @PostMapping("/")
    @Operation(summary = "Cria uma pessoa")
    public ResponseEntity<String> createPessoa(@RequestBody @Valid PessoaCreateDto pessoaCreateDto) {
        log.info("Criando {}", pessoaCreateDto.getNome());
        PessoaResponseDto pessoaCriada = pessoaService.createPessoa(pessoaCreateDto);
        URI location = linkTo(methodOn(PessoaController.class).getPessoa(pessoaCriada.getId())).toUri();
        return ResponseEntity.created(location).body("Pessoa criada com sucesso");
    }


    @PutMapping("/{id}")
    @Operation(summary = "Atualiza uma pessoa")
    public ResponseEntity<Void> updatePessoa(@Parameter(description = "Id da pessoa") @PathVariable Long id, @RequestBody @Valid PessoaUpdateDto pessoaUpdateDto) {
        log.info("Atualizando pessoa com id {}", id);
        pessoaService.updatePessoa(id, pessoaUpdateDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta uma pessoa")
    public ResponseEntity<Void> deletePessoa(@Parameter(description = "Id da pessoa") @PathVariable Long id) {
        log.info("Deletando pessoa com id {}", id);
        pessoaService.deletePessoa(id);
        return ResponseEntity.noContent().build();
    }

}
