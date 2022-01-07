package com.locadora.veiculoapi.controllers;

import com.locadora.veiculoapi.models.Veiculo;
import com.locadora.veiculoapi.repositorys.VeiculoRepository;
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
@RequestMapping("/veiculo")
public class VeiculoController {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @PostMapping
    @ApiOperation("Cadastra um novo veiculo")
    public void novoVeiculo(@Valid @RequestBody Veiculo veiculo){
        this.veiculoRepository.save(veiculo);
    }

    @PutMapping
    @ApiOperation("Altera um existente veiculo")
    public void alterarVeiculo(@Valid @RequestBody Veiculo veiculo){
        this.veiculoRepository.save(veiculo);
    }

    @GetMapping
    @ApiOperation("Lista todos os Veiculos")
    public Page<Veiculo> listarTodosVeiculos(Integer page, Integer size) {
        Page<Veiculo> veiculos =  this.veiculoRepository.findAll(PageRequest.of(page, size));
        return veiculos;
    }

    @GetMapping("/{idVeiculo}")
    @ApiOperation("Lista um Veiculo pelo seu id")
    public Optional<Veiculo> listarVeiculo(@PathParam("idVeiculo") String idVeiculo) {
        return this.veiculoRepository.findById(idVeiculo);
    }
}
