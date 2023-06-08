package br.com.bytewizards.api.entity.dto;

import br.com.bytewizards.api.entity.AlimentoEntity;
import br.com.bytewizards.api.entity.enums.TipoAlimento;
import br.com.bytewizards.api.entity.enums.UnidadeMedida;

import java.time.LocalDate;

public record InfoAlimentoDto(Long id, String nome, TipoAlimento tipo, Double quantidade, UnidadeMedida unidadeMedida, LocalDate dataValidade) {

    public InfoAlimentoDto(AlimentoEntity alimento) {
        this(alimento.getId(), alimento.getNome(), alimento.getTipo(), alimento.getQuantidade(), alimento.getUnidadeMedida(), alimento.getDataValidade());
    }
}
