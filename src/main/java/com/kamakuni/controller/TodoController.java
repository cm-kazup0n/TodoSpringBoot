package com.kamakuni.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kamakuni.entity.Todo;
import com.kamakuni.form.TodoForm;
import com.kamakuni.service.TodoService;

// https://qiita.com/ozaki25/items/3b348874b6db5ab4f04f
// https://qiita.com/opengl-8080/items/eb3bf3b5301bae398cc2

@Controller
@RequestMapping("/todos")
public class TodoController {
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private TodoService todoService;
	
	@GetMapping
	public String index(Model model) {
		List<Todo> todos = todoService.findAll();
		model.addAttribute("todos", todos);
		return "todos/index";
	}

	@GetMapping("{id}")
	public String show(@PathVariable Optional<Long> idOpt) {
		// TODO: error handling when item not found
		Todo todo = idOpt.flatMap(id -> todoService.findOne(id)).orElse(new Todo());
		return "todos/index";
	}

	@PutMapping("{id}")
	public ModelAndView update(@PathVariable("id") Optional<Long> idOpt,@Validated @ModelAttribute Optional<TodoForm> todoFormOpt, BindingResult bindingResult, ModelAndView mav, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			todoFormOpt.map(form -> mav.addObject("todoForm", form));
			mav.addObject("errorMessage", messageSource.getMessage("error.todo.edit", null, null));
			mav.setViewName("todos/edit");
			return mav;
		}
		// TODO: error handling when item not found
		Todo todo = idOpt.flatMap(id -> todoService.findOne(id)).orElse(new Todo());
		todoFormOpt.map(form -> todoService.save(todo.merge(form.getTitle(),form.getDone()))).orElseThrow(() -> new RuntimeException("Resource not found."));
		mav.setViewName("redirect:/todos");
		redirectAttributes.addFlashAttribute("infoMessage", messageSource.getMessage("success.todo.edit", null, null));
		return mav;
	}
	
	@DeleteMapping("{id}")
	public String destory(@PathVariable("id") Optional<Long> idOpt, RedirectAttributes redirectAttributes) {
		idOpt.ifPresent(id -> todoService.deleteById(id));
		redirectAttributes.addFlashAttribute("infoMessage", messageSource.getMessage("success.todo.delete", null, null));
		return "redirect:/todos";
	}
	
	@PostMapping
	public String create(@Validated @ModelAttribute TodoForm todoForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			// TODO:Flash error message
			redirectAttributes.addFlashAttribute("errorMessage", messageSource.getMessage("error.todo.create", null, null));
			return "redirect:todos/new";
		}
		todoService.save(todoForm.toTodo());
		redirectAttributes.addFlashAttribute("infoMessage", messageSource.getMessage("success.todo.create", null, null));
		return "redirect:todos/";
	}
	
	@GetMapping("new")
	public String newTodo(@ModelAttribute TodoForm todoForm) {
		return "todos/new";
	}
	
	@GetMapping("{id}/edit")
	public ModelAndView edit(@PathVariable("id") Optional<Long> idOpt, ModelAndView mav) {
		Todo todo = idOpt.flatMap(id -> todoService.findOne(id)).orElse(new Todo());
		mav.addObject("todoForm", TodoForm.create(todo.getId(), todo.getTitle(), todo.getDone()));
		mav.setViewName("todos/edit");
		return mav;
	}

	@GetMapping("{id}/delete")
	public ModelAndView delete(@PathVariable("id") Optional<Long> idOpt, ModelAndView mav) {
		Todo todo = idOpt.flatMap(id -> todoService.findOne(id)).orElse(new Todo());
		mav.addObject("todoForm", TodoForm.create(todo.getId(), todo.getTitle(), todo.getDone()));
		mav.setViewName("todos/delete");
		return mav;
	}
	
	
}
