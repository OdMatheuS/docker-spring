package br.com.bytewizards.api.entity.dto;

import br.com.bytewizards.api.entity.enums.TipoAlimento;
import br.com.bytewizards.api.entity.enums.UnidadeMedida;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public record AtualizarAlimentoDto(
        @NotBlank
        Long id,
        String nome,
        TipoAlimento tipo,
        UnidadeMedida unidadeMedida,
        LocalDate dataValidade
) {
}
