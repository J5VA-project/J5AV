package com.J5VA.controller.user;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.J5VA.entity.Account;
import com.J5VA.entity.Comment;
import com.J5VA.entity.Food;
import com.J5VA.service.AccountService;
import com.J5VA.service.CommentService;
import com.J5VA.service.FoodService;

@Controller
@RequestMapping("/home/comment")
public class CommentController {
	@Autowired
	CommentService commentservice;
	@Autowired
	HttpServletRequest request;
	@Autowired
	FoodService foodService;
	@Autowired
	AccountService accountService;

	@GetMapping("/add")
	public String add() {
		Integer food_id = Integer.parseInt(request.getParameter("food_id"));
		String username = request.getRemoteUser();
		String content = request.getParameter("content");

		Food food = foodService.findById(food_id);
		Account account = accountService.findByUsername(username);

		Comment comment = new Comment();
		comment.setComment_account(account);
		comment.setComment_food(food);
		comment.setContent(content);
		comment.setCreatedate(new Date());

		commentservice.create(comment);

		return "redirect:/home/shop-details/" + food_id;
	}
}
