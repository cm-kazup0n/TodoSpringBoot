package com.kamakuni.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.boot.context.properties.ConstructorBinding;

import com.kamakuni.entity.Todo;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class TodoForm {
	
	public static TodoForm create(Long id, String title, Boolean done) {
		return new TodoForm(id, title, done);
	}
	@NotNull
	private Long id;
	@NotBlank(message = "name is required")
	@Size(max=100)
	private String title;
	@NotNull
	private Boolean done = false;
	
	public Todo toTodo() {
		return new Todo(this.title, this.done);
	}
}
