package com.Christus.Alunos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Christus.Alunos.entity.Directory;
import com.Christus.Alunos.repository.DirectoryRepository;

@Service
public class DirectoryService {
	
	@Autowired
	private DirectoryRepository directoryRepository;
	
	public Directory salvar(Directory directory){
		return directoryRepository.save(directory);
	}
	
	public List<Directory> listaDirectory(){
		return directoryRepository.findAll();
	}
	
	public Optional<Directory> buscarPorNome(String directoryName){
		return directoryRepository.findById(directoryName);
	}
	
	public void removerPorNome(String directoryName) {
		directoryRepository.deleteById(directoryName);
	}

}
