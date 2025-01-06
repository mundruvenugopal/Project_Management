package com.purpletalk.pm.entity;
import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Builder
@Table(name="project")
public class Project {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private UUID id;
	private String title;
	private LocalDateTime start_date;
	private LocalDateTime end_date;
	private boolean is_active;
	private LocalDateTime created_on;
	private UUID created_by;
	private LocalDateTime modified_on;
	private UUID modified_by;
	@PrePersist
	public void prepersist() {
		this.start_date=LocalDateTime.now();
		this.created_on=LocalDateTime.now();
		this.created_by=UUID.randomUUID();
	}	
	@PostPersist
	public void postpersist() {
		this.end_date=LocalDateTime.now();
		this.modified_on=LocalDateTime.now();
		this.modified_by=UUID.randomUUID();
	}

}
