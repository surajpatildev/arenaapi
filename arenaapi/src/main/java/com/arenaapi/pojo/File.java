package com.arenaapi.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class File {

	private Author author;
	private FileCategory category;
	
	private Date creationDateTime;
	
	private String description;
	
	private String edition;
	
	private String format;
	
	private String guid;
	
	private Date lastModifiedDateTime;
	
	private String mimeType;
	
	private String name;
	
	private String number;
	

	@JsonAlias("private")
	private boolean Private;
	
	
	private String storageMethodName;
	private String title;
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public FileCategory getCategory() {
		return category;
	}
	public void setCategory(FileCategory category) {
		this.category = category;
	}
	public Date getCreationDateTime() {
		return creationDateTime;
	}
	public void setCreationDateTime(Date creationDateTime) {
		this.creationDateTime = creationDateTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	
	public Date getLastModifiedDateTime() {
		return lastModifiedDateTime;
	}
	public void setLastModifiedDateTime(Date lastModifiedDateTime) {
		this.lastModifiedDateTime = lastModifiedDateTime;
	}
	
	
	public String getMimeType() {
		return mimeType;
	}
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public boolean isPrivate() {
		return Private;
	}
	public void setPrivate(boolean private1) {
		Private = private1;
	}
	
	
	public String getStorageMethodName() {
		return storageMethodName;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "File [author=" + author + ", category=" + category + ", creationDateTime=" + creationDateTime
				+ ", description=" + description + ", edition=" + edition + ", format=" + format + ", guid=" + guid
				+ ", lastModifiedDateTime=" + lastModifiedDateTime + ", mimeType=" + mimeType + ", name=" + name
				+ ", number=" + number + ", Private=" + Private + ", storageMethodName=" + storageMethodName
				+ ", title=" + title + "]";
	}
	
	
	
}
