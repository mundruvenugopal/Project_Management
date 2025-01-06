package com.purpletalk.pm.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.purpletalk.pm.entity.User;
import com.purpletalk.pm.models.UserRequestDTO;
import com.purpletalk.pm.models.UserResponseDTO;
import com.purpletalk.pm.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController {
	@Autowired
	private UserService userservice;
	@PostMapping("/saveUser")
	public ResponseEntity<?> saveUser(@Valid @RequestBody UserRequestDTO userrequestdto, BindingResult bindingResult) {
		Map<String, String> response = new HashMap<>();
		if (bindingResult.hasErrors()) {
			// response.put("message", "Validation error occurred.");
			Map<String, String> errorMessages = new HashMap<>();
			bindingResult.getFieldErrors().forEach(error -> {
				errorMessages.put(error.getField(), error.getDefaultMessage());
			});
			return ResponseEntity.badRequest().body(errorMessages);
		}
		userservice.saveUser(userrequestdto);
		response.put("message", "User Created Successfully...");
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping("/getAllUsers")
	public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
		List<UserResponseDTO> users = userservice.getAllUsers();
		if (users.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(users);
	}
	@GetMapping("/getUserDetails")
	public ResponseEntity<List<UserResponseDTO>> getUserDetails(@RequestParam String email) {
		List<UserResponseDTO> user = userservice.getUserDetails(email);
		if (user.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		for (int i = 0; i < user.size(); i++) {
			System.out.println("jhadjh");
			System.out.println(user.get(i));
		}
		return ResponseEntity.ok(user);
	}

	@GetMapping("/usersActiveCount")
	public ResponseEntity<Long> getUsersActiveCount() {
		Long ActiveCount = userservice.usersActiveCount();
		return ResponseEntity.ok(ActiveCount);
	}
	@GetMapping("/usersInActiveCount")
	public ResponseEntity<Long> getUsersInActiveCount() {
		Long InActiveCount = userservice.usersInActiveCount();
		return ResponseEntity.ok(InActiveCount);
	}
	@GetMapping("/allUsers")
	public ResponseEntity<List<User>> getusers() {
		List<User> users = userservice.getUsers();
		return ResponseEntity.ok(users);
	}
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable UUID userId) {
		System.out.println("Received request to delete user with ID: " + userId);
		Map<String, String> response = new HashMap<>();
		try {
			userservice.deleteUser(userId);
			response.put("message", "User deleted successfully.");
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			response.put("message", "Error deleting user: " + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}
	@PutMapping("/update/{userId}")
	public ResponseEntity<?> updateUser(@PathVariable UUID userId, @RequestBody UserRequestDTO userrequestdto) {
		System.out.println("Received request to update user with ID: " + userId);
		Map<String, String> response = new HashMap<>();
		try {
			userservice.updateUser(userId, userrequestdto);
			response.put("message", "User updated successfully.");
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			response.put("message", "Error updating user: " + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);

		}
	}
	/*
	 * @GetMapping("/") public void getAllUsers() { List<User> users =
	 * userrepository.findAll();
	 */
//		       List<UserResponseDTO> userResponseDTOs = new ArrayList<>(); 
//		       for (User user : users) {
//		           UserResponseDTO dto = UserResponseDTO.builder()
//		                   .id(user.getId())
//		                   .firstName(user.getFirstName())
//		                   .lastName(user.getLastName())
//		                   .email(user.getEmail())
//		                   .phNo(student.getPhNo())
//		                   .build();
//		           studentResponseDTOs.add(dto);
//		       }
	// System.out.println(users);
	// System.out.print("wrfhj");
	/*
	 * for(int i=0;i<users.size();i++) { System.out.println(users.get(i));
	 * 
	 * }
	 */
//}
}
