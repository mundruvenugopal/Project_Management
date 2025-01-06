package com.purpletalk.pm.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.purpletalk.pm.entity.User;
import com.purpletalk.pm.repository.UserRepository;
@Service
public class AdminService {
	@Autowired
	private UserRepository userRepository;
	public boolean authenticate(String email, String password) {
		Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return user.getPassword().equals(password);
        }
        
        return false;
    } 

}
