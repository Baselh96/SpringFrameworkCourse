package com.example.demo;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class TimeEntry {
	@Id
	private String id;
	private  LocalDateTime start;
	private LocalDateTime stop;
	private String descreption;
	
	public TimeEntry(LocalDateTime start) {
		this.start = start;
	}
	public TimeEntry() {
		this.start = LocalDateTime.now();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDateTime getStart() {
		return start;
	}

	public LocalDateTime getStop() {
		return stop;
	}

	public void setStop(LocalDateTime stop) {
		this.stop = stop;
	}

	public String getDescreption() {
		return descreption;
	}

	public void setDescreption(String descreption) {
		this.descreption = descreption;
	}
	
}
