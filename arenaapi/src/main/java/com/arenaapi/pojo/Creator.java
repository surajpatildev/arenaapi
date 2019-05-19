package com.arenaapi.pojo;

public class Creator {

	private String email;
	private String fullName;
	private String guid;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	@Override
	public String toString() {
		return "Creator [email=" + email + ", fullName=" + fullName + ", guid=" + guid + "]";
	}
	
	
}
