package com.locadora.tipoveiculoapi.controllers;

import com.locadora.tipoveiculoapi.models.TipoVeiculo;
import com.locadora.tipoveiculoapi.repositorys.TipoVeiculoRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.Optional;

@Validated
@RestController
@RequestMapping("/tipoVeiculo")
public class TipoVeiculoController {
    @Autowired
    private TipoVeiculoRepository tipoVeiculoRepository;

    @PostMapping
    @ApiOperation("Cadastra um novo tipo de veiculo")
    public void novoTipoVeiculo(@Valid @RequestBody TipoVeiculo veiculo){
        this.tipoVeiculoRepository.save(veiculo);
    }

    @PutMapping
    @ApiOperation("Altera um tipo de veiculo existente")
    public void alterarTipoVeiculo(@Valid @RequestBody TipoVeiculo veiculo){
        this.tipoVeiculoRepository.save(veiculo);
    }

    @GetMapping
    @ApiOperation("Lista todos os tipos de veiculos")
    public Page<TipoVeiculo> listarTodosTiposVeiculos(Integer page, Integer size) {
        Page<TipoVeiculo> veiculos =  this.tipoVeiculoRepository.findAll(PageRequest.of(page, size));
        return veiculos;
    }

    @GetMapping("/{idTipoVeiculo}")
    @ApiOperation("Lista um tipo de veiculo pelo seu id")
    public Optional<TipoVeiculo> listarTipoVeiculo(@PathParam("idTipoVeiculo") String idTipoVeiculo) {
        return this.tipoVeiculoRepository.findById(idTipoVeiculo);
    }
}
