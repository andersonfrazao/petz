package com.br.petz.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Petz {
	
	@Id
	@GeneratedValue
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "ESPECIE", length = 30, nullable = false)
	private String especie;
	
	@Column(name = "GENERO", length = 30, nullable = false)
	private String genero;
	
	@Column(name = "IDADE", length = 4, nullable = false)	
	private Integer idade;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	
	

}
