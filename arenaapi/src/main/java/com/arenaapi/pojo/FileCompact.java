package com.arenaapi.pojo;

import java.util.Date;

public class FileCompact {
	private FileCategory category;

	private Date creationDateTime;
	private String edition;
	private String format;
	private String guid;
	private String name;
	private String number;
	private String title;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "FileCompact [category=" + category + ", creationDateTime=" + creationDateTime + ", edition=" + edition
				+ ", format=" + format + ", guid=" + guid + ", name=" + name + ", number=" + number + ", title=" + title
				+ "]";
	}
	public FileCompact() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FileCompact(FileCategory category, Date creationDateTime, String edition, String format, String guid,
			String name, String number, String title) {
		super();
		this.category = category;
		this.creationDateTime = creationDateTime;
		this.edition = edition;
		this.format = format;
		this.guid = guid;
		this.name = name;
		this.number = number;
		this.title = title;
	}
	
	
}
