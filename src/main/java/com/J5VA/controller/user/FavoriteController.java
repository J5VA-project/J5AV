import java.util.List;

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
@RequestMapping("/home/favorite")
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
//		Favorite favorite = new Favorite();
//		Account account = accountService.findById(request.getRemoteUser());
//		
//		try {
//			Favorite check = service.findFavoriteByFood(id);
//		} catch (Exception e) {
//			Food food = foodService.findById(id);
//			favorite.setFavorite_acc(account);
//			favorite.setFavorite_f(food);
//			try {
//				service.create(favorite);
//			} catch (Exception ez) {
//				ez.printStackTrace();
//			}
//			e.printStackTrace();
//		}
		try {
			service.create(favorite);
		} catch (Exception e) {







			Account account = accountService.findByUsername(request.getRemoteUser());
			List<Favorite> favorite = service.findAllByAccount(account);

			boolean check = false;
			for (int i = 0; i < favorite.size(); i++) {
				if (id.equals(favorite.get(i).getFavorite_f().getFood_id())) {
					check = false;
					System.out.println("trung");
					break;
				} else {
					check = true;
					System.out.println("Ko Trung");
				}
			}
			System.out.println(id);
			System.out.print(check);
			if (check == true) {
				Favorite favorite1 = new Favorite();
				Food food = foodService.findById(id);
				favorite1.setFavorite_acc(account);
				favorite1.setFavorite_f(food);
				try {
					service.create(favorite1);
				} catch (Exception ez) {
					ez.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		return "redirect:/home";
		return "redirect:/home/favorite/list";
	}

	@GetMapping("/list")
	public String list(Model model) {
		Favorite favorite = service.findByIdCustomer(request.getRemoteUser());
		model.addAttribute("favorite", favorite);
		try {
			Account account = accountService.findByUsername(request.getRemoteUser());
			List<Favorite> favorite = service.findAllByAccount(account);
			model.addAttribute("favorite", favorite);
		} catch (Exception e) {
			model.addAttribute("favorite", new Favorite());
		}
		return "user/body/wishlist";
	}

	@GetMapping("/delete/{id}")
	public String deleteFavorite(Model model, @PathVariable("id") String id) {
		Integer id1 = Integer.parseInt(id);
		service.deleteById(id1);
		return "redirect:/home/favorite/list";
	}
}
