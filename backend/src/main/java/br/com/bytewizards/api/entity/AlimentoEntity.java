package br.com.bytewizards.api.entity;

import br.com.bytewizards.api.entity.dto.CadastroAlimentoDto;
import br.com.bytewizards.api.entity.enums.TipoAlimento;
import br.com.bytewizards.api.entity.enums.UnidadeMedida;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="TB_ALIMENTO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlimentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID_ALIMENTO")
    private Long id;

    @Column(name="NM_ALIMENTO")
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name="TIPO_ALIMENTO")
    private TipoAlimento tipo;

    @Column(name="QUANTIDADE_ALIMENTO")
    private Double quantidade;

    @Column(name="UNIDADE_MEDIDA")
    private UnidadeMedida unidadeMedida;

    @Column(name="VALIDADE_ALIMENTO")
    private LocalDate dataValidade;

    @Column(name="ATIVO")
    private Boolean ativo;

    @OneToMany(mappedBy = "alimento")
    private List<DoacaoEntity> doacoes;


    public AlimentoEntity(CadastroAlimentoDto dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.tipo = dados.tipo();
        this.unidadeMedida = dados.unidadeMedida();
        this.doacoes = new ArrayList<>();
    }


}
