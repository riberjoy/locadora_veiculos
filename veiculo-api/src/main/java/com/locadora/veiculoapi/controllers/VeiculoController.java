package com.locadora.veiculoapi.controllers;

import com.locadora.veiculoapi.integrations.TipoVeiculoApiGateway;
import com.locadora.veiculoapi.models.PageResponse;
import com.locadora.veiculoapi.models.TipoVeiculo;
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

        TipoVeiculo tipoVeiculo = this.tipoVeiculoApiGateway.send(veiculo.getTipoVeiculoCode());

        if( Boolean.FALSE.equals(tipoVeiculo.getEnabled()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tipo de veículo indisponível!");

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
    public PageResponse listarTodosVeiculos(Integer page, Integer size,
                                            @RequestParam(value = "enabled", required = false) Boolean enabled) {

        Pageable pageable = Objects.nonNull(page) && Objects.nonNull(size) ? PageRequest.of(page, size) : Pageable.unpaged();
        Page<Veiculo> veiculos;

        if(Objects.isNull(enabled)){
            veiculos = this.veiculoRepository.findAll(pageable);
        }else{
            veiculos = this.veiculoRepository.findByEnabled(enabled, pageable);
        }

        return new PageResponse(veiculos);
    }

    @GetMapping("/{idVeiculo}")
    @ApiOperation("Lista um Veiculo pelo seu id")
    public Veiculo listarVeiculo(@PathVariable("idVeiculo") String idVeiculo) {
        Veiculo veiculo = this.veiculoRepository.findById(idVeiculo).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Identificador do veiculo não encontrado!") );
        return veiculo;
    }

    @DeleteMapping("/{idVeiculo}")
    @ApiOperation("Exclusão lógica de um Veiculo pelo seu id")
    public void delecaoLogicaVeiculo(@PathVariable("idVeiculo") String idVeiculo,
                                     @RequestParam(value = "enabledDescricao", defaultValue = "") String enabledDescricao) {
        Veiculo veiculo = this.veiculoRepository.findById(idVeiculo).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Identificador do veiculo não encontrado!") );
        veiculo.setEnabled(false);
        veiculo.setEnabledDescricao(enabledDescricao);
        this.veiculoRepository.save(veiculo);
    }
}
