package com.Christus.Alunos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Christus.Alunos.entity.SingleFile;
import com.Christus.Alunos.repository.SingleFileRepository;

@Service
public class SingleFileService {
	
	@Autowired
	private SingleFileRepository singleFileRepository;
	
	public SingleFile salvar(SingleFile singleFile) {
		return singleFileRepository.save(singleFile);
	}
	
	public List<SingleFile> listaSingleFile(){
		return singleFileRepository.findAll();
	}
	
	public Optional<SingleFile> buscarPorNome(String fileName){
		return singleFileRepository.findById(fileName);
	}
	
	public void removerPorNome(String fileName) {
		singleFileRepository.deleteById(fileName);
	}

}
