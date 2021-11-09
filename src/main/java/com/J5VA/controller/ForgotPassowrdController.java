package com.J5VA.controller;

import java.util.Random;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

<<<<<<< HEAD
import com.J5VA.dao.customerDao;
import com.J5VA.entity.account;
import com.J5VA.entity.customer;
=======
import com.J5VA.dao.AccountDao;
import com.J5VA.entity.Account;
>>>>>>> 143e3ba5cc786c2a4c3b8749a641044e07c913fe
import com.J5VA.service.MailerService;
import com.J5VA.service.ParamService;

@Controller
@RequestMapping("/home/forgot-pw")
public class ForgotPassowrdController {
	@Autowired
<<<<<<< HEAD
	customerDao dao;
=======
	AccountDao dao;
>>>>>>> 143e3ba5cc786c2a4c3b8749a641044e07c913fe
	@Autowired
	ParamService paramService;
	@Autowired
	MailerService mailer;
<<<<<<< HEAD
	
=======

>>>>>>> 143e3ba5cc786c2a4c3b8749a641044e07c913fe
	@GetMapping
	public String runControll(Model model) {
		return "/home/forgot-pwd";
	}
<<<<<<< HEAD
	
=======

>>>>>>> 143e3ba5cc786c2a4c3b8749a641044e07c913fe
	@PostMapping
	public String fogotPost(Model model) throws MessagingException {
		String username = paramService.getString("username", "");
		String email = paramService.getString("email", "");

<<<<<<< HEAD
		customer account = dao.findByUsername(username);
=======
		Account account = dao.findByUsername(username);
>>>>>>> 143e3ba5cc786c2a4c3b8749a641044e07c913fe
		if (account == null) {
			model.addAttribute("msg", "Username invalid!");
		} else {
			Random rand = new Random();
			String newPass = String.format("%06d", rand.nextInt(999999));
			if (account.getEmail().equals(email)) {
				account.setPassword(newPass);
				dao.save(account);
<<<<<<< HEAD
				mailer.send(email, "J5VA reset password", "You just did a password reset, your new password is: " +newPass);
=======
				mailer.send(email, "J5VA reset password",
						"You just did a password reset, your new password is: " + newPass);
>>>>>>> 143e3ba5cc786c2a4c3b8749a641044e07c913fe
				model.addAttribute("msg", "Your password has been emailed. Please check your email again");
			} else {
				model.addAttribute("msg", "Email invalid!");
			}
		}
		return "home/forgot-pwd";
	}
}
