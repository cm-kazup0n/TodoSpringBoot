package com.kamakuni.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;

@Getter
@Entity
public class Todo extends BaseEntity {
		
	@Column(nullable = false)
	private String name;

}
