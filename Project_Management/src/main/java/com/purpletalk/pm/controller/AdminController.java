package com.purpletalk.pm.controller;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.purpletalk.pm.entity.User;
import com.purpletalk.pm.models.UserRequestDTO;
import com.purpletalk.pm.repository.UserRepository;
import com.purpletalk.pm.service.AdminService;
@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class AdminController {
	@Autowired
	private AdminService adminservice;
	@Autowired
	private UserRepository userRepository;
	 @PostMapping("/adminlogin")
	   public ResponseEntity<?> login(@RequestBody UserRequestDTO userRequestDTO) {
	       boolean isAuthenticated = adminservice.authenticate(userRequestDTO.getEmail(), userRequestDTO.getPassword());
	       Map<String, String> response = new HashMap<>();
	       if (!isAuthenticated) {
	           response.put("message", "Invalid email or password.");
	          // return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
	           return ResponseEntity.badRequest().body(response);
	       } else {
	        //   response.put("message", "Login successful!");
			/*
			 * Optional<User> user= userRepository.findByEmail(userRequestDTO.getEmail());
			 * // System.out.print(user); String userrole = user.get().getRole().getName();
			 * // System.out.println(userrole+"rtfyugiopuytrdfghytdcgfhytfgchjytrdgfch");
			 * return ResponseEntity.ok(userrole);
			 */
	    	   Optional<User> user = userRepository.findByEmail(userRequestDTO.getEmail());
	    	   if (user.isPresent()) {
	    	       String userRole = user.get().getRole().getName();
	    	  
	    	       response.put("role", userRole);
	    	   
	    	       return ResponseEntity.ok(response);
	    	   } else {
	    	      
	    	       return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
	    	   }

	          }   
	       }
	   }




