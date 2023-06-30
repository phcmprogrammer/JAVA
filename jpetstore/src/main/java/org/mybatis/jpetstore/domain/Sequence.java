package org.mybatis.jpetstore.domain;

import java.io.Serializable;

public class Sequence implements Serializable {

	private static final long serialVersionUID = 8278780133180137281L;

	private String name;
	private int nextId;

	public Sequence() {
	}

	public Sequence(String name, int nextId) {
		this.name = name;
		this.nextId = nextId;
	}
//	Buider Desing Pattern
	public Sequence name(String name) {
		return this;
	}
	public Sequence nextId(int nextId) {
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
