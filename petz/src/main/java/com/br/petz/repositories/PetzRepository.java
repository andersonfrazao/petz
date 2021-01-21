package com.br.petz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.petz.entities.Petz;

public interface PetzRepository extends JpaRepository<Petz, Integer> {

}
