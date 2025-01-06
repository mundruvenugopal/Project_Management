package com.purpletalk.pm.models;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class UserResponseDTO {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String is_active;
    private LocalDateTime created_on; 
    private UUID created_by;
    private LocalDateTime modified_on; 
    private UUID modified_by;
    private String role;
}






