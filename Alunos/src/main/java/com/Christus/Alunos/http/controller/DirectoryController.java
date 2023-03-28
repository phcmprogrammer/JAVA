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

import com.Christus.Alunos.entity.Directory;
import com.Christus.Alunos.service.DirectoryService;

@RestController
@RequestMapping("/pasta")
public class DirectoryController {
	
	@Autowired
	private DirectoryService directoryService;
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping //verbo http - (SALVAR ALUNO)
	@ResponseStatus(HttpStatus.CREATED)
	public Directory salvar(@RequestBody Directory directory) {
		return directoryService.salvar(directory);
	}
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Directory> listaDirectory(){
		return directoryService.listaDirectory();
	}
	
	@GetMapping ("/{Pasta}")
	@ResponseStatus(HttpStatus.OK)
	public Directory buscarAlunoPorNome(@PathVariable("Pasta") String directoryName) {
		return directoryService.buscarPorNome(directoryName)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pasta não encontrada."));
	}
	@DeleteMapping("/{Pasta}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removerDirectory(@PathVariable("Pasta") String directoryName) {
		directoryService.buscarPorNome(directoryName)
		.map(directory -> {
			directoryService.removerPorNome(directory.getName());
			return Void.TYPE;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Arquivo não encontrado."));
	}
	
	@PutMapping("/{Pasta}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarSingleFile(
			@PathVariable("Pasta")
			String directoryName, @RequestBody Directory directory){
			directoryService.buscarPorNome(directoryName).map(directoryBase ->{
			modelMapper.map(directory, directoryBase);
			directoryService.salvar(directoryBase);
			return Void.TYPE;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Arquivo não encontrado."));		
	}
	

}
