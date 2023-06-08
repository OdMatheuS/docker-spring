package br.com.bytewizards.api.entity.dto;

import br.com.bytewizards.api.entity.AlimentoEntity;
import br.com.bytewizards.api.entity.enums.TipoAlimento;
import br.com.bytewizards.api.entity.enums.UnidadeMedida;

public record ListarAlimentoDto(Long id, String nome, TipoAlimento tipo, UnidadeMedida unidadeMedida) {

    public ListarAlimentoDto(AlimentoEntity alimento) {
        this(alimento.getId(), alimento.getNome(), alimento.getTipo(), alimento.getUnidadeMedida());
    }
}
