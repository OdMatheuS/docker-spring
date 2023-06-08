package br.com.bytewizards.api.entity.dto;

import br.com.bytewizards.api.entity.DoadorEntity;
import br.com.bytewizards.api.entity.enums.TipoPessoa;

public record InfoDoadorDto(Long id, String nome, TipoPessoa tipo, String documento, String email, String telefone) {

    public InfoDoadorDto(DoadorEntity doador) {
        this(doador.getId(), doador.getNome(), doador.getTipo(), doador.getDocumento(), doador.getEmail(), doador.getTelefone());
    }
}
