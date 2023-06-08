package br.com.bytewizards.api.controller;

import br.com.bytewizards.api.entity.DoacaoEntity;
import br.com.bytewizards.api.entity.dto.*;
import br.com.bytewizards.api.service.DoacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/doacoes")
public class DoacaoController {

    @Autowired
    private DoacaoService service;



    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid CadastroDoacaoDto dados, UriComponentsBuilder uriBuilder) {
        DoacaoEntity doacao = new DoacaoEntity();
        DoacaoEntity cadastrada = service.cadastrar(doacao, dados);

        var uri = uriBuilder.path("/api/v1/alimento/{id}").buildAndExpand(doacao.getId()).toUri();
        return ResponseEntity.created(uri).body(new InfoDoacaoDto(cadastrada));
    }


    @GetMapping
    public ResponseEntity<Page<ListarDoacaoDto>> listar(Pageable paginacao) {
        return ResponseEntity.ok(service.listarTodos(paginacao));
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id) {
        DoacaoEntity doacao = service.buscarPorId(id);
        return ResponseEntity.ok(new InfoDoacaoDto(doacao));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid AtualizarDoacaoDto dados) {
        DoacaoEntity doacao = service.atualizar(dados);
        return ResponseEntity.ok(new InfoDoacaoDto(doacao));
    }

}
