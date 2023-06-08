package br.com.bytewizards.api.entity.dto;

import br.com.bytewizards.api.entity.DoacaoEntity;

import java.time.LocalDate;

public record ListarDoacaoDto(Long id, Long IdDoador, String nomeDoador, Long idAlimento, String nomeAlimento, LocalDate dataDoacao) {

    public ListarDoacaoDto(DoacaoEntity dados) {
        this(dados.getId(), dados.getDoador().getId(), dados.getDoador().getNome(), dados.getAlimento().getId(), dados.getAlimento().getNome(), dados.getData());
    }
}
