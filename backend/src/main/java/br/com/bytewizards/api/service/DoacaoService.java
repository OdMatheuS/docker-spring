package br.com.bytewizards.api.service;

import br.com.bytewizards.api.entity.AlimentoEntity;
import br.com.bytewizards.api.entity.DoacaoEntity;
import br.com.bytewizards.api.entity.DoadorEntity;
import br.com.bytewizards.api.entity.dto.*;
import br.com.bytewizards.api.repository.AlimentoRepository;
import br.com.bytewizards.api.repository.DoacaoRepository;
import br.com.bytewizards.api.repository.DoadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoacaoService {

    @Autowired
    private DoacaoRepository doacaoRepository;

    @Autowired
    private AlimentoRepository alimentoRepository;

    @Autowired
    private DoadorRepository doadorRepository;

    public DoacaoEntity cadastrar(DoacaoEntity doacao, CadastroDoacaoDto dados) {
        AlimentoEntity alimento = alimentoRepository.getReferenceById(dados.IdAlimento());
        alimento.setDataValidade(dados.dataValidade());
        alimento.setQuantidade(alimento.getQuantidade() + dados.quantidade());
        doacao.setAlimento(alimento);

        DoadorEntity doador = doadorRepository.getReferenceById(dados.idDoador());
        doacao.setDoador(doador);

        doacaoRepository.save(doacao);
        return doacao;
    }


    public Page<ListarDoacaoDto> listarTodos(Pageable paginacao) {
        return doacaoRepository.findAllByAtivoTrue(paginacao).map(ListarDoacaoDto::new);
    }


    public DoacaoEntity buscarPorId(Long id) {
        return doacaoRepository.getReferenceById(id);
    }

    public void excluir(Long id) {
        DoacaoEntity doacao = doacaoRepository.getReferenceById(id);
        doacao.setAtivo(false);
    }

    public DoacaoEntity atualizar(AtualizarDoacaoDto dados) {
        Optional<DoacaoEntity> doacao = doacaoRepository.findById(dados.id());
        if (doacao.isPresent()) {
            DoacaoEntity atualizado = doacao.get();

            Optional<DoadorEntity> doador = doadorRepository.findById(dados.idDoador());
            if (dados.idDoador() != null && doador.isPresent()) {
                 atualizado.setDoador(doador.get());
            }
            Optional<AlimentoEntity> alimento = alimentoRepository.findById(dados.idAlimento());
            if (dados.idAlimento() != null && alimento.isPresent()) {
                AlimentoEntity alimentoCorreto = alimento.get();
                atualizado.setAlimento(alimentoCorreto);
                if (dados.quantidade() != null) {
                    alimentoCorreto.setQuantidade(dados.quantidade());
                }
            }
            return atualizado;
        }
        return null;
    }
}
