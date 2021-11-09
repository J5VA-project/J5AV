package com.J5VA.controller;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

<<<<<<< HEAD
import com.J5VA.entity.customer;
import com.J5VA.service.MailerService;
import com.J5VA.service.ParamService;
import com.J5VA.service.accountService;
import com.J5VA.service.customerService;
=======
import com.J5VA.entity.Account;
import com.J5VA.service.MailerService;
import com.J5VA.service.ParamService;
import com.J5VA.service.AccountService;
>>>>>>> 143e3ba5cc786c2a4c3b8749a641044e07c913fe

@Controller
public class RegisterController {
	@Autowired
<<<<<<< HEAD
	accountService accountService;
	@Autowired
	customerService customerService;
=======
	AccountService accountService;
	@Autowired
	AccountService customerService;
>>>>>>> 143e3ba5cc786c2a4c3b8749a641044e07c913fe
	@Autowired
	ParamService paramService;
	@Autowired
	MailerService mailer;

	// dang ky tai khoan khach hang
	@RequestMapping("/home/register")
	public String registerForm(Model model) {
<<<<<<< HEAD
		customer custo = new customer();
=======
		Account custo = new Account();
>>>>>>> 143e3ba5cc786c2a4c3b8749a641044e07c913fe
		model.addAttribute("custo", custo);
		return "/home/register";
	}

	@PostMapping("/register/validate")
<<<<<<< HEAD
	public String registerValid(Model model, @Valid @ModelAttribute("custo") @RequestBody customer custo,@RequestParam("fullname")String fullname, Errors errors)
			throws MessagingException {
				String username = paramService.getString("username_custo", "");
=======
	public String registerValid(Model model, @Valid @ModelAttribute("custo") @RequestBody Account custo,@RequestParam("fullname")String fullname, Errors errors)
			throws MessagingException {
				String username = paramService.getString("username", "");
>>>>>>> 143e3ba5cc786c2a4c3b8749a641044e07c913fe
				String password = paramService.getString("password", "");
				String confirm = paramService.getString("confirmPass", "");
				String email = paramService.getString("email", "");
		if (!confirm.equals(password)) {
			model.addAttribute("message", "Confirm password doesn't match!");
			return "forward:/home/register";
		} else {
			model.addAttribute("custo", custo);
			customerService.create(custo);
			mailer.send(email, "Account Register","Dear. "+fullname+ ", Wellcome to J5VA Restaurant, hope you like my website, and then my username: "+ username+ ", password: " + password);
			model.addAttribute("message", "Register success!");
			return "forward:/home/register";
		}
	}
}
