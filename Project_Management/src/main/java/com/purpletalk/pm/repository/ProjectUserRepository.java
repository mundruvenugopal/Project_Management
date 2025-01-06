package com.purpletalk.pm.repository;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.purpletalk.pm.entity.Project_User;
public interface ProjectUserRepository extends JpaRepository<Project_User,UUID>{
List<Project_User> findByUserId(UUID userId);
	////  Optional<Project_User> findById(UUID id);
}