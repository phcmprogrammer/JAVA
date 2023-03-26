package com.cadastro.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Documento implements Serializable, File{

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private SingleFile singleFile;
	private String directoryName;
	private String tipo;
	private Aluno aluno;
	
	public Documento(SingleFile singleFile, String directoryName, String tipo) {
		this.singleFile = singleFile;
		this.directoryName = directoryName;
		this.tipo = tipo;
	}
	
	public Documento() {
		
	}
	
	public SingleFile getSingleFile() {
		return singleFile;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setSingleFile(SingleFile singleFile) {
		this.singleFile = singleFile;
	}

	public void setDirectoryName(String directoryName) {
		this.directoryName = directoryName;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDirectoryName() {
		return directoryName;
	}
	
	
	public String getTipo() {
		return tipo;
	}
	
	public Aluno getAluno() {
		return aluno;
	}
	
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(aluno, directoryName, id, singleFile, tipo);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Documento other = (Documento) obj;
		return Objects.equals(aluno, other.aluno) && Objects.equals(directoryName, other.directoryName)
				&& Objects.equals(id, other.id) && Objects.equals(singleFile, other.singleFile)
				&& Objects.equals(tipo, other.tipo);
	}
	
	@Override
	public String toString() {
		return "Documento [id=" + id + ", singleFile=" + singleFile + ", directoryName=" + directoryName + ", tipo=" + tipo
				+ ", aluno=" + aluno + "]";
	}
	
	@Override
	public boolean isFile() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean isDirectory() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String getAbsolutePath() {
		// TODO Auto-generated method stub
		return null;
	}

}
