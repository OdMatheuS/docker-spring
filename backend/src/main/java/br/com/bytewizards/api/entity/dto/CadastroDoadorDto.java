package br.com.bytewizards.api.entity.dto;

import br.com.bytewizards.api.entity.enums.TipoPessoa;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public record CadastroDoadorDto(
        @NotBlank
        String nome,
        @NotBlank
        TipoPessoa tipo,
        @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}|\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}")
        @NotBlank
        String documento,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String telefone
) {
}
