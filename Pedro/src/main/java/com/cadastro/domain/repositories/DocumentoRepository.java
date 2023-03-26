package com.cadastro.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cadastro.domain.Documento;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Integer> {

	
	
}
