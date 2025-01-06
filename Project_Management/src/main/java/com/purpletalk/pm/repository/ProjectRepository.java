package com.purpletalk.pm.repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.purpletalk.pm.entity.Project;
public interface ProjectRepository extends JpaRepository<Project,UUID>{
	Optional<Project> findById(UUID project_id);
	List<Project> findAllByOrderByIdAsc();
	//Optional<Project> findById(String project_id);
	  @Query("SELECT count(*) FROM Project where is_active=true") 
	  Long getProjectsActiveCount();
	
	@Query("SELECT count(*) FROM Project where is_active=false")
	Long getProjectsInActiveCount();

}
