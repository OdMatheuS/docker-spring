package br.com.bytewizards.api.entity.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public record EnderecoDto (
    @NotBlank
    String logradouro,

    @NotBlank
    String numero,

    @NotBlank
    String complemento,

    @NotBlank
    @Pattern(regexp = "\\d{8}")
    String cep,

    @NotBlank
    String uf,

    @NotBlank
    String cidade
) {
}
