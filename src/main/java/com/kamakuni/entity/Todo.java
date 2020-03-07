package com.kamakuni.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Todo extends BaseEntity {
	
	public Todo() {};
	public Todo(Todo todo) {
		this.id = todo.getId();
		this.title = todo.getTitle();
		this.done = todo.getDone();
		this.createAt = todo.getCreateAt();
		this.updateAt = todo.getUpdateAt();
	}
	public Todo(Long id, String title, Boolean done) {
		this.id = id;
		this.title = title;
		this.done = done;
	}

	public Todo(Long id, String title, Boolean done, Date createAt, Date updateAt) {
		this.id = id;
		this.title = title;
		this.done = done;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private Boolean done;
	
	public Todo merge(String title, Boolean Done) {
		Todo clone = new Todo(this);
		clone.setTitle(title);
		clone.setDone(done);
		return clone;
	}
		
}
