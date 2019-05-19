package com.arenaapi.pojo;

import java.util.List;

public class FilesResponse {
	
	private int count;
	private List<FileCompact> results;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<FileCompact> getResults() {
		return results;
	}
	public void setResults(List<FileCompact> results) {
		this.results = results;
	}
	
	
}
