package br.com.bytewizards.api.service;

import br.com.bytewizards.api.entity.AlimentoEntity;
import br.com.bytewizards.api.entity.DistribuicaoEntity;
import br.com.bytewizards.api.entity.DoacaoEntity;
import br.com.bytewizards.api.entity.OngEntity;
import br.com.bytewizards.api.entity.dto.AtualizarDistribuicaoDto;
import br.com.bytewizards.api.entity.dto.CadastroDistribuicaoDto;
import br.com.bytewizards.api.entity.dto.ListarDistribuicaoDto;
import br.com.bytewizards.api.entity.dto.ListarDoacaoDto;
import br.com.bytewizards.api.repository.DistribuicaoRepository;
import br.com.bytewizards.api.repository.DoacaoRepository;
import br.com.bytewizards.api.repository.OngRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DistribuicaoService {

    @Autowired
    private DistribuicaoRepository distribuicaoRepository;

    @Autowired
    private DoacaoRepository doacaoRepository;
    @Autowired
    private OngRepository ongRepository;


    public void cadastrar(DistribuicaoEntity distribuicao, CadastroDistribuicaoDto dados) {
        OngEntity ong = ongRepository.getReferenceById(dados.idOng());
        DoacaoEntity doacao = doacaoRepository.getReferenceById(dados.idDoacao());
        AlimentoEntity alimento = doacao.getAlimento();
        alimento.setQuantidade(alimento.getQuantidade() - dados.quantidade());

        distribuicao.setOng(ong);
        distribuicao.setDoacao(doacao);

        distribuicaoRepository.save(distribuicao);
    }


    public Page<ListarDistribuicaoDto> listarTodos(Pageable paginacao) {
        return distribuicaoRepository.findAllByAtivoTrue(paginacao).map(ListarDistribuicaoDto::new);
    }

    public DistribuicaoEntity buscarPorId(Long id) {
        return distribuicaoRepository.getReferenceById(id);
    }

    public void excluir(Long id) {
        DistribuicaoEntity distribuicao = distribuicaoRepository.getReferenceById(id);
        distribuicao.setAtivo(false);
    }

    public DistribuicaoEntity atualizar(AtualizarDistribuicaoDto dados) {
        Optional<DistribuicaoEntity> distribuicao = distribuicaoRepository.findById(dados.id());
        if (distribuicao.isPresent()) {
            DistribuicaoEntity atualizado = distribuicao.get();
            if (dados.data() != null) {
                atualizado.setData(dados.data());
            }
            if (dados.horaInicio() != null) {
                atualizado.setHoraInicio(dados.horaInicio());
            }
            if (dados.horaFim() != null) {
                atualizado.setHoraFim(dados.horaFim());
            }
            if (dados.endereco().cep() != null) {
                atualizado.getEndereco().setCep(dados.endereco().cep());
            }
            if (dados.endereco().uf() != null) {
                atualizado.getEndereco().setUf(dados.endereco().uf());
            }
            if (dados.endereco().cidade() != null) {
                atualizado.getEndereco().setCidade(dados.endereco().cidade());
            }
            if (dados.endereco().numero() != null) {
                atualizado.getEndereco().setNumero(dados.endereco().numero());
            }
            if (dados.endereco().logradouro() != null) {
                atualizado.getEndereco().setLogradouro(dados.endereco().logradouro());
            }
            if (dados.endereco().complemento() != null) {
                atualizado.getEndereco().setComplemento(dados.endereco().complemento());
            }
            return atualizado;
        }
        return null;
    }
}
