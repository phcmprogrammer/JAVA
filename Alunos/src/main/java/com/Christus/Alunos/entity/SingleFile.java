package com.Christus.Alunos.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data   //CRIAR GETTERS, SETTERS AND TO STRING AUTOMATICALLY
@AllArgsConstructor //Criar construtor com as propriedades da entidade
@NoArgsConstructor // Criar um construtor vazio (Sem argumentos)
@Builder // Ajudar na criação de objetos Aluno
@Entity // Informar que é uma unidade de bando de dados

public class SingleFile implements Serializable,File {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="Arquivo", nullable = false,unique = true)
	private String fileName;
	
	@ManyToOne
	private Aluno aluno;
	
	@ManyToOne
	private Directory directoryName;
	
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public SingleFile(String fileName) {
	}

	@Override
	public boolean isFile() {
		return true;
	}

	@Override
	public boolean isDirectory() {
		return false;
	}

	@Override
	public String getName() {
		return this.fileName;
	}

	

}
