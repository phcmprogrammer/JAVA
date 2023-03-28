package com.Christus.Alunos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Christus.Alunos.entity.Aluno;
import com.Christus.Alunos.repository.AlunoRepository;

@Service

public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	public Aluno salvar(Aluno aluno) {
		return alunoRepository.save(aluno);
		
	}
	
	public List<Aluno> listaAluno(){
		return alunoRepository.findAll();
	}
	
	public Optional<Aluno> buscarPorMatricula(String matricula){
		return alunoRepository.findById(matricula);
	}
	
	public void removerPorMatricula(String matricula) {
		alunoRepository.deleteById(matricula);
	}

} 
