package com.Christus.Alunos.http.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


import com.Christus.Alunos.entity.Aluno;
import com.Christus.Alunos.service.AlunoService;

@RestController //Definindo Controller
@RequestMapping("/aluno") //Rota de Aluno
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping //verbo http - (SALVAR ALUNO)
	@ResponseStatus(HttpStatus.CREATED)
	public Aluno salvar(@RequestBody Aluno aluno) {
		return alunoService.salvar(aluno);
	}
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Aluno> listaAluno(){
		return alunoService.listaAluno();
	}
	
	@GetMapping ("/{matricula}")
	@ResponseStatus(HttpStatus.OK)
	public Aluno buscarAlunoPorMatricula(@PathVariable("matricula") String matricula) {
		return alunoService.buscarPorMatricula(matricula)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado."));
	}
	@DeleteMapping("/{matricula}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removerAluno(@PathVariable("matricula") String matricula) {
		alunoService.buscarPorMatricula(matricula)
		.map(aluno -> {
			alunoService.removerPorMatricula(aluno.getMatricula());
			return Void.TYPE;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado."));
	}
	
	@PutMapping("/{matricula}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarAluno(
			@PathVariable("matricula")
			String matricula, @RequestBody Aluno aluno){
		alunoService.buscarPorMatricula(matricula).map(alunoBase ->{
			modelMapper.map(aluno, alunoBase);
			alunoService.salvar(alunoBase);
			return Void.TYPE;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado."));		
	}

}
