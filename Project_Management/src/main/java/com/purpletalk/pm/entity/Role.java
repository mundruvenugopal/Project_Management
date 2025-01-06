package com.purpletalk.pm.entity;
import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name="Role")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	private String name; 
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






