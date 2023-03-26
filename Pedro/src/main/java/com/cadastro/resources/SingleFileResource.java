package com.cadastro.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cadastro.domain.SingleFile;
import com.cadastro.service.SingleFileService;

public class SingleFileResource {

	@Autowired
	private SingleFileService singleFileService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<SingleFile> findById(@PathVariable Integer id){
		SingleFile singleFile = singleFileService.findById(id);
		return ResponseEntity.ok(singleFile);
	}
	
	@GetMapping
	public ResponseEntity<List<SingleFile>> findAll(){
		List<SingleFile> singleFiles = singleFileService.findAll();
		return ResponseEntity.ok(singleFiles);
	}
	
	@PostMapping
	public ResponseEntity<SingleFile> save(@RequestBody SingleFile singleFile){
		SingleFile obj = singleFileService.save(singleFile);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		singleFileService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
