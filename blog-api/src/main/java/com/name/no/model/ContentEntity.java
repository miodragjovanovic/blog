package com.name.no.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "content")
public class ContentEntity {
	
	@Id
	private String id;
	@Column(name = "text", nullable = false, length = 65535, columnDefinition="TEXT")
	private String text;
	
	public ContentEntity() {}
	
	public ContentEntity(String id, String text) {
		this.id = id;
		this.text = text;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
