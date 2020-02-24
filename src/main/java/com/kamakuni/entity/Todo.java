package com.kamakuni.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Entity
@Getter
@NoArgsConstructor
public class Todo extends BaseEntity {
		
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private Boolean done;

}
