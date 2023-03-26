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

import com.cadastro.domain.Documento;
import com.cadastro.service.DocumentoService;

@RestController
@RequestMapping(value="/documentos")
public class DocumentoResource {

	
	@Autowired
	private DocumentoService documentoService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Documento> findById(@PathVariable Integer id){
		Documento documento = documentoService.findById(id);
		return ResponseEntity.ok(documento);
	}
	
	@GetMapping
	public ResponseEntity<List<Documento>> findAll(){
		List<Documento> documentos = documentoService.findAll();
		return ResponseEntity.ok(documentos);
	}
	
	@PostMapping
	public ResponseEntity<Documento> save(@RequestBody Documento documento){
		Documento obj = documentoService.save(documento);
		return ResponseEntity.ok().body(obj);
	}
	
	@PutMapping
	public ResponseEntity<Documento> update(@RequestBody Documento documento){
		Documento obj = documentoService.update(documento);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		documentoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
