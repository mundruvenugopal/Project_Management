package com.purpletalk.pm.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.purpletalk.pm.entity.Role;
import com.purpletalk.pm.models.RoleRequestDTO;
import com.purpletalk.pm.service.RoleService;
import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/role")
@CrossOrigin(origins = "*") 
public class RoleController {
	 @Autowired
	   private RoleService roleservice;
	   @PostMapping("/saveRole")
	   public ResponseEntity<String> saveRole(
	           @Valid @RequestBody RoleRequestDTO rolerequestdto,
	           BindingResult bindingResult) {
	       if (bindingResult.hasErrors()) {
	           return ResponseEntity.badRequest().body("Validation errors occurred.");
	       }
	       roleservice.saveRole(rolerequestdto);
	       return ResponseEntity.status(HttpStatus.CREATED).body("Role created successfully.");
	   }
	   @GetMapping("/allRoles")
	   public ResponseEntity<List<Role>> getAllRoles() {
	       List<Role> roles = roleservice.getAllRoles();
	       return ResponseEntity.ok(roles);
	   }
}
