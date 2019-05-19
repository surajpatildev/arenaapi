package com.arenaapi.pojo;

public class LoginDetails {
	
	private String arenaSessionId;
	private String workspaceName;
	private Object workspaceId;
	private Object workspaceRequestLimit;
	public String getArenaSessionId() {
		return arenaSessionId;
	}
	public void setArenaSessionId(String arenaSessionId) {
		this.arenaSessionId = arenaSessionId;
	}
	public String getWorkspaceName() {
		return workspaceName;
	}
	public void setWorkspaceName(String workspaceName) {
		this.workspaceName = workspaceName;
	}
	public Object getWorkspaceId() {
		return workspaceId;
	}
	public void setWorkspaceId(Object workspaceId) {
		this.workspaceId = workspaceId;
	}
	public Object getWorkspaceRequestLimit() {
		return workspaceRequestLimit;
	}
	public void setWorkspaceRequestLimit(Object workspaceRequestLimit) {
		this.workspaceRequestLimit = workspaceRequestLimit;
	}
	@Override
	public String toString() {
		return "LoginDetails [arenaSessionId=" + arenaSessionId + ", workspaceName=" + workspaceName + ", workspaceId="
				+ workspaceId + ", workspaceRequestLimit=" + workspaceRequestLimit + "]";
	}
	public LoginDetails(String arenaSessionId, String workspaceName, Object workspaceId, Object workspaceRequestLimit) {
		super();
		this.arenaSessionId = arenaSessionId;
		this.workspaceName = workspaceName;
		this.workspaceId = workspaceId;
		this.workspaceRequestLimit = workspaceRequestLimit;
	}
	public LoginDetails() {
		super();
	}
	
	
}
