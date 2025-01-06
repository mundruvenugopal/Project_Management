package com.purpletalk.pm.models;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class UserRequestDTO { 
   // @NotNull(message = "First name is required")  
	@Size(min=1,max=20,message = " Please ensure that the length of the first name is greater than 1 character and less than 20 characters.")
    @NotBlank(message = "First name cannot be blank")
    private String firstName;
    //@NotNull(message = "Last name is required")
    @Size(min=1,max=20,message = " Please ensure that the length of the last name is greater than 1 character and less than 20 characters.")
    @NotBlank(message = "Last name cannot be blank")
    private String lastName;
    @Email(message = "Please enter a valid email Id")
	///@NotNull(message = "Email cannot be NULL")
	@Size(min=2,max=25,message = "Email cannot be NULL")
    private String email;
  ///  @NotNull(message = "Password is required")
    @Size(min=1,max=10,message = " Please ensure that the length of the password is greater than 1 character and less than 20 characters.")
    @NotBlank(message = "Password cannot be blank")
    private String password;
   // @NotNull(message = "Role ID is required")
   // @NotBlank(message = "Role ID cannot be blank")
    private int roleId; 
    private boolean is_active;
}






