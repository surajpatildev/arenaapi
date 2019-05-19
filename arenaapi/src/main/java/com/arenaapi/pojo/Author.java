package com.arenaapi.pojo;

public class Author {
	
	private String fullName;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public String toString() {
		return getFullName();
	}

	public Author(String fullName) {
		super();
		this.fullName = fullName;
	}

	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
