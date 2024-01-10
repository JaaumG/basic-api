package br.dev.joaoguilherme.basicapi.controller;

import br.dev.joaoguilherme.basicapi.dto.request.PessoaFilterDto;
import br.dev.joaoguilherme.basicapi.dto.request.PessoaCreateDto;
import br.dev.joaoguilherme.basicapi.dto.request.PessoaUpdateDto;
import br.dev.joaoguilherme.basicapi.dto.response.PessoaResponseDto;
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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;


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
    public PessoaResponseDto getPessoa(@Parameter(description = "Id da pessoa") @PathVariable Long id) {
        log.info("Buscando pessoa com id {}", id);
        return pessoaService.getPessoa(id);
    }

    @GetMapping("/")
    @Operation(summary = "Lista todas as pessoas")
    public Page<PessoaResponseDto> listPessoas(@ParameterObject Pageable pageable) {
        log.info("Listando pessoas");
        return pessoaService.listPessoas(pageable);
    }

    @GetMapping("/find")
    @Operation(summary = "Busca uma pessoa pelos seus atributos")
    public List<PessoaResponseDto> findPessoa(@ParameterObject PessoaFilterDto pessoaFilter){
        log.info("Buscando pessoa com os atributos {}", pessoaFilter);
        return pessoaService.findPessoas(pessoaFilter);
    }

    @PostMapping("/")
    @ResponseStatus(CREATED)
    @Operation(summary = "Cria uma pessoa")
    public PessoaResponseDto createPessoa(@RequestBody @Valid PessoaCreateDto pessoaCreateDto) {
        log.info("Criando {}", pessoaCreateDto.getNome());
        return pessoaService.createPessoa(pessoaCreateDto);
    }


    @PutMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    @Operation(summary = "Atualiza uma pessoa")
    public void updatePessoa(@Parameter(description = "Id da pessoa") @PathVariable Long id, @RequestBody @Valid PessoaUpdateDto pessoaUpdateDto) {
        log.info("Atualizando pessoa com id {}", id);
        pessoaService.updatePessoa(id, pessoaUpdateDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    @Operation(summary = "Deleta uma pessoa")
    public void deletePessoa(@Parameter(description = "Id da pessoa") @PathVariable Long id) {
        log.info("Deletando pessoa com id {}", id);
        pessoaService.deletePessoa(id);
    }

}
