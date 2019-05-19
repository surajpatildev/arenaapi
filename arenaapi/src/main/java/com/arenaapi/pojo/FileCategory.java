package com.arenaapi.pojo;

public class FileCategory {
	
	private String guid;

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	@Override
	public String toString() {
		return getGuid();
	}

	public FileCategory(String guid) {
		super();
		this.guid = guid;
	}

	public FileCategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
