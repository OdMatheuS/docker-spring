package br.com.bytewizards.api.entity.dto;

import br.com.bytewizards.api.entity.OngEntity;

public record ListarOngDto(Long id, String cnpj, String nome, String telefone, String email) {

    public ListarOngDto(OngEntity ong) {
        this(ong.getId(), ong.getCnpj(), ong.getNome(), ong.getTelefone(), ong.getEmail());
    }
}
