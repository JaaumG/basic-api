package br.dev.joaoguilherme.basicapi.mappings;

import br.dev.joaoguilherme.basicapi.dto.PessoaResponseDto;
import br.dev.joaoguilherme.basicapi.entity.Pessoa;
import br.dev.joaoguilherme.basicapi.dto.PessoaCreateDto;
import br.dev.joaoguilherme.basicapi.entity.PessoaUpdateDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PessoaMapper {
    Pessoa toEntity(PessoaCreateDto pessoaCreateDto);

    PessoaResponseDto toDto(Pessoa pessoa);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Pessoa partialUpdate(PessoaUpdateDto pessoaUpdateDto, @MappingTarget Pessoa pessoa);
}