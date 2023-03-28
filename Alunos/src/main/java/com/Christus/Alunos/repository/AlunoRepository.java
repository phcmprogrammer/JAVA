package com.Christus.Alunos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Christus.Alunos.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, String> {
}
