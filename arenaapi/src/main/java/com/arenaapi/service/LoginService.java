package com.arenaapi.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.arenaapi.pojo.Login;
import com.arenaapi.pojo.LoginDetails;

@Service("login")
public class LoginService {
	
	private static String url;
	private static Properties prop;
	public static LoginDetails LoginDetils;
	public static final String ARENA_SESSION_ID;
	static {
		try {
	    	url="https://api.arenasolutions.com/v1/login";
			 ClassLoader loader = Thread.currentThread().getContextClassLoader();
			 InputStream input = loader.getResourceAsStream("config.properties");
	            prop = new Properties();
	            // load a properties file
	            prop.load(input);
	            
	     } catch (IOException ex) {}
		
		  RestTemplate rs=new RestTemplate(); 
		  Login login=new Login(prop); 
		  LoginDetils=rs.postForObject(url,login,LoginDetails.class);
		  ARENA_SESSION_ID=LoginDetils.getArenaSessionId();
		  System.out.println("Login Successfull");
	}
	public LoginDetails login() {
		
		  return LoginDetils;
	}
	
	public boolean logout() {
		
	    	url="https://api.arenasolutions.com/v1/logout";
		  RestTemplate rs=new RestTemplate(); 
		  HttpHeaders headers = new HttpHeaders();
			headers.add("arena_session_id", LoginDetils.getArenaSessionId());
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		
			rs.put(url, entity);
		  System.out.println("Successfully logged out.");
		  return true;
	}
}
