package com.arenaapi.pojo;

import java.util.List;

public class FileCategoriesResponse {
	private int count;
	private List<Category> results;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<Category> getResults() {
		return results;
	}
	public void setResults(List<Category> results) {
		this.results = results;
	}
	
}
