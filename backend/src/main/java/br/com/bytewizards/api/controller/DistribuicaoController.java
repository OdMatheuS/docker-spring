package br.com.bytewizards.api.controller;

import br.com.bytewizards.api.entity.DistribuicaoEntity;
import br.com.bytewizards.api.entity.dto.*;
import br.com.bytewizards.api.service.DistribuicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/distribuicoes")
public class DistribuicaoController {

    @Autowired
    private DistribuicaoService service;


    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid CadastroDistribuicaoDto dados, UriComponentsBuilder uriBuilder) {
        DistribuicaoEntity distribuicao = new DistribuicaoEntity(dados);
        service.cadastrar(distribuicao, dados);

        var uri = uriBuilder.path("api/v1/distribuicoes/{id}").buildAndExpand(distribuicao.getId()).toUri();
        return ResponseEntity.created(uri).body(new InfoDistribuicaoDto(distribuicao));
    }

    @GetMapping
    public ResponseEntity<Page<ListarDistribuicaoDto>> listar(Pageable paginacao) {
        return ResponseEntity.ok(service.listarTodos(paginacao));
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id) {
        DistribuicaoEntity distribuicao = service.buscarPorId(id);
        return ResponseEntity.ok(new InfoDistribuicaoDto(distribuicao));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid AtualizarDistribuicaoDto dados) {
        DistribuicaoEntity distribuicao = service.atualizar(dados);
        return ResponseEntity.ok(new InfoDistribuicaoDto(distribuicao));
    }

}
