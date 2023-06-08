package br.com.bytewizards.api.controller;

import br.com.bytewizards.api.entity.DoadorEntity;
import br.com.bytewizards.api.entity.OngEntity;
import br.com.bytewizards.api.entity.dto.*;
import br.com.bytewizards.api.service.DoadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/doador")
public class DoadorController {

    @Autowired
    private DoadorService service;


    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid CadastroDoadorDto dados, UriComponentsBuilder uriBuilder) {
        DoadorEntity doador = new DoadorEntity(dados);
        service.cadastrar(doador);

        var uri = uriBuilder.path("/api/v1/doador/{id}").buildAndExpand(doador.getId()).toUri();
        return ResponseEntity.created(uri).body(new InfoDoadorDto(doador));
    }

    @GetMapping
    public ResponseEntity<Page<ListarDoadorDto>> listar(Pageable paginacao) {
        return ResponseEntity.ok(service.listarTodos(paginacao));
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id) {
        DoadorEntity doador = service.buscarPorId(id);
        return ResponseEntity.ok(new InfoDoadorDto(doador));
    }



    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid AtualizarDoadorDto dados) {
        DoadorEntity doador = service.atualizar(dados);
        return ResponseEntity.ok(new InfoDoadorDto(doador));
    }

}
