package br.com.bytewizards.api.entity;

import br.com.bytewizards.api.entity.dto.EnderecoDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoEntity {

    private String logradouro;

    private String numero;

    private String complemento;

    private String cep;

    private String uf;

    private String cidade;


    public EnderecoEntity(EnderecoDto dados) {
        this.logradouro = dados.logradouro();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
        this.cep = dados.uf();
        this.uf = dados.uf();
        this.cidade = dados.cidade();
    }
}
