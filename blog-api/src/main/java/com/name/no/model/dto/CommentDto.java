package com.name.no.model.dto;

import com.name.no.model.CommentEntity;

public class CommentDto {

	private String id;

	private String email;

	private String text;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public static CommentDto fromEntity(CommentEntity entity) {
		CommentDto commentDto = new CommentDto();
		commentDto.setId(entity.getId());
		commentDto.setEmail(entity.getEmail());
		commentDto.setText(entity.getText());
		return commentDto;
	}

}
