package com.br.petz.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.petz.entities.Cliente;
import com.br.petz.repositories.ClienteRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	
	@PostMapping
	public ResponseEntity<Cliente> save(@RequestBody Cliente cliente){
		clienteRepository.save(cliente);
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Cliente>>getAll(){
		List<Cliente> clientes = new ArrayList<Cliente>();
		clientes = clienteRepository.findAll();
		return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Cliente> getById(@PathVariable Integer id){
		Cliente cliente;
		
		try {
			cliente = clienteRepository.findOne(id);
			return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
		}catch (NoSuchElementException e) {
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Cliente> deleteById(@PathVariable Integer id){
		try {
			clienteRepository.delete(id);
			return new ResponseEntity<Cliente>(HttpStatus.OK);
		}catch (NoSuchElementException e) {
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Cliente> update(@PathVariable Integer id, @RequestBody Cliente cliente){
		Cliente c = clienteRepository.findOne(id);
		c.setCpf(cliente.getCpf());
		c.setEndereco(cliente.getEndereco());
		c.setNome(cliente.getNome());
		Cliente clienteUpdate = clienteRepository.save(c);
		
		return ResponseEntity.ok(clienteUpdate);
		
	}

}
