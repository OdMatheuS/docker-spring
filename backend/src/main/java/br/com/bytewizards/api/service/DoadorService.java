package br.com.bytewizards.api.service;

import br.com.bytewizards.api.entity.DoadorEntity;
import br.com.bytewizards.api.entity.dto.AtualizarDoadorDto;
import br.com.bytewizards.api.entity.dto.ListarDoadorDto;
import br.com.bytewizards.api.repository.DoadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoadorService {

    @Autowired
    private DoadorRepository repository;


    public void cadastrar(DoadorEntity doador) {
        repository.save(doador);
    }



    public Page<ListarDoadorDto> listarTodos(Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(ListarDoadorDto::new);
    }

    public void excluir(Long id) {
        DoadorEntity doador = repository.getReferenceById(id);
        doador.setAtivo(false);
    }

    public DoadorEntity atualizar(AtualizarDoadorDto dados) {
        Optional<DoadorEntity> doador = repository.findById(dados.id());
        if (doador.isPresent()) {
            DoadorEntity atualizado = doador.get();
            if (dados.nome() != null) {
                atualizado.setNome(dados.nome());
            }
            if (dados.email() != null) {
                atualizado.setEmail(dados.email());
            }
            if (dados.telefone() != null) {
                atualizado.setTelefone(dados.telefone());
            }
            return atualizado;
        }
        return null;
    }

    public DoadorEntity buscarPorId(Long id) {
        return repository.getReferenceById(id);
    }
}
