package com.J5VA.controller;

import java.util.Random;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.J5VA.dao.AccountDao;
import com.J5VA.entity.Account;
import com.J5VA.service.MailerService;
import com.J5VA.service.ParamService;

@Controller
@RequestMapping("/home/forgot-pw")
public class ForgotPassowrdController {
	@Autowired
	AccountDao dao;
	@Autowired
	ParamService paramService;
	@Autowired
	MailerService mailer;

	@GetMapping
	public String runControll(Model model) {
		return "/home/forgot-pwd";
	}

	@PostMapping
	public String fogotPost(Model model) throws MessagingException {
		String username = paramService.getString("username", "");
		String email = paramService.getString("email", "");

		Account account = dao.findByUsername(username);
		if (account == null) {
			model.addAttribute("msg", "Username invalid!");
		} else {
			Random rand = new Random();
			String newPass = String.format("%06d", rand.nextInt(999999));
			if (account.getEmail().equals(email)) {
				account.setPassword(newPass);
				dao.save(account);
				mailer.send(email, "J5VA reset password",
						"You just did a password reset, your new password is: " + newPass);
				model.addAttribute("msg", "Your password has been emailed. Please check your email again");
			} else {
				model.addAttribute("msg", "Email invalid!");
			}
		}
		return "home/forgot-pwd";
	}
}
