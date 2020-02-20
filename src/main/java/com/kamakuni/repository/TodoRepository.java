package com.kamakuni.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kamakuni.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo,Long>{
}
