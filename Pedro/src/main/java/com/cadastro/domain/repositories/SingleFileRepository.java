package com.cadastro.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cadastro.domain.SingleFile;

@Repository
public interface SingleFileRepository extends JpaRepository<SingleFile, Integer>{

}
