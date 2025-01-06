package com.purpletalk.pm.entity;
import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Getter
@ToString
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Project_User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private UUID id;
	@OneToOne
	@JoinColumn(name="project_id",referencedColumnName="id",nullable=false)
	private Project project;
	@OneToOne
	@JoinColumn(name="user_id",referencedColumnName="id",nullable=false)
	private User user;
	private boolean is_active;
	private LocalDateTime created_on;
	private UUID created_by;
	private LocalDateTime modified_on;
	private UUID modified_by;
	@PrePersist
	public void prepersist() {
		this.created_on=LocalDateTime.now();
		this.created_by=UUID.randomUUID();
	}
	@PostPersist
	public void postpersist() {
		this.modified_on=LocalDateTime.now();
		this.modified_by=UUID.randomUUID();
}
}
