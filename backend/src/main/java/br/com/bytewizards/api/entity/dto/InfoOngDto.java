package br.com.bytewizards.api.entity.dto;

import br.com.bytewizards.api.entity.EnderecoEntity;
import br.com.bytewizards.api.entity.OngEntity;

public record InfoOngDto(Long id, String cnpj, String nome, String telefone, String email, EnderecoEntity endereco) {

    public InfoOngDto(OngEntity ong) {
        this(ong.getId(), ong.getCnpj(), ong.getNome(), ong.getTelefone(), ong.getEmail(), ong.getEndereco());
    }

}
