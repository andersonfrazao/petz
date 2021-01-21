package com.br.petz.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cliente {
	
	@Id
	@Column(name = "ID", unique = true, nullable = false)
//	@SequenceGenerator(name = "ID_GEN", sequenceName = "SEQ_ID_CLIENTE", allocationSize = 1)
	@GeneratedValue
	private Integer id;

	@Column(name = "CPF", length = 11, nullable = false)
	private String cpf;
	
	@Column(name = "NOME", length = 100, nullable = false)
	private String nome;
	
	@Column(name = "ENDERECO", length = 200, nullable = false)
	private String endereco;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	

	

}
