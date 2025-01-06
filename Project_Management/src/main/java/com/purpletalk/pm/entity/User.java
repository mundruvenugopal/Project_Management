package com.purpletalk.pm.entity;
import java.time.LocalDateTime;
import java.util.UUID;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Getter
@Data
@Table(name="\"user\"")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
@OneToOne 
   @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false) 
    private Role role;
	private boolean is_active;
	private LocalDateTime created_on; 
	private UUID created_by;
	private LocalDateTime modified_on; 
	private UUID modified_by;
	@PrePersist
    public void prePersist() {
        this.created_on = LocalDateTime.now();
        this.created_by = UUID.randomUUID(); 
    }
    @PreUpdate
    public void preUpdate() {
        this.modified_on = LocalDateTime.now();
        this.modified_by = UUID.randomUUID();
    }
}




