package com.purpletalk.pm.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purpletalk.pm.entity.Role;
import com.purpletalk.pm.entity.User;
import com.purpletalk.pm.models.UserRequestDTO;
import com.purpletalk.pm.models.UserResponseDTO;
import com.purpletalk.pm.repository.RoleRepository;
import com.purpletalk.pm.repository.UserRepository;
@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository rolerepository;
	public void saveUser(UserRequestDTO userrequestdto) {
		User user = new User();
		user.setFirstName(userrequestdto.getFirstName());
		user.setLastName(userrequestdto.getLastName());
		user.setEmail(userrequestdto.getEmail());
		user.setPassword(userrequestdto.getPassword());
		user.set_active(userrequestdto.is_active());
		// Role role = rolerepository.findById(userrequestdto.getRoleId()).orElse(null);
		 Optional<Role>role=rolerepository.findById((long)userrequestdto.getRoleId()); 
		user.setRole(role.get());
		userRepository.save(user);
	}
	 public List<UserResponseDTO> getAllUsers() {
	       List<User> users = userRepository.findAllByOrderByIdAsc();
	       List<UserResponseDTO> userResponseDTOs = new ArrayList<>(); 
	       for (User user : users) {
	           UserResponseDTO dto = UserResponseDTO.builder()
	        		   .id(user.getId())
	        		   .firstName(user.getFirstName())
	        		   .lastName(user.getLastName())
	        		   .email(user.getEmail())
	        		   .created_by(user.getCreated_by())
	        		   .created_on(user.getCreated_on())
	        		   .role(user.getRole().getName())
	        		   .build();
	           userResponseDTOs.add(dto);
	       }
	       return userResponseDTOs; 
	   }

	 public List<UserResponseDTO> getUserDetails(String email)
	 {
	 	Optional<User> userOptional=userRepository.findByEmail(email);
	 	List<UserResponseDTO> userResponseDTO=new ArrayList<UserResponseDTO>();
	 	if(userOptional.isPresent())
	 	{
	 		User user=userOptional.get();
	 		UserResponseDTO dto=UserResponseDTO.builder()
	 				.firstName(user.getFirstName())
	 				.lastName(user.getLastName())
	 				.email(user.getEmail())
	 				.role(user.getRole().getName())
	 				.build();
	 		userResponseDTO.add(dto);
	 	}
	 	//System.out.print("bjhfnbjkhjhkjhjjsd"+userOptional);
	 	return userResponseDTO;
	 }
	public Long usersActiveCount() {
		Long count=userRepository.getUsersActiveCount();
		return count;
		
	}
	 
	public Long usersInActiveCount() {
		Long count=userRepository.getUsersInActiveCount();
		return count;	
	} 
	  
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	public void deleteUser(UUID id) {
		if(!userRepository.existsById(id)) {
			throw new RuntimeException("User Not Found");
		}
		else {
			userRepository.deleteById(id);
		}
	}
	public User updateUser(UUID userId, UserRequestDTO userRequestDTO) {
	    User existingUser = userRepository.findById(userId).orElse(null); // Assuming you have a repository

	    if (existingUser != null) {
	        existingUser.setFirstName(userRequestDTO.getFirstName());
	        existingUser.setLastName(userRequestDTO.getLastName());
	        existingUser.setEmail(userRequestDTO.getEmail());
	        
	        // Save updated entity
	        return userRepository.save(existingUser);
	    }
	    
	    return null; // Return null if the user was not found
	}

	
	
	
	
	
	
	
	
	  }







