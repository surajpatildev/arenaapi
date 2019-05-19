package com.arenaapi;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.arenaapi.pojo.Author;
import com.arenaapi.pojo.File;
import com.arenaapi.pojo.FileCategory;
import com.arenaapi.pojo.FileCompact;
import com.arenaapi.service.CategoriesService;
import com.arenaapi.service.FilesService;
import com.arenaapi.service.LoginService;
import com.fasterxml.jackson.core.JsonProcessingException;

public class App 
{
	static List<String> fileNumbers = new ArrayList<String>();
	//TestFile Numbers - FILE-000708 ,FILE-000725,FILE-025724- Rest API
    private static ApplicationContext context;
	public static void main( String[] args ) throws JsonProcessingException
    {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		fileNumbers.add("FILE-000708");
		fileNumbers.add("FILE-000757");
		fileNumbers.add("FILE-000862");
		fileNumbers.add("FILE-000775");
		  FilesService fileservice=(FilesService) context.getBean(FilesService.class);
		  CategoriesService catServ=context.getBean(CategoriesService.class);
		 		  
		  Map<String, String> fileCatGuidMap=catServ.getFileCategoryGUIDMap();
	     //List<FileCompact> list= (List<FileCompact>) context.getBean(FilesService.class).getfilesbyFileNumber("FILE-001*");
		  
		  FileCompact fileCompact=fileservice.getExactFilebyFileNumber("FILE-025724");
		  //System.out.println(fileCompact.getGuid() + " & " + fileCompact.getNumber());
	
		  //List<FileCompact> compacts= fileservice.getFileCompactsbyFileNumberList(fileNumbers);
		  //System.out.println(compacts);
		  
		  //Map<String,String> fileGuidMap= fileservice.getFileNumberGUIDMapbyNumberList(fileNumbers);
		
		  //File file=fileservice.getFilebyGUID(fileCompact.getGuid());
		  File file=new File();
		  file.setTitle("arena api details 2");
		  file.setAuthor(new Author("Shubham Kele"));
		  file.setDescription("Testing 4");
		  file.setFormat("png");
		  file.setPrivate(false);
		  file.setCategory(new FileCategory(fileCatGuidMap.get("Primary Image")));
		  //modify and Update
		  System.out.println("Title is : "+fileCompact.getTitle() +" And GUID is - " +fileCompact.getGuid());
		  fileservice.update(fileCompact.getGuid(),file);
		  File updatedFile=fileservice.getFilebyGUID(fileCompact.getGuid());
		  System.out.println("Updated Title is : "+updatedFile.getTitle());
		  
		  
		  ((LoginService)context.getBean(LoginService.class)).logout();
    }
}
