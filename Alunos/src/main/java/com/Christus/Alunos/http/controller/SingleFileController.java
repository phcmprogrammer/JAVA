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

import com.Christus.Alunos.entity.SingleFile;
import com.Christus.Alunos.service.SingleFileService;

@RestController
@RequestMapping("/arquivo")
public class SingleFileController {
	
	@Autowired
	private SingleFileService singleFileService;
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping //verbo http - (SALVAR ALUNO)
	@ResponseStatus(HttpStatus.CREATED)
	public SingleFile salvar(@RequestBody SingleFile singleFile) {
		return singleFileService.salvar(singleFile);
	}
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<SingleFile> listaSingleFile(){
		return singleFileService.listaSingleFile();
	}
	
	@GetMapping ("/{Arquivo}")
	@ResponseStatus(HttpStatus.OK)
	public SingleFile buscarAlunoPorNome(@PathVariable("Arquivo") String fileName) {
		return singleFileService.buscarPorNome(fileName)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Arquivo não encontrado."));
	}
	@DeleteMapping("/{Arquivo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removerSingleFile(@PathVariable("Arquivo") String fileName) {
		singleFileService.buscarPorNome(fileName)
		.map(singleFile -> {
			singleFileService.removerPorNome(singleFile.getFileName());
			return Void.TYPE;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Arquivo não encontrado."));
	}
	
	@PutMapping("/{Arquivo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarSingleFile(
			@PathVariable("Arquivo")
			String fileName, @RequestBody SingleFile singleFile){
		singleFileService.buscarPorNome(fileName).map(singleFileBase ->{
			modelMapper.map(singleFile, singleFileBase);
			singleFileService.salvar(singleFileBase);
			return Void.TYPE;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Arquivo não encontrado."));		
	}
}
