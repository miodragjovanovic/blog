package com.name.no.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "post")
public class PostEntity {

	@Id
	private String id;
	@ManyToOne
	@JoinColumn(name = "author_id")
	private UserEntity userId;
	@ManyToOne
	@JoinColumn(name = "content_id")
	private ContentEntity contentId;
	@Column(name = "create_time")
	private Timestamp createTime;
	
	public PostEntity() {};
	
	public PostEntity(String id, UserEntity userId, ContentEntity contentId, Timestamp createTime) {
		this.id = id;
		this.userId = userId;
		this.contentId = contentId;
		this.createTime = createTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public UserEntity getUserId() {
		return userId;
	}

	public void setUserId(UserEntity userId) {
		this.userId = userId;
	}

	public ContentEntity getContentId() {
		return contentId;
	}

	public void setContentId(ContentEntity contentId) {
		this.contentId = contentId;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}
