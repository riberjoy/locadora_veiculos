package com.locadora.locacaoapi.controllers;

import com.locadora.locacaoapi.integrations.VeiculoApiGateway;
import com.locadora.locacaoapi.integrations.FuncionarioApiGateway;
import com.locadora.locacaoapi.integrations.ClienteApiGateway;
import com.locadora.locacaoapi.models.Funcionario;
import com.locadora.locacaoapi.models.Locacao;
import com.locadora.locacaoapi.models.PageResponse;
import com.locadora.locacaoapi.repositorys.LocacaoRepository;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Validated
@RestController
@RequestMapping("/locacao")
public class LocacaoController {

    @Autowired
    private LocacaoRepository repository;

    @Autowired
    private VeiculoApiGateway veiculoApiGateway;

    @Autowired
    private FuncionarioApiGateway funcionarioApiGateway;

    @Autowired
    private ClienteApiGateway clienteApiGateway;

    private List<Locacao> locacaoList = new ArrayList<Locacao>();

    @PostMapping("/inserir")
    @ApiOperation("Cadastrar uma locação")
    public void add(@RequestBody @Valid final Locacao locacao) {

        this.veiculoApiGateway.send(locacao.getVeiculoCode());

        this.funcionarioApiGateway.send(locacao.getFuncionarioCode());

        this.clienteApiGateway.send(locacao.getClienteCode());

        this.repository.save(locacao);
    }

    @GetMapping
    @ApiOperation("Listar locações")
    public PageResponse listAllRentals(Integer page, Integer size) {
        Pageable pageable = Objects.nonNull(page) && Objects.nonNull(size) ? PageRequest.of(page, size) : Pageable.unpaged();
        Page<Locacao> pageRental = repository.findAll(pageable);
        return new PageResponse(pageRental);
    }

    @ApiOperation("Listar locação por ID")
    @GetMapping("/{id}")
    public Optional<Locacao> listarPorId(@PathVariable("id") String id) {
        Locacao result = this.repository.findById(id).orElse(null);
        if (Objects.isNull(result)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Locação não encontrada");
        }
        return this.repository.findById(id);
    }

    @ApiOperation("Atualizar uma locação por ID")
    @PutMapping("/atualizar")
    public void putRental(@Valid @RequestBody Locacao locacao){
        Locacao result = this.repository.findById(locacao.getId()).orElse(null);
        if (Objects.isNull(result)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Locação não encontrada");
        }

        System.out.println(locacao.getVeiculoCode());
        System.out.println(result.getVeiculoCode());

        this.repository.save(locacao);
    }
}
