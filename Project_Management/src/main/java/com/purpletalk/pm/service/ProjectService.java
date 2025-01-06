package com.purpletalk.pm.service;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.purpletalk.pm.entity.Project;
import com.purpletalk.pm.entity.Project_User;
import com.purpletalk.pm.entity.User;
import com.purpletalk.pm.models.ProjectRequestDTO;
import com.purpletalk.pm.models.ProjectResponseDTO;
import com.purpletalk.pm.repository.ProjectRepository;
import com.purpletalk.pm.repository.ProjectUserRepository;
import com.purpletalk.pm.repository.UserRepository;
@Service
public class ProjectService {
	@Autowired
    private ProjectUserRepository projectUserRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProjectRepository projectrepository;
public void saveproject(ProjectRequestDTO projectrequestdto)
{
	Project project =new Project();
	project.setTitle(projectrequestdto.getTitle());
	project.set_active(projectrequestdto.is_active());
	project.setCreated_on(projectrequestdto.getCreated_on());
	project.setModified_on(projectrequestdto.getModified_on());
	project.setStart_date(projectrequestdto.getStart_date());
	project.setEnd_date(projectrequestdto.getEnd_date());
	projectrepository.save(project);
}
/*
 * public List<Project> getAllProjects(){ return projectrepository.findAll(); }
 */
public Long projectsActiveCount() {
	Long count=projectrepository.getProjectsActiveCount();
	return count;	
}

public Long projectsInActiveCount() {
	Long count=projectrepository.getProjectsInActiveCount();
	return count;
}
public List<ProjectResponseDTO> getAllProjects() {
    List<Project> projects = projectrepository.findAllByOrderByIdAsc();
    List<ProjectResponseDTO> projectResponseDTOs = new ArrayList<>(); 
    for (Project project : projects) {
        ProjectResponseDTO dto = ProjectResponseDTO.builder()
        		.title(project.getTitle())
        		.end_date(project.getEnd_date())
        		.start_date(project.getStart_date())	   
     		   .build();
        projectResponseDTOs.add(dto)   ;      
    }
    return  projectResponseDTOs;
}
public List<Project> getProjectsForUser(UUID userId) {
    List<Project_User> projectUsers = projectUserRepository.findByUserId(userId);
    List<Project> projects = new ArrayList<>(); 
    for (Project_User projectUser : projectUsers) {
        projects.add(projectUser.getProject()); 
    }

    return projects;
    //return projectUsers.stream()
          //  .map(Project_User::getProject)
           // .toList();
}
public List<Project> getProjectsByUserEmail(String email) {
    User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found"));
    return getProjectsForUser(user.getId());
}
public List<Project> getProjects(){
	return projectrepository.findAll();
}
}
