package com.cadastro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cadastro.domain.Documento;
import com.cadastro.domain.repositories.DocumentoRepository;
import com.cadastro.service.exception.ObjectNotFoundException;

public class DocumentoService {

	@Autowired
	private DocumentoRepository documentoRepository;
	
	public Documento findById(Integer id) {
		Optional<Documento> documento = documentoRepository.findById(id);
		return documento.orElseThrow(() -> new ObjectNotFoundException(
			"Objeto não encontrado Id: "+ id + "Tipo: " + Documento.class.getName()));
	}
	
	public List<Documento> findAll(){
		return documentoRepository.findAll();
	}
	
	public Documento save(Documento documento) {
		documento.setId(null);
		return documentoRepository.save(documento);
	}
	
	public Documento update(Documento documento) {
		Documento newDocumento = new Documento();
		updateDocumento(documento, newDocumento);
		return documentoRepository.save(newDocumento);
	}
	
	public void delete(Integer id) {
		documentoRepository.deleteById(id);
	}
	
	private void updateDocumento(Documento oldDocumento, Documento newDocumento ) {
		newDocumento.setTipo(oldDocumento.getTipo());
		newDocumento.setSingleFile(oldDocumento.getSingleFile());
		newDocumento.setDirectoryName(oldDocumento.getDirectoryName());;
	}
	
}
