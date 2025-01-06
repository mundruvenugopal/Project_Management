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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.purpletalk.pm.entity.Project;
import com.purpletalk.pm.entity.User;
import com.purpletalk.pm.models.ProjectRequestDTO;
import com.purpletalk.pm.models.ProjectResponseDTO;
import com.purpletalk.pm.service.ProjectService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/project")
@CrossOrigin(origins="*")
public class ProjectController {
	@Autowired
	private ProjectService projectService;
	@PostMapping("/saveProject")
	public ResponseEntity<String> saveProject(@Valid @RequestBody ProjectRequestDTO projectrequestdto,BindingResult bindingresult){	
		if(bindingresult.hasErrors()) {
			return ResponseEntity.badRequest().body("validation error occur");
		}
		projectService.saveproject(projectrequestdto);
		return ResponseEntity.status(HttpStatus.CREATED).body("Project Created Successfully");
	}
	/*
	 * @GetMapping("/allProjects") public ResponseEntity<List<Project>>
	 * getprojects(){ List<Project> projects=projectService.getAllProjects();
	 * System.out.print(projects); return ResponseEntity.ok(projects); }
	 */
	   @GetMapping("/getAllProjects")
	   public ResponseEntity<List<ProjectResponseDTO>> getAllProjects() {
	       List<ProjectResponseDTO> projects = projectService.getAllProjects();	       
	       if (projects.isEmpty()) {
	           return ResponseEntity.noContent().build(); 
	       }     
	       return ResponseEntity.ok(projects);
	   }  
	   @GetMapping("/allProjects")
		public ResponseEntity<List<Project>> getProjects() {
			List<Project> Projects = projectService.getProjects();
			System.out.print(Projects);
			return ResponseEntity.ok(Projects);
		}
	   @GetMapping("/projectsActiveCount")
		public ResponseEntity<Long> getProjectsActiveCount() {
			Long ActiveCount = projectService.projectsActiveCount();
			return ResponseEntity.ok(ActiveCount);
		}
	  @GetMapping("/projectsInActiveCount")
	  public ResponseEntity<Long> getProjectsInActiveCount(){
		  Long InActiveCount=projectService.projectsInActiveCount();
		  System.out.print("inActiveCount"+InActiveCount);
		  return ResponseEntity.ok(InActiveCount);
	  }  
	  @GetMapping("/getUserProjectDetails")
	  public ResponseEntity<List<Project>> getUserProjectDetails(@RequestParam String email){
		  List<Project> project=projectService.getProjectsByUserEmail(email);
		  return ResponseEntity.ok(project);
	  }
}
