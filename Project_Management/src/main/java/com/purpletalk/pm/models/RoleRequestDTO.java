package com.purpletalk.pm.models;
import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class RoleRequestDTO {
	private int id;
	@NotNull(message = "is required")
	@Size(min=1,max=20,message = "is required")
	private String Name;
	private LocalDateTime created_on; 
	private UUID created_by;	
	private LocalDateTime modified_on; 
	private UUID modified_by;
}




