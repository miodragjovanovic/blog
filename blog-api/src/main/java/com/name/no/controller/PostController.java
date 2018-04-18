package com.name.no.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.name.no.model.dto.CommentDto;
import com.name.no.service.PostService;

@RequestMapping("/api")
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@RequestMapping("/blog/test")
	public String getPosts() {
		return postService.testMethod();
	}
	
	@RequestMapping(path="/blog/save", method = RequestMethod.POST)
	public Boolean save(String data, String email) {
		System.out.println("Recieved data: " + data);
		System.out.println("Recieved email: " + email);
		return postService.saveComment(email, data);
	}
	
	@RequestMapping("/user/comments")
	public List<CommentDto> getCommanets() {
		return postService.getAllComments();
	}

}
