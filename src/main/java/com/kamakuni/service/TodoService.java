package com.kamakuni.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kamakuni.entity.Todo;
import com.kamakuni.repository.TodoRepository;

@Service
public class TodoService {
	
	@Autowired
	private TodoRepository repository;
	
	public Optional<Todo> findOne(Long id){
		return repository.findById(id);
	}
	
	public List<Todo> findAll(){
		return repository.findAll();
	}
}
