package com.purpletalk.pm.service;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.purpletalk.pm.entity.Project;
import com.purpletalk.pm.entity.Project_User;
import com.purpletalk.pm.entity.User;
import com.purpletalk.pm.models.ProjectUserRequestDTO;
import com.purpletalk.pm.repository.ProjectRepository;
import com.purpletalk.pm.repository.ProjectUserRepository;
import com.purpletalk.pm.repository.UserRepository;
@Service
public class ProjectUserService {
@Autowired
private ProjectUserRepository projectuserrepository;
@Autowired
private ProjectRepository projectrepository;
@Autowired
private UserRepository userrepository;
public void saveProjectUser(ProjectUserRequestDTO projectuserrequestdto) {
	Project_User project_user=new Project_User();
		// Optional<Project>project=projectrepository.findById(projectuserrequestdto.getProject_id()); 
		// project_user.setProject(project.get());
			/*
			 * Optional<User>user=userrepository.findById(projectuserrequestdto.getUser_id()
			 * ); project_user.setUser(user.get());
			 */
			
			// Optional<User>user=userrepository.findById(projectuserrequestdto.getUser_id() );
			// project_user.setUser(user.get());
	UUID projectId = UUID.fromString(projectuserrequestdto.getProject_id());
    UUID userId = UUID.fromString(projectuserrequestdto.getUser_id());
    Optional<Project> projectOpt = projectrepository.findById(projectId);
    if (!projectOpt.isPresent()) {
        throw new RuntimeException("Project not found with ID: " + projectId);
    }
    project_user.setProject(projectOpt.get());
   // UUID userId = projectuserrequestdto.getUser_id();
    Optional<User> userOpt = userrepository.findById(userId);
    if (!userOpt.isPresent()) {
        throw new RuntimeException("User not found with ID: " + userId);
    }
    project_user.setUser(userOpt.get());		 
    project_user.set_active(projectuserrequestdto.is_active());
		 projectuserrepository.save(project_user);
}
}
