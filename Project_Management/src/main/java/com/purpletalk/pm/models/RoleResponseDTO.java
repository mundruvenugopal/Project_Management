package com.purpletalk.pm.models;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor 
public class RoleResponseDTO {
	private int id;
	private String Name;
	private LocalDateTime created_on; 
	private UUID created_by;
	private LocalDateTime modified_on; 
	private UUID modified_by;
}





