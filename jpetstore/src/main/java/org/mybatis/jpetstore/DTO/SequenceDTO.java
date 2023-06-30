package org.mybatis.jpetstore.DTO;

import java.io.Serializable;

public class SequenceDTO implements Serializable {

	private static final long serialVersionUID = 8278780133180137281L;

	private String name;
	private int nextId;

	public SequenceDTO() {
	}

	public SequenceDTO(String name, int nextId) {
		this.name = name;
		this.nextId = nextId;
	}
//	Buider Desing Pattern
	public SequenceDTO name(String name) {
		return this;
	}
	public SequenceDTO nextId(int nextId) {
		return this;
	}
//	Buider Desing Pattern

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNextId() {
		return nextId;
	}

	public void setNextId(int nextId) {
		this.nextId = nextId;
	}

}
