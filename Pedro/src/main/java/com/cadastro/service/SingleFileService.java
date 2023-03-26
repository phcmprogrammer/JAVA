package com.cadastro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cadastro.domain.SingleFile;
import com.cadastro.domain.repositories.SingleFileRepository;
import com.cadastro.service.exception.ObjectNotFoundException;

public class SingleFileService {

	@Autowired
	private SingleFileRepository singleFileRepository;
	
	public SingleFile findById(Integer id) {
		Optional<SingleFile> singleFile = singleFileRepository.findById(id);
		return singleFile.orElseThrow(() -> new ObjectNotFoundException(
			"Objeto não encontrado Id: "+ id + "Tipo: " + SingleFile.class.getName()));
	}
	
	public List<SingleFile> findAll(){
		return singleFileRepository.findAll();
	}
	
	public SingleFile save(SingleFile singleFile) {
		singleFile.setId(null);
		return singleFileRepository.save(singleFile);
	}
	
	
	public void delete(Integer id) {
		singleFileRepository.deleteById(id);
	}
	
}
