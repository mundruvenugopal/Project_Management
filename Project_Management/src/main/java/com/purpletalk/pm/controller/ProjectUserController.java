package com.purpletalk.pm.controller;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.purpletalk.pm.models.ProjectUserRequestDTO;
import com.purpletalk.pm.service.ProjectUserService;
import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/projectuser")
@CrossOrigin(origins="*")
public class ProjectUserController {
	@Autowired
	private ProjectUserService projectuserservice;
@PostMapping("/saveProjectUser")
public ResponseEntity<?> saveProject(@Valid @RequestBody ProjectUserRequestDTO projectuserrequestdto,BindingResult bindingresult) {
	 Map<String,String> response=new HashMap<>();
     if (bindingresult.hasErrors()) {
  	 //  response.put("message", "Validation error occurred.");
  	   Map<String, String> errorMessages = new HashMap<>();
  	   bindingresult.getFieldErrors().forEach(error -> {
              errorMessages.put(error.getField(), error.getDefaultMessage());
          });
         return ResponseEntity.badRequest().body(errorMessages);
     }
    // System.out.print(projectuserrequestdto);
     projectuserservice.saveProjectUser(projectuserrequestdto);
     response.put("message", "Project User Created Successfully...");
     return ResponseEntity.status(HttpStatus.CREATED).body(response);	
}

}
