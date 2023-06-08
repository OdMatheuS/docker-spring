package br.com.bytewizards.api.controller;

import br.com.bytewizards.api.entity.AlimentoEntity;
import br.com.bytewizards.api.entity.dto.*;
import br.com.bytewizards.api.service.AlimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/alimentos")
public class AlimentoController {

    @Autowired
    private AlimentoService service;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid CadastroAlimentoDto dados, UriComponentsBuilder uriBuilder) {
        AlimentoEntity alimento = new AlimentoEntity(dados);
        service.cadastrar(alimento);

        var uri = uriBuilder.path("/api/v1/alimento/{id}").buildAndExpand(alimento.getId()).toUri();
        return ResponseEntity.created(uri).body(new InfoAlimentoDto(alimento));
    }


    @GetMapping
    public ResponseEntity<Page<ListarAlimentoDto>> listar(Pageable paginacao) {
        return ResponseEntity.ok(service.listarTodos(paginacao));
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id) {
        AlimentoEntity alimento = service.buscarPorId(id);
        return ResponseEntity.ok(new InfoAlimentoDto(alimento));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid AtualizarAlimentoDto dados) {
        AlimentoEntity alimento = service.atualizar(dados);
        return ResponseEntity.ok(new InfoAlimentoDto(alimento));
    }
}
