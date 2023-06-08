package br.com.bytewizards.api.service;

import br.com.bytewizards.api.entity.AlimentoEntity;
import br.com.bytewizards.api.entity.DoadorEntity;
import br.com.bytewizards.api.entity.dto.AtualizarAlimentoDto;
import br.com.bytewizards.api.entity.dto.ListarAlimentoDto;
import br.com.bytewizards.api.entity.dto.ListarDoadorDto;
import br.com.bytewizards.api.repository.AlimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlimentoService {

    @Autowired
    private AlimentoRepository repository;


    public void cadastrar(AlimentoEntity alimento) {
        repository.save(alimento);
    }

    public Page<ListarAlimentoDto> listarTodos(Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(ListarAlimentoDto::new);
    }

    public void excluir(Long id) {
        AlimentoEntity alimento = repository.getReferenceById(id);
        alimento.setAtivo(false);
    }

    public AlimentoEntity atualizar(AtualizarAlimentoDto dados) {
        Optional<AlimentoEntity> alimento = repository.findById(dados.id());
        if (alimento.isPresent()) {
            AlimentoEntity atualizado = alimento.get();
            if (dados.nome() != null) {
                atualizado.setNome(dados.nome());
            }
            if (dados.unidadeMedida() != null) {
                atualizado.setUnidadeMedida(dados.unidadeMedida());
            }
            if (dados.tipo() != null) {
                atualizado.setTipo(dados.tipo());
            }
            if (dados.dataValidade() != null) {
                atualizado.setDataValidade(dados.dataValidade());
            }
            return atualizado;
        }
        return null;
    }


    public AlimentoEntity buscarPorId(Long id) {
        return repository.getReferenceById(id);
    }
}
