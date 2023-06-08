package br.com.bytewizards.api.entity.dto;


import javax.validation.constraints.NotNull;

public record AtualizarDoadorDto(
        @NotNull
        Long id,
        String nome,
        String email,
        String telefone
) {
}
