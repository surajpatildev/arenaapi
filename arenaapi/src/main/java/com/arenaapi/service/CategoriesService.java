package com.arenaapi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.arenaapi.pojo.Category;
import com.arenaapi.pojo.FileCategoriesResponse;
import com.arenaapi.pojo.LoginDetails;

@Service("categories")
public class CategoriesService {
	
	private Map<String,String> gUIDFileCatmap;
	private Map<String,String> fileCatGUIDmap;
	@SuppressWarnings("unused")
	private static boolean generated;
	static {
		 generated=false;
	}
	public List<Category> getAllFileCategories(){
		
		String url = "https://api.arenasolutions.com/v1/settings/files/categories";
		RestTemplate rs=new RestTemplate(); 
		HttpHeaders headers = new HttpHeaders();
		headers.add("arena_session_id",LoginService.ARENA_SESSION_ID);
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		ResponseEntity<FileCategoriesResponse> response=rs.exchange(url, HttpMethod.GET, entity, FileCategoriesResponse.class);
		
		return response.getBody().getResults();
	}
	
private void generateGUIDFileCategoryMap(){
		
		 this.gUIDFileCatmap=new HashMap<String, String>();
		 this.fileCatGUIDmap=new HashMap<String, String>();

		String url = "https://api.arenasolutions.com/v1/settings/files/categories";
		RestTemplate rs=new RestTemplate(); 
		HttpHeaders headers = new HttpHeaders();
		headers.add("arena_session_id", LoginService.ARENA_SESSION_ID);
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		ResponseEntity<FileCategoriesResponse> response=rs.exchange(url, HttpMethod.GET, entity, FileCategoriesResponse.class);
		for (Category category : response.getBody().getResults()) {
			this.gUIDFileCatmap.put(category.getGuid(), category.getName());
			this.fileCatGUIDmap.put(category.getName(),category.getGuid());
		}
		generated = true;
	}

public Map<String,String> getGUIDFileCategoryMap(){
	if (generated==true) {
		return this.gUIDFileCatmap;
	}else {
		generateGUIDFileCategoryMap();
		return this.gUIDFileCatmap;
	}
	
}

public Map<String,String> getFileCategoryGUIDMap(){
	if (generated==true) {
		return this.fileCatGUIDmap;
	}else {
		generateGUIDFileCategoryMap();
		return this.fileCatGUIDmap;
	}
	
}
}
