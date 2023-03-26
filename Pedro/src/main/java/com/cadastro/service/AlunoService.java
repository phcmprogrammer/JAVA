package com.cadastro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadastro.domain.Aluno;
import com.cadastro.domain.repositories.AlunoRepository;
import com.cadastro.service.exception.ObjectNotFoundException;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;
	
	public Aluno findById(Integer id) {
		Optional<Aluno> aluno = alunoRepository.findById(id);
		return aluno.orElseThrow(() -> new ObjectNotFoundException(
			"Objeto não encontrado Id: "+ id + "Tipo: " + Aluno.class.getName()));
	}
	
	public List<Aluno> findAll(){
		return alunoRepository.findAll();
	}
	
	public Aluno save(Aluno aluno) {
		aluno.setId(null);
		return alunoRepository.save(aluno);
	}
	
	public Aluno update(Aluno aluno) {
		Aluno newaluno = new Aluno();
		updatealuno(aluno, newaluno);
		return alunoRepository.save(newaluno);
	}
	
	public void delete(Integer id) {
		alunoRepository.deleteById(id);
	}
	
	private void updatealuno(Aluno oldaluno, Aluno newaluno ) {
		newaluno.setNome(oldaluno.getNome());
	}
}
