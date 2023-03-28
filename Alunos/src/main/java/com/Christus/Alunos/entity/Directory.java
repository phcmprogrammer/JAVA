package com.Christus.Alunos.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Directory implements Serializable,File {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	@Id
//	@Column(name= "Pasta", nullable = false)
//	private String directoryName;
//	@Column(name= "children", unique = true)
//	private File[] children;
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer id;
//	private List<SingleFile> singleFiles;
	

	@Id
	@Column(name="Pasta")
	private String directoryName;

	@OneToMany
	private List<SingleFile> singleFiles;

	@ManyToOne
	private Aluno aluno;
	
	
	public Directory(String directoryName) {
		this.directoryName = directoryName;
	}
	
	public String getDirectoryName() {
		return directoryName;
	}


	public void setDirectoryName(String directoryName) {
		this.directoryName = directoryName;
	}


//	public File[] getChildren() {
//		return children;
//	}
//
//
//	public void setChildren(File[] children) {
//		this.children = children;
//	}
	
	public void removeChild(File file){	
	}

	@Override
	public boolean isFile() {
		return false;
	}

	@Override
	public boolean isDirectory() {
		return true;
	}

	@Override
	public String getName() {
		return this.directoryName;
	}
}
