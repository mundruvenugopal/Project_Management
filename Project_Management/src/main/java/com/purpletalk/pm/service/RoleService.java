package com.purpletalk.pm.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purpletalk.pm.entity.Role;
import com.purpletalk.pm.models.RoleRequestDTO;
import com.purpletalk.pm.repository.RoleRepository;
@Service
public class RoleService {
	 @Autowired
	    private RoleRepository rolerepository; 
	    public void saveRole(RoleRequestDTO rolerequestdto) {
	        Role role = new Role();
	        role.setName(rolerequestdto.getName());
	        role.setCreated_on(rolerequestdto.getCreated_on());
	        role.setModified_on(rolerequestdto.getModified_on());
	        rolerepository.save(role);   
	    }
	    public List<Role> getAllRoles() {
	        return rolerepository.findAll();
	    }

}








