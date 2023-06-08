package br.com.bytewizards.api.entity.dto;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public record CadastroOngDto(
    @NotBlank
    @Pattern(regexp = "\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}")
    String cnpj,

    @NotBlank
    String nome,

    @NotBlank
    String telefone,

    @NotBlank
    @Email
    String email,

    @NotNull
    @Valid
    EnderecoDto endereco
) {
}
