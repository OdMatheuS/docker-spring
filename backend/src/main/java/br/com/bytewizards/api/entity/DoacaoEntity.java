package br.com.bytewizards.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="TB_DOACAO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID_DOACAO")
    private Long id;

    @Column(name="DATA_DOACAO")
    private LocalDate data = LocalDate.now();

    @OneToMany
    private List<DistribuicaoEntity> distribuicoes = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="ID_ALIMENTO")
    private AlimentoEntity alimento;

    @ManyToOne
    @JoinColumn(name="ID_DOADOR")
    private DoadorEntity doador;

    private Boolean ativo = true;


}
