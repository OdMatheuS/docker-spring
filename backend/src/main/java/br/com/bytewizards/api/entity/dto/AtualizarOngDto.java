package br.com.bytewizards.api.entity.dto;

import javax.validation.constraints.NotNull;

public record AtualizarOngDto(
        @NotNull
        Long id,
        String telefone,
        String email
) {
}
