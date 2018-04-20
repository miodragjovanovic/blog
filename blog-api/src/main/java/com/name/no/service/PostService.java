package com.name.no.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.name.no.model.CommentEntity;
import com.name.no.model.UserEntity;
import com.name.no.model.dto.CommentDto;
import com.name.no.repository.CommentRepository;
import com.name.no.repository.ContentRepository;
import com.name.no.repository.UserRepository;

@Service
public class PostService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ContentRepository contentRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private SessionRegistry sessionRegistry;
	 
	public boolean isUserLoggedIn(String username) {
		final List<Object> allPrincipals = sessionRegistry.getAllPrincipals();

		for (final Object principal : allPrincipals) {
			if (principal instanceof UserDetails) {
				final UserDetails user = (UserDetails) principal;

				if (user.getUsername().equals(username)) {
					return true;
				}
				// Do something with user
//				System.out.println(user);
			}
		}
		
		return false;
	}

	public String testMethod() {
		Iterable<UserEntity> users = userRepository.findAll();
		Iterator<UserEntity> iter = users.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next().getUsername());
		}
		return contentRepository.findOne("0ab2bf03-2c4d-11e8-8921-00acf535a81d").getText();
	}
	
	public boolean saveComment(String email, String text) {
		UUID id = UUID.randomUUID();
		CommentEntity commentEntity = commentRepository.findOne(id.toString());
		if (commentEntity != null) {
			return false;
		}
		commentEntity = new CommentEntity();
		commentEntity.setId(id.toString());
		commentEntity.setEmail(email);
		commentEntity.setText(text);
		
		commentRepository.save(commentEntity);
		
		return true;
	}
	
	public List<CommentDto> getAllComments() {
		List<CommentEntity> comments = commentRepository.findAll();
		List<CommentDto> commentDtos = new ArrayList<CommentDto>();
		for (CommentEntity commentEntity : comments) {
			commentDtos.add(CommentDto.fromEntity(commentEntity));
		}
		
		return commentDtos;
	}

}
