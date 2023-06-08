package br.com.bytewizards.api.entity.dto;

import br.com.bytewizards.api.entity.enums.TipoAlimento;
import br.com.bytewizards.api.entity.enums.UnidadeMedida;

import javax.validation.constraints.NotBlank;

public record CadastroAlimentoDto(
        @NotBlank
        String nome,

        @NotBlank
        TipoAlimento tipo,

        @NotBlank
        UnidadeMedida unidadeMedida
) {
}
