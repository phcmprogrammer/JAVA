package com.cadastro.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cadastro.domain.Aluno;
import com.cadastro.service.AlunoService;

@RestController
@RequestMapping(value="/alunos")
public class AlunoResource {

	@Autowired
	private AlunoService alunoService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Aluno> findById(@PathVariable Integer id){
		Aluno aluno = alunoService.findById(id);
		return ResponseEntity.ok(aluno);
	}
	
	@GetMapping
	public ResponseEntity<List<Aluno>> findAll(){
		List<Aluno> alunos = alunoService.findAll();
		return ResponseEntity.ok(alunos);
	}
	
	@PostMapping
	public ResponseEntity<Aluno> save(@RequestBody Aluno aluno){
		Aluno obj = alunoService.save(aluno);
		return ResponseEntity.ok().body(obj);
	}
	
	@PutMapping
	public ResponseEntity<Aluno> update(@RequestBody Aluno aluno){
		Aluno obj = alunoService.update(aluno);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		alunoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
