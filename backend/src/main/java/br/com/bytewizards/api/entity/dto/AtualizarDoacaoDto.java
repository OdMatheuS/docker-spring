package br.com.bytewizards.api.entity.dto;

import javax.validation.constraints.NotBlank;

public record AtualizarDoacaoDto(
        @NotBlank
        Long id,
        Long idDoador,
        Long idAlimento,
        Double quantidade
) {
}
