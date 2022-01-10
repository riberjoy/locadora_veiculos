package com.locadora.funcionarioapi.controllers;

import java.util.Objects;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.locadora.funcionarioapi.models.Funcionario;
import com.locadora.funcionarioapi.models.PageResponse;
import com.locadora.funcionarioapi.repositorys.FuncionarioRepository;

import io.swagger.annotations.ApiOperation;

@Validated
@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioRepository repositorio;
	
	@ApiOperation("Registra um Funcionario")
    @PostMapping("/inserir")
	public void inserir(@Valid @RequestBody Funcionario funcionario) {
		if (funcionario.getId() != null) {

			Optional<Funcionario> novoFuncionario = this.repositorio.findById(funcionario.getId());

			if (!novoFuncionario.isEmpty()) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Funcionario já existe!");
			}
		}

		this.repositorio.insert(funcionario);
	}
	
	@ApiOperation("Salvar o registro de um Funcionario")
    @PutMapping("/salvar")
	public void salvar(@Valid @RequestBody Funcionario funcionario) {
		this.repositorio.findById(funcionario.getId()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionario não encontrado!") );
        
		this.repositorio.save(funcionario);
	}

	@ApiOperation("Desativar um Funcionario")
	@PutMapping("/{id}/desativar")
	public void desativarFuncionario(@PathVariable("id") String id) {
		Funcionario funcionario = this.repositorio.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionario não encontrado!") );

		funcionario.setEnabled(false);
		this.repositorio.save(funcionario);
	}

	@ApiOperation("Ativar um Funcionario")
	@PutMapping("/{id}/ativar")
	public void ativarFuncionario(@PathVariable("id") String id) {
		Funcionario funcionario = this.repositorio.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionario não encontrado!") );

		funcionario.setEnabled(true);
		this.repositorio.save(funcionario);
	}
	
	@ApiOperation("Listar todos os Funcionario")
    @GetMapping
    public PageResponse<Funcionario> listarTodos(Integer page, Integer size,
												 @RequestParam(value = "enabled", required = false) Boolean enabled) {

		Pageable pageable = Objects.nonNull(page) && Objects.nonNull(size) ? PageRequest.of(page, size) : Pageable.unpaged();

		Page<Funcionario> pageFuncionario;

		if(Objects.isNull(enabled)){
			pageFuncionario = this.repositorio.findAll(pageable);
		}else{
			pageFuncionario = this.repositorio.findByEnabled(enabled, pageable);
		}

        return new PageResponse<Funcionario>(pageFuncionario);
    }
	
	@ApiOperation("Buscar um Funcionario por Código")
    @GetMapping("/{id}")
	public Funcionario buscar(@PathVariable("id") String id){
		Funcionario funcionario = this.repositorio.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionario não encontrado!") );
		
		return funcionario;
	}
}
