package br.com.bytewizards.api.entity.dto;

import br.com.bytewizards.api.entity.DistribuicaoEntity;
import br.com.bytewizards.api.entity.EnderecoEntity;
import br.com.bytewizards.api.entity.enums.TipoAlimento;
import br.com.bytewizards.api.entity.enums.UnidadeMedida;

import java.time.LocalDate;

public record InfoDistribuicaoDto(Long id, EnderecoEntity endereco, LocalDate data, String horaInicio, String horaFim, Long idOng, String nomeOng, Long idDoacao, String nomeAlimento, UnidadeMedida unidadeMedida, TipoAlimento tipo) {

    public InfoDistribuicaoDto(DistribuicaoEntity distribuicao) {
        this(distribuicao.getId(),
                distribuicao.getEndereco(),
                distribuicao.getData(),
                distribuicao.getHoraInicio(),
                distribuicao.getHoraFim(),
                distribuicao.getOng().getId(),
                distribuicao.getOng().getNome(),
                distribuicao.getDoacao().getId(),
                distribuicao.getDoacao().getAlimento().getNome(),
                distribuicao.getDoacao().getAlimento().getUnidadeMedida(),
                distribuicao.getDoacao().getAlimento().getTipo());
    }
}
