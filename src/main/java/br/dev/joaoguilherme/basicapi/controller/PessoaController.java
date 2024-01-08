package br.dev.joaoguilherme.basicapi.controller;

import br.dev.joaoguilherme.basicapi.dto.PessoaCreateDto;
import br.dev.joaoguilherme.basicapi.dto.PessoaResponseDto;
import br.dev.joaoguilherme.basicapi.entity.PessoaUpdateDto;
import br.dev.joaoguilherme.basicapi.services.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
        return pessoaService.getPessoa(id);
    }

    @GetMapping("/")
    @Operation(summary = "Lista todas as pessoas")
    public ResponseEntity<Page<PessoaResponseDto>> listPessoas(@ParameterObject Pageable pageable){
        return pessoaService.listPessoas(pageable);
    }

    @PostMapping("/")
    @Operation(summary = "Cria uma pessoa")
    public ResponseEntity<String> createPessoa(@RequestBody @Valid PessoaCreateDto pessoaCreateDto){
        return pessoaService.createPessoa(pessoaCreateDto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza uma pessoa")
    public ResponseEntity<String> updatePessoa(@Parameter(description = "Id da pessoa") @PathVariable Long id, @RequestBody @Valid PessoaUpdateDto pessoaUpdateDto){
        return pessoaService.updatePessoa(id, pessoaUpdateDto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta uma pessoa")
    public ResponseEntity<String> deletePessoa(@Parameter(description = "Id da pessoa") @PathVariable Long id){
        return pessoaService.deletePessoa(id);
    }

}
