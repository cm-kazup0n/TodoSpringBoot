package com.kamakuni.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class TodoForm {

	@NotBlank(message = "name is required")
	@Size(max=100)
	private String name;
	@NotNull
	private Boolean done = true;
	
}
