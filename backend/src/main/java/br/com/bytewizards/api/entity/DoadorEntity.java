package br.com.bytewizards.api.entity;

import br.com.bytewizards.api.entity.dto.CadastroDoadorDto;
import br.com.bytewizards.api.entity.enums.TipoPessoa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="TB_DOADOR")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoadorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID_DOADOR")
    private Long id;

    @Column(name="NM_DOADOR")
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name="TIPO_PESSOA")
    private TipoPessoa tipo;

    @Column(name="DOCUMENTO_DOADOR")
    private String documento;

    @Column(name="EMAIL_DOADOR")
    private String email;

    @Column(name="TELEFONE_DOADOR")
    private String telefone;

    @Column(name="ATIVO")
    private Boolean ativo;

    @OneToMany(mappedBy = "doador")
    private List<DoacaoEntity> doacoes;


    public DoadorEntity(CadastroDoadorDto dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.tipo = dados.tipo();
        this.documento = dados.documento();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.doacoes = new ArrayList<>();
    }
}
