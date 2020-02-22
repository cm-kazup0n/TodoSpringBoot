package com.kamakuni.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;
	
	@Column(nullable = false)
	private Date createAt;

	@Column(nullable = false)
	private Date updateAt;
	
	@PrePersist
	public void onPrePersist() {
		setCreateAt(new Date());
		setUpdateAt(new Date());
	}
	
	@PreUpdate
	public void onPreUpdate( ) {
		setUpdateAt(new Date());
	}
}
