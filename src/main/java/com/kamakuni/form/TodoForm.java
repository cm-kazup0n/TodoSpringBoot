package com.kamakuni.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.boot.context.properties.ConstructorBinding;

import com.kamakuni.entity.Todo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TodoForm {
		
	private Long id;
	@NotBlank(message = "name is required")
	@Size(max=100)
	private String title;
	@NotNull
	private Boolean done = false;
	
	public Todo toTodo() {
		return new Todo(this.id, this.title, this.done);
	}
	
}
