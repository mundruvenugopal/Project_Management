package com.purpletalk.pm.models;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class ProjectResponseDTO {
	private UUID id;
	private String title;
	private LocalDateTime start_date;
	private LocalDateTime end_date;
	private boolean is_active;
	private LocalDateTime created_on;
	private UUID created_by;
	private LocalDateTime modified_on;
	private UUID modified_by;
}






