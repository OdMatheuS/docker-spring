package br.com.bytewizards.api.entity;

import br.com.bytewizards.api.entity.dto.CadastroDistribuicaoDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="TB_DISTRIBUICAO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DistribuicaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID_DISTRIBUICAO")
    private Long id;

    @Embedded
    @Column(name="ENDERECO_DISTRIBUICAO")
    private EnderecoEntity endereco;

    @Column(name="DATA_DISTRIBUICAO")
    private LocalDate data;

    @Column(name="HORA_INICIO_DISTRIBUICAO")
    private String horaInicio;

    @Column(name="HORA_FIM_DISTRIBUICAO")
    private String horaFim;

    @Column(name="ATIVO")
    private Boolean ativo;

    @ManyToOne
    @JoinColumn(name="ID_ONG")
    private OngEntity ong;

    @ManyToOne
    @JoinColumn(name="ID_DOACAO")
    private DoacaoEntity doacao;

    public DistribuicaoEntity(CadastroDistribuicaoDto dados) {
        this.ativo = true;
        this.endereco = new EnderecoEntity(dados.endereco());
        this.data = dados.data();
        this.horaInicio = dados.horaInicio();
        this.horaFim = dados.horaFim();
    }

}
