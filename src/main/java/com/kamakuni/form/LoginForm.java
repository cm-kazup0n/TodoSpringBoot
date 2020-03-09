package com.kamakuni.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginForm {
	
	@NotBlank(message = "email is required")
	@Size(max=100)
	private String email;

	@NotBlank(message = "password is required")
	@Size(max=100)
	private String password;
	
}
