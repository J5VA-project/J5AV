package com.J5VA.controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.J5VA.entity.Account;
import com.J5VA.entity.Authorized;
import com.J5VA.service.UserService;
import com.J5VA.service.AccountService;

@Controller
public class LoginController {
	@Autowired
	HttpServletRequest request;

	@Autowired
	AccountService service;

	@GetMapping("/auth/login/form")
	public String login(Model model) {
		Account acc = new Account();
		model.addAttribute("acc", acc);
		return "user/body/login";
	}

	@RequestMapping("/auth/login/success")
	public String success(Model model) {
		model.addAttribute("message", "Login success");
		model.addAttribute("user", new Account());

		Account account = service.findById(request.getRemoteUser());
		List<Authorized> authorizeds = account.getAuthorities();
		for (Authorized p : authorizeds) {
			if (p.getRole().getRole_name().equals("Manager")) {
				return "forward:/admin/index";
			}
		}
		return "forward:/auth/login/form";
	}

	@RequestMapping("/auth/logoff/success")
	public String logoutSuccess(Model model) {
		model.addAttribute("message", "Logout success");
		model.addAttribute("acc", new Account());
		return "user/body/login";
	}

	@RequestMapping("/auth/login/error")
	public String error(Model model) {
		model.addAttribute("error", "Username or Password entered wrong!");
		return "forward:/auth/login/form";
	}

	@RequestMapping("/auth/access/denied")
	public String denied(Model model) {
		Account acc = new Account();
		model.addAttribute("acc", acc);
		model.addAttribute("error", "Ban khong co quyen truy xuat");
		return "user/body/404";
	}

	@Autowired
	UserService userService;

	@RequestMapping("/oauth2/login/success")
	public String success(OAuth2AuthenticationToken oauth2) {
		userService.loginFromOAuth2(oauth2);
		return "forward:/auth/login/success";
	}
}
