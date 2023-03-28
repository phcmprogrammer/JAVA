package com.Christus.Alunos.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // CRIAR GETTERS, SETTERS AND TO STRING AUTOMATICALLY
@AllArgsConstructor // Criar construtor com as propriedades da entidade
@NoArgsConstructor // Criar um construtor vazio (Sem argumentos)
@Builder // Ajudar na criação de objetos Aluno
@Entity // Informar que é uma unidade de bando de dados
public class Aluno implements Serializable {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSingleFiles(List<SingleFile> singleFiles) {
		this.singleFiles = singleFiles;
	}

//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private long id;

	@Id
	@Column(name = "matricula", nullable = false, unique = true)
	private String matricula;

	@Column(name = "nome", nullable = false)
	private String nome;

	@OneToMany
	private List<SingleFile> singleFiles;
	
	@OneToMany
	private List<Directory> directories;

	public List<SingleFile> getSingleFiles() {
		return singleFiles;
	}

}
