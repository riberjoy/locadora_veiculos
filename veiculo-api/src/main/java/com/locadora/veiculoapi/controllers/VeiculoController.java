package com.locadora.veiculoapi.controllers;

import com.locadora.veiculoapi.integrations.TipoVeiculoApiGateway;
import com.locadora.veiculoapi.models.PageResponse;
import com.locadora.veiculoapi.models.Veiculo;
import com.locadora.veiculoapi.repositorys.VeiculoRepository;
import io.swagger.annotations.ApiOperation;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Validated
@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private TipoVeiculoApiGateway tipoVeiculoApiGateway;

    @PostMapping
    @ApiOperation("Cadastra um novo veiculo")
    public void novoVeiculo(@Valid @RequestBody Veiculo veiculo){

        this.tipoVeiculoApiGateway.send(veiculo.getTipoVeiculoCode());

        List<Veiculo> veiculoBuca = this.veiculoRepository
                .findByMarcaAndModeloAndCorAndPlacaAndAnoAndTipoVeiculoCode(
                    veiculo.getMarca(), veiculo.getModelo(),veiculo.getCor(),
                    veiculo.getPlaca(), veiculo.getAno(),veiculo.getTipoVeiculoCode());

        if(!veiculoBuca.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Veículo já existente!");

        this.veiculoRepository.save(veiculo);
    }

    @PutMapping
    @ApiOperation("Altera um existente veiculo")
    public void alterarVeiculo(@Valid @RequestBody Veiculo veiculo){
        Veiculo veiculoOld = this.veiculoRepository.findById(veiculo.getId()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Veiculo não encontrado!") );

        if(!veiculoOld.getTipoVeiculoCode().equals(veiculo.getTipoVeiculoCode()))
            this.tipoVeiculoApiGateway.send(veiculo.getTipoVeiculoCode());

        this.veiculoRepository.save(veiculo);
    }

    @GetMapping
    @ApiOperation("Lista todos os Veiculos")
    public PageResponse listarTodosVeiculos(Integer page, Integer size) {
        Pageable pageable = Objects.nonNull(page) && Objects.nonNull(size) ? PageRequest.of(page, size) : Pageable.unpaged();
        Page<Veiculo> veiculos =  this.veiculoRepository.findAll(pageable);
        return new PageResponse(veiculos);
    }

    @GetMapping("/{idVeiculo}")
    @ApiOperation("Lista um Veiculo pelo seu id")
    public Veiculo listarVeiculo(@PathParam("idVeiculo") String idVeiculo) {
        Veiculo veiculo = this.veiculoRepository.findById(idVeiculo).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Identificador do veiculo não encontrado!") );
        return veiculo;
    }
}
