package com.locadora.tipoveiculoapi.controllers;

import com.locadora.tipoveiculoapi.models.PageResponse;
import com.locadora.tipoveiculoapi.models.TipoVeiculo;
import com.locadora.tipoveiculoapi.repositorys.TipoVeiculoRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

import java.util.Objects;

@Validated
@RestController
@RequestMapping("/tipoVeiculo")
public class TipoVeiculoController {
    @Autowired
    private TipoVeiculoRepository tipoVeiculoRepository;

    @PostMapping
    @ApiOperation("Cadastra um novo tipo de veiculo")
    public void novoTipoVeiculo(@Valid @RequestBody TipoVeiculo veiculo){
        TipoVeiculo tipoVeiculo = this.tipoVeiculoRepository.findByNome(veiculo.getNome()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tipo de Veículo já existente!"));

        this.tipoVeiculoRepository.save(veiculo);
    }

    @PutMapping
    @ApiOperation("Altera um tipo de veiculo existente")
    public void alterarTipoVeiculo(@Valid @RequestBody TipoVeiculo veiculo){
        TipoVeiculo tipoVeiculo = this.tipoVeiculoRepository.findById(veiculo.getId()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo de Veículo não encontrado!"));

        this.tipoVeiculoRepository.save(veiculo);
    }

    @GetMapping
    @ApiOperation("Lista todos os tipos de veiculos")
    public PageResponse listarTodosTiposVeiculos(Integer page, Integer size) {
        Pageable pageable = Objects.nonNull(page) && Objects.nonNull(size) ? PageRequest.of(page, size) : Pageable.unpaged();
        Page<TipoVeiculo> veiculos =  this.tipoVeiculoRepository.findAll(pageable);
        return new PageResponse(veiculos);
    }

    @GetMapping("/{tipoVeiculoCode}")
    @ApiOperation("Lista um tipo de veiculo pelo seu id")
    public TipoVeiculo listarTipoVeiculo(@PathVariable("tipoVeiculoCode") String id) {
        TipoVeiculo tipoVeiculo = this.tipoVeiculoRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Identificador do tipo de veiculo não encontrado!") );

        return tipoVeiculo;
    }
}
