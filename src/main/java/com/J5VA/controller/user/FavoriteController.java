package com.J5VA.controller.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.J5VA.entity.Account;
import com.J5VA.entity.Favorite;
import com.J5VA.entity.Food;
import com.J5VA.service.AccountService;
import com.J5VA.service.FavoriteService;
import com.J5VA.service.FoodService;

@Controller
@RequestMapping("/favorite")
public class FavoriteController {
	@Autowired
	FavoriteService service;
	@Autowired
	AccountService accountService;
	@Autowired
	HttpServletRequest request;
	@Autowired
	FoodService foodService;

	@GetMapping("/{id}")
	public String add(@PathVariable("id") Integer id) {
		System.out.println(id);
		Favorite favorite = new Favorite();
		Account account = accountService.findById(request.getRemoteUser());
		Food food = foodService.findById(id);
		favorite.setFavorite_acc(account);
		favorite.setFavorite_f(food);
		try {
			service.create(favorite);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/home";
	}

	@GetMapping("/list")
	public String list(Model model) {
		Favorite favorite = service.findByIdCustomer(request.getRemoteUser());
		model.addAttribute("favorite", favorite);
		return "user/body/wishlist";
	}
}
