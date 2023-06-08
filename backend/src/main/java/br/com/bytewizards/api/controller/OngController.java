package br.com.bytewizards.api.controller;


import br.com.bytewizards.api.entity.dto.AtualizarOngDto;
import br.com.bytewizards.api.entity.dto.CadastroOngDto;
import br.com.bytewizards.api.entity.dto.InfoOngDto;
import br.com.bytewizards.api.entity.dto.ListarOngDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bytewizards.api.entity.OngEntity;
import br.com.bytewizards.api.service.OngService;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/ong")
@CrossOrigin(origins = "*")
public class OngController {

	@Autowired
	OngService service;

	@GetMapping("/listar")
	public ResponseEntity<Page<ListarOngDto>> listar(Pageable paginacao) {
		return ResponseEntity.ok(service.listarTodos(paginacao));
	}

	@GetMapping("/{id}")
	public ResponseEntity buscarPorId(@PathVariable Long id) {
		OngEntity ong = service.buscarPorId(id);
		return ResponseEntity.ok(new InfoOngDto(ong));
	}

	@PostMapping("/cadastrar")
	public ResponseEntity cadastrar(@RequestBody CadastroOngDto dados, UriComponentsBuilder uriBuilder) {
		OngEntity ong = new OngEntity(dados);
		service.cadastrar(ong);

		var uri = uriBuilder.path("/api/v1/ong/{id}").buildAndExpand(ong.getId()).toUri();
		return ResponseEntity.created(uri).body(new InfoOngDto(ong));

	}

	@PutMapping("/{id}")
	public ResponseEntity atualizar(@RequestBody @Valid AtualizarOngDto dados) {
		OngEntity ong = service.atualizar(dados);
		return ResponseEntity.ok(new InfoOngDto(ong));

	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity excluir(@PathVariable Long id) {
		service.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
