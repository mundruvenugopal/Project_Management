package com.purpletalk.pm.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.purpletalk.pm.entity.User;

public interface UserRepository extends JpaRepository<User, UUID> {

	Optional<User> findByEmail(String email);

	List<User> findAllByOrderByIdAsc();

	
	  @Query("SELECT count(*) FROM User where is_active=true") 
	  Long getUsersActiveCount();
	  @Query("SELECT count(*) FROM User where is_active=false") 
	  Long getUsersInActiveCount();

	Optional<User> findById(UUID user_id);


	 
	/*
	 * @Query("SELECT count(*) from user where is_active=true") Long
	 * getUsersActiveCount();
	 */

}
