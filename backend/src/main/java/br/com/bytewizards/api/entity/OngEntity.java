package br.com.bytewizards.api.entity;

import br.com.bytewizards.api.entity.dto.CadastroOngDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="TB_ONG")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OngEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID_ONG")
    private Long id;

    @Column(name="CNPJ_ONG")
    private String cnpj;

    @Column(name="NM_ONG")
    private String nome;

    @Embedded
    @Column(name="ENDERECO_ONG")
    private EnderecoEntity endereco;

    @Column(name="TELEFONE_ONG")
    private String telefone;

    @Column(name="EMAIL_ONG")
    private String email;

    @Column(name="ATIVO")
    private Boolean ativo;

    @OneToMany(mappedBy = "ong")
    private List<DistribuicaoEntity> distribuicoes;


    public OngEntity(CadastroOngDto dados) {
        this.ativo = true;
        this.cnpj = dados.cnpj();
        this.nome = dados.nome();
        this.telefone = dados.telefone();
        this.email = dados.email();
        this.endereco = new EnderecoEntity(dados.endereco());
        this.distribuicoes = new ArrayList<>();
    }
}
