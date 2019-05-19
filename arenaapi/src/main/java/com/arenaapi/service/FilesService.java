package com.arenaapi.service;

import java.util.ArrayList;
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

import com.arenaapi.pojo.File;
import com.arenaapi.pojo.FileCompact;
import com.arenaapi.pojo.FilesResponse;
import com.arenaapi.pojo.LoginDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service("getfiles")
public class FilesService {
	

	public List<FileCompact> getfilesbyFileNumber(String fileNumber){
		int offset=400;
		int count=0;
		String url = "https://api.arenasolutions.com/v1/files?limit=400&number="+fileNumber;
		RestTemplate rs=new RestTemplate(); 
		HttpHeaders headers = new HttpHeaders();
		headers.add("arena_session_id",LoginService.ARENA_SESSION_ID);
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		/*
		 * Map<String, String> params = new HashMap<String, String>();
		 * params.put("number",fileNumber);
		 */
		ResponseEntity<FilesResponse> response=rs.exchange(url, HttpMethod.GET, entity, FilesResponse.class);
		count=response.getBody().getCount();
		while(count==400) {
			url = "https://api.arenasolutions.com/v1/files?offset="+offset+"&limit=400&number="+fileNumber;
			ResponseEntity<FilesResponse> responsetemp=rs.exchange(url, HttpMethod.GET, entity, FilesResponse.class);
			count=responsetemp.getBody().getCount();
			offset=offset+400;
			response.getBody().setCount(response.getBody().getCount()+responsetemp.getBody().getCount());
			response.getBody().getResults().addAll(responsetemp.getBody().getResults());
		}
		System.out.println("Total count of files is "+response.getBody().getCount());
		return response.getBody().getResults();

	}

	public FileCompact getExactFilebyFileNumber(String fileNumber){
		String url = "https://api.arenasolutions.com/v1/files?limit=400&number="+fileNumber;
		RestTemplate rs=new RestTemplate(); 
		HttpHeaders headers = new HttpHeaders();
		headers.add("arena_session_id", LoginService.ARENA_SESSION_ID);
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		/*
		 * Map<String, String> params = new HashMap<String, String>();
		 * params.put("number",fileNumber);
		 */
		ResponseEntity<FilesResponse> response=rs.exchange(url, HttpMethod.GET, entity, FilesResponse.class);
		if (response.getBody().getCount() == 1) {

			return response.getBody().getResults().get(0);
		}
		//need to write logic to extact correct file number from the list
		return null;

	}



	public List<FileCompact> getFileCompactsbyFileNumberList(List<String> fileNumbers){
		List<FileCompact> fileCompacts = new ArrayList<FileCompact>(); 
		RestTemplate rs=new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("arena_session_id",LoginService.ARENA_SESSION_ID);
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		for(String fileNumber : fileNumbers) {

			String url = "https://api.arenasolutions.com/v1/files?limit=1&number="+fileNumber; 

			ResponseEntity<FilesResponse> response=rs.exchange(url, HttpMethod.GET, entity, FilesResponse.class);
			//System.out.println(response.getBody().getResults().get(0).getNumber());
			if ((response.getBody().getResults().get(0).getNumber()).equalsIgnoreCase(fileNumber)) {
				fileCompacts.add(response.getBody().getResults().get(0));

			}else {
				//need to add notes variable to catch the wrong file numbers.intialize obj and write in notes if not valid
			}

		}

		return fileCompacts;
	}

	public Map<String, String> getFileNumberGUIDMapbyNumberList(List<String> fileNumbers){
		Map<String,String> numberGuidMap = new HashMap<String, String>(); 
		RestTemplate rs=new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("arena_session_id",LoginService.ARENA_SESSION_ID);
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		for(String fileNumber : fileNumbers) {

			String url = "https://api.arenasolutions.com/v1/files?limit=1&number="+fileNumber; 

			ResponseEntity<FilesResponse> response=rs.exchange(url, HttpMethod.GET, entity, FilesResponse.class);
			//System.out.println(response.getBody().getResults().get(0).getNumber());
			if ((response.getBody().getResults().get(0).getNumber()).equalsIgnoreCase(fileNumber)) {
				numberGuidMap.put(fileNumber,response.getBody().getResults().get(0).getGuid());

			}else {
				//need to add notes variable to catch the wrong file numbers.intialize obj and write in notes if not valid
			}

		}

		return numberGuidMap;
	}
	
	
	public File getFilebyGUID(String GUID){
		String url = "https://api.arenasolutions.com/v1/files/{GUID}";
		RestTemplate rs=new RestTemplate(); 
		HttpHeaders headers = new HttpHeaders();
		headers.add("arena_session_id",LoginService.ARENA_SESSION_ID);
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		
		  Map<String, String> params = new HashMap<String, String>();
		  params.put("GUID",GUID);
		 
		ResponseEntity<File> response=rs.exchange(url, HttpMethod.GET, entity, File.class,params);
		
		return response.getBody();
	}
	
	public void update(String guid,File file) throws JsonProcessingException {
		String url = "https://api.arenasolutions.com/v1/files/{GUID}";
		RestTemplate rs=new RestTemplate(); 
		HttpHeaders headers = new HttpHeaders();
		headers.add("arena_session_id",LoginService.ARENA_SESSION_ID);
		headers.setContentType(MediaType.APPLICATION_JSON);
		Map<String, String> urlVariables = new HashMap<String, String>();
		urlVariables.put("GUID",guid);
		ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(file);
		HttpEntity<String> entity = new HttpEntity<String>(json, headers);
		
		  
		  //rs.put(url, entity, urlVariables);
		  ResponseEntity<File> response=rs.exchange(url, HttpMethod.PUT, entity, File.class,urlVariables);
		  System.out.println(response.getBody().getNumber() + " Updated successfully.");
		 //return response.getBody();
	}
}
