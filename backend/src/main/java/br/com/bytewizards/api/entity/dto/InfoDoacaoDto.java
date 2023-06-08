package br.com.bytewizards.api.entity.dto;


import br.com.bytewizards.api.entity.DoacaoEntity;
import br.com.bytewizards.api.entity.enums.TipoAlimento;

import java.time.LocalDate;

public record InfoDoacaoDto(Long id, LocalDate dataDoacao, Long idAlimento, String nomeAlimento, LocalDate dataValidade, Double quantidadeAlimento, TipoAlimento tipo, Long idDoador, String documento, String nomeDoador) {

    public InfoDoacaoDto(DoacaoEntity doacao) {
        this(doacao.getId()
                , doacao.getData()
                , doacao.getAlimento().getId()
                , doacao.getAlimento().getNome()
                , doacao.getAlimento().getDataValidade()
                , doacao.getAlimento().getQuantidade()
                , doacao.getAlimento().getTipo()
                , doacao.getDoador().getId()
                , doacao.getDoador().getDocumento()
                , doacao.getDoador().getNome());
    }
}
