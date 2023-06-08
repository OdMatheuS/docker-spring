package br.com.bytewizards.api.entity.dto;

import br.com.bytewizards.api.entity.DoadorEntity;
import br.com.bytewizards.api.entity.enums.TipoPessoa;

public record ListarDoadorDto(Long id, TipoPessoa tipo, String documento, String email, String telefone) {

    public ListarDoadorDto(DoadorEntity doador) {
        this(doador.getId(), doador.getTipo(), doador.getDocumento(), doador.getEmail(), doador.getTelefone());
    }
}
