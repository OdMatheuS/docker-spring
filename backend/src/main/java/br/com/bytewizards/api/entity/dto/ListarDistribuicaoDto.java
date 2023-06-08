package br.com.bytewizards.api.entity.dto;

import br.com.bytewizards.api.entity.DistribuicaoEntity;
import br.com.bytewizards.api.entity.EnderecoEntity;

import java.time.LocalDate;

public record ListarDistribuicaoDto(Long id, EnderecoEntity endereco, LocalDate data, String horaInicio, String horaFim) {

    public ListarDistribuicaoDto(DistribuicaoEntity distribuicao) {
        this(distribuicao.getId(), distribuicao.getEndereco(), distribuicao.getData(), distribuicao.getHoraInicio(), distribuicao.getHoraFim());
    }
}
