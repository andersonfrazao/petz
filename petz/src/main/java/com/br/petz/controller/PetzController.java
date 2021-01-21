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

import com.br.petz.entities.Petz;
import com.br.petz.repositories.PetzRepository;

@RestController
@RequestMapping("/petz")
public class PetzController {
	
	@Autowired
	PetzRepository petzRepository;
	
	
	
	@PostMapping
	public ResponseEntity<Petz> save(@RequestBody Petz petz){
		petzRepository.save(petz);
		return new ResponseEntity<Petz>(petz, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Petz>>getAll(){
		List<Petz> petzs = new ArrayList<Petz>();
		petzs = petzRepository.findAll();
		return new ResponseEntity<List<Petz>>(petzs, HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Petz> getById(@PathVariable Integer id){
		Petz petz;
		try {
			petz = petzRepository.findOne(id);
			return new ResponseEntity<Petz>(petz, HttpStatus.OK);
		}catch (NoSuchElementException e) {
			return new ResponseEntity<Petz>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Petz> deleteById(@PathVariable Integer id){
		try {
			petzRepository.delete(id);
			return new ResponseEntity<Petz>(HttpStatus.OK);
		}catch (NoSuchElementException e) {
			return new ResponseEntity<Petz>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Petz> update(@PathVariable Integer id, @RequestBody Petz petz){
		Petz p = petzRepository.findOne(id);
		p.setEspecie(petz.getEspecie());
		p.setGenero(petz.getGenero());
		p.setIdade(petz.getIdade());
		Petz petzUpdate = petzRepository.save(p);
		
		return ResponseEntity.ok(petzUpdate);
		
	}

}
