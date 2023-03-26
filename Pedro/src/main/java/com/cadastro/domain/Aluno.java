package com.cadastro.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Aluno implements Serializable {

private static final long serialVersionUID = 1L;	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String matricula;
	
	@OneToMany(mappedBy = "aluno", fetch = FetchType.EAGER)
	private List<Documento> documentos;
	
	public Aluno(String nome, String matricula) {
		super();
		this.nome = nome;
		this.matricula = matricula;
		this.documentos = new ArrayList<>();
	}
	
	public Aluno() {
		
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public List<Documento> getDocumentos() {
		return documentos;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
