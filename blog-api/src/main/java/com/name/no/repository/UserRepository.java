package com.name.no.repository;

import org.springframework.stereotype.Repository;

import com.name.no.model.UserEntity;
import java.lang.String;

@Repository
public interface UserRepository extends BaseRepository<UserEntity, String>  {
	
	UserEntity findByUsername(String username);

}
