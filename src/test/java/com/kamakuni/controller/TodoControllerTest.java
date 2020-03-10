package com.kamakuni.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.kamakuni.service.TodoService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TodoController.class)
public class TodoControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private TodoService todoService;
	
	@Test
	@WithMockUser
	public void shouldReturnTodoView() throws Exception {
		this.mockMvc.perform(get("/todos"))
			.andExpect(view().name("todos/index"))
			.andExpect(status().isOk());
	}

	@Test
	@WithMockUser
	public void shouldReturnNewView() throws Exception {
		this.mockMvc.perform(get("/todos/new"))
			.andExpect(view().name("todos/new"))
			.andExpect(status().isOk());
	}

	
}
