package com.name.no.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(path="/blog/loggedIn", method = RequestMethod.POST)
	public boolean isUserLoggedIn(@RequestParam("user") String user) {
		System.out.println(user);
		return postService.isUserLoggedIn(user);
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
	
	@RequestMapping(value = "/blog/me")
    public void getMe(Principal principal) {
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) principal;
        Object obj = token.getPrincipal();
        System.out.println(obj);
        
//        return userService.findById(id)
//                .orElseThrow(() -> new RuntimeException());
    }

}
