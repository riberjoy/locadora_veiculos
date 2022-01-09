package com.locadora.clienteapi.controllers;

import java.util.Objects;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locadora.clienteapi.models.Cliente;
import com.locadora.clienteapi.models.PageResponse;
import com.locadora.clienteapi.repositorys.ClienteRepository;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.server.ResponseStatusException;

@Validated
@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository repositorio;
	
	@ApiOperation("Registra um Cliente")
    @PostMapping("/inserir")
	public void inserir(@Valid @RequestBody Cliente cliente) {
		Optional<Cliente> novoCliente = this.repositorio.findById(cliente.getId());

		if(!novoCliente.isEmpty()){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente já existe!");
		}

		this.repositorio.insert(cliente);
	}
	
	@ApiOperation("Salvar o registro de um Cliente")
    @PutMapping("/salvar")
	public void salvar(@Valid @RequestBody Cliente cliente) {
		this.repositorio.findById(cliente.getId()).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!") );

		this.repositorio.save(cliente);
	}

	@ApiOperation("Desativar um Cliente")
	@PutMapping("/{id}/desativar")
	public void desativarCliente(@PathVariable("id") String id) {
		Cliente cliente = this.repositorio.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!") );

		cliente.setEnabled(false);
		this.repositorio.save(cliente);
	}

	@ApiOperation("Ativar um Cliente")
	@PutMapping("/{id}/ativar")
	public void ativarCliente(@PathVariable("id") String id) {
		Cliente cliente = this.repositorio.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!") );

		cliente.setEnabled(true);
		this.repositorio.save(cliente);
	}
	
	@ApiOperation("Listar todos os Clientes")
    @GetMapping
    public PageResponse<Cliente> listarTodos(Integer page, Integer size) {
		Pageable pageable = Objects.nonNull(page) && Objects.nonNull(size) ? PageRequest.of(page, size) : Pageable.unpaged();
		Page<Cliente> pageCliente = repositorio.findAll(pageable);
        return new PageResponse<Cliente>(pageCliente);
    }
	
	@ApiOperation("Buscar um Cliente por Código")
    @GetMapping("/{id}")
	public Cliente buscar(@PathVariable("id") String id){
		Cliente cliente = this.repositorio.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!") );

		return cliente;
	}
	
}
