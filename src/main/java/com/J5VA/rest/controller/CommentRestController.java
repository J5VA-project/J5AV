package com.J5VA.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.J5VA.entity.Comment;
import com.J5VA.service.CommentService;

@RestController
@RequestMapping("/rest/comment")
public class CommentRestController {
	@Autowired
	CommentService service;

	@GetMapping("/getCommentsByFoodId/{id}")
	public List<Comment> getCommentsByFoodId(@PathVariable Integer id) {
		return service.getCommentsByFoodId(id);
	}
}
