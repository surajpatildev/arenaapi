package com.arenaapi.pojo;

import java.util.Properties;

public class Login {
	
	private String email;
	private String password;
	private Object workspaceId;
	
	
	public Login() {
		super();
	}
	public Login(String email, String password, Object workspaceId) {
		super();
		this.email = email;
		this.password = password;
		this.workspaceId = workspaceId;
	}
	public Login(Properties prop) {
		this.email=prop.getProperty("arena.email");
        this.password=prop.getProperty("arena.password");
        this.workspaceId=prop.getProperty("arena.workspaceId");
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Object getWorkspaceId() {
		return workspaceId;
	}
	public void setWorkspaceId(Object workspaceId) {
		this.workspaceId = workspaceId;
	}
	@Override
	public String toString() {
		return "Login [email=" + email + ", password=" + password + ", workspaceId=" + workspaceId + "]";
	}
	
	
}
