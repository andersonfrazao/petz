package com.br.petz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.petz.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
