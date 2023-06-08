package br.com.bytewizards.api.service;

import java.util.Optional;

import br.com.bytewizards.api.entity.dto.AtualizarOngDto;
import br.com.bytewizards.api.entity.dto.ListarOngDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.bytewizards.api.entity.OngEntity;
import br.com.bytewizards.api.repository.OngRepository;

@Service
public class OngService {

	@Autowired
	OngRepository repository;

	public Page<ListarOngDto> listarTodos(Pageable paginacao) {
		return repository.findAllByAtivoTrue(paginacao).map(ListarOngDto::new);
	}

	public OngEntity buscarPorId(Long id) {
		return repository.getReferenceById(id);
	}

	public OngEntity cadastrar(OngEntity ong) {
		return repository.save(ong);
	}

	public OngEntity atualizar(AtualizarOngDto dados) {
		Optional<OngEntity> ong = repository.findById(dados.id());
		if (ong.isPresent()) {
			OngEntity atualizado = ong.get();
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



	public void deletar(Long id) {
		OngEntity ong = repository.getReferenceById(id);
		ong.setAtivo(false);
	}

}
