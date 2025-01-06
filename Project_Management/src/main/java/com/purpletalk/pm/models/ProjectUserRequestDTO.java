package com.purpletalk.pm.models;
import java.time.LocalDateTime;
import lombok.Data;
@Data
public class ProjectUserRequestDTO {
	  private String project_id; 
	  private String user_id; 
		/*
		 * private String project_id; // Expecting UUID as a string private String
		 * user_id;
		 */
	private boolean is_active;
	private LocalDateTime created_on;
	/*
	 * public UUID getProjectIdAsUUID() { return UUID.fromString(this.project_id); }
	 * 
	 * public UUID getUserIdAsUUID() { return UUID.fromString(this.user_id); }
	 */
}
