package com.kamakuni.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.boot.context.properties.ConstructorBinding;

import com.kamakuni.entity.Todo;

import lombok.Data;

@Data
public class TodoForm {

	@NotBlank(message = "name is required")
	@Size(max=100)
	private String title;
	@NotNull
	private Boolean done = true;
	
	public Todo toTodo() {
		return new Todo(this.title);
	}
}
