package com.J5VA.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.J5VA.entity.Comment;
import com.J5VA.entity.Food;
import com.J5VA.entity.FoodRate;
import com.J5VA.service.CommentService;
import com.J5VA.service.FavoriteService;
import com.J5VA.service.FoodService;

@Controller
@RequestMapping("/home")
public class DetailProductController {
	@Autowired
	FoodService fdao;
	@Autowired
	FavoriteService favoriteService;
	@Autowired
	CommentService commentService;

	@GetMapping("/shop-details/{id}")
	public String runControll(@PathVariable("id") Integer id, Model model) {
		Food food = fdao.findById(id);
		model.addAttribute("food", food);

		Integer star;
		Integer number = null;
		List<FoodRate> foodRates = favoriteService.getListFoodRates();
		if (id.equals(foodRates.get(0).getFood_id_rate())) {
			star = 5;
			number = foodRates.get(0).getCount().intValue();
		} else if (id.equals(foodRates.get(1).getFood_id_rate())) {
			star = 4;
			number = foodRates.get(1).getCount().intValue();
		} else if (id.equals(foodRates.get(2).getFood_id_rate())) {
			star = 3;
			number = foodRates.get(2).getCount().intValue();
		} else if (id.equals(foodRates.get(3).getFood_id_rate())) {
			star = 2;
			number = foodRates.get(3).getCount().intValue();
		} else {
			star = 1;
			for (int i = 0; i < foodRates.size(); i++) {
				if (id.equals(foodRates.get(i).getFood_id_rate())) {
					Long a = foodRates.get(i).getCount();
					if (a == null) {
						number = 0;
					} else {
						number = foodRates.get(i).getCount().intValue();
					}
				}
			}
		}
		model.addAttribute("star", star);
		model.addAttribute("number", number);

		List<Comment> listComments = commentService.getCommentsByFoodId(id);
		model.addAttribute("comments", listComments);
		model.addAttribute("count", listComments.size());
		return "user/body/shop-details";
	}
}
